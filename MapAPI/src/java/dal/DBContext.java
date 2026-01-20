package dal;

import dao.UserDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UserLocation;

public class DBContext {
    protected Connection connection;
    public Connection getConnection() {
        try {
            // 1. Cấu hình thông tin
            String user = "sa";
            String pass = "sa";
            // LƯU Ý: Đổi 'DemoMap' thành tên Database chính xác của bạn trong SQL Server
            String url = "jdbc:sqlserver://localhost:1433;databaseName=DemoMap;encrypt=true;trustServerCertificate=true";
            
            // 2. Đăng ký Driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            // 3. Mở kết nối
            connection = DriverManager.getConnection(url, user, pass);
            return connection;
            
        } catch (ClassNotFoundException | SQLException ex) {
            // In lỗi chi tiết ra console để kiểm tra nếu thất bại
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, "Lỗi kết nối CSDL", ex);
        }
        return null;
    }
}

