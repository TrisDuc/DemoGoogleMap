package control;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import dao.UserDAO;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// Đường dẫn này sẽ là: ws://localhost:8080/Ten_Project/location-ws
@ServerEndpoint("/location-ws") 
public class RescueSocket {

    private static final Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
    private UserDAO userDAO = new UserDAO(); // Khởi tạo DAO
    
    @OnOpen
    public void onOpen(Session session) {
        clients.add(session);
        System.out.println("WebSocket Open: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("Data received: " + message);

        try {
            JsonObject json = JsonParser.parseString(message).getAsJsonObject();
            
            String id = json.get("id").getAsString();
            double lat = json.get("lat").getAsDouble();
            double lng = json.get("lng").getAsDouble();
            
            String type = json.has("type") ? json.get("type").getAsString() : "Citizen";
            
            userDAO.insertLocation(id, type, lat, lng);
            System.out.println("Đã lưu tọa độ User " + id + " vào DB.");
        } catch (JsonSyntaxException e) {
            System.err.println("Lỗi xử lý dữ liệu hoặc lưu DB: " + e.getMessage());
        }
        
        // Gửi tọa độ cho tất cả các client khác để họ thấy vị trí của bạn
        synchronized (clients) {
            for (Session client : clients) {
                if (!client.equals(session) && client.isOpen()) {
                    client.getBasicRemote().sendText(message);
                }
            }
        }
    }

    @OnClose
    public void onClose(Session session) {
        clients.remove(session);
    }

    @OnError
    public void onError(Throwable e) {
        e.printStackTrace();
    }
}