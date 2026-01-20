package dao;

import dal.DBContext; // Giả sử bạn để DBContext ở package context
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.UserLocation;

public class UserDAO {   
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<UserLocation> getAllUsers() {
        List<UserLocation> list = new ArrayList<>();
        String query = "SELECT * FROM UserLocations"; // Thay tên bảng của bạn vào đây

        // Try-with-resources that auto release conn, ps, rs
        try (Connection conn = new DBContext().getConnection()){
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new UserLocation(
                        rs.getString("UserID"),
                        rs.getString("UserType"),
                        rs.getDouble("Latitude"),
                        rs.getDouble("Longitude"),
                        rs.getTimestamp("LastUpdate")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
//    public void insertLocation(String id, String type, double lat, double lng) {
//        String query = "MERGE INTO UserLocations AS target " +
//                   "USING (SELECT ? AS UserID) AS source " +
//                   "ON (target.UserID = source.UserID) " +
//                   "WHEN MATCHED THEN " +
//                   "    UPDATE SET Latitude = ?, Longitude = ?, UserType = ?, LastUpdate = GETDATE() " +
//                   "WHEN NOT MATCHED THEN " +
//                   "    INSERT (UserID, UserType, Latitude, Longitude, LastUpdate) " +
//                   "    VALUES (?, ?, ?, ?, GETDATE());";        
//        try (Connection conn = new DBContext().getConnection()) {
//            PreparedStatement ps = conn.prepareStatement(query);
//            // Dữ liệu cho phần check và Update
//            ps.setString(1, id);
//            ps.setDouble(2, lat);
//            ps.setDouble(3, lng);
//            ps.setString(4, type);
//            // Dữ liệu cho phần Insert mới
//            ps.setString(5, id);
//            ps.setString(6, type);
//            ps.setDouble(7, lat);
//            ps.setDouble(8, lng);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
     public void insertLocation(String id, String type, double lat, double lng) {
        String query = "INSERT INTO UserLocations (UserID, UserType, Latitude, Longitude, LastUpdate) VALUES (?, ?, ?, ?, GETDATE())";

        Connection conn = new DBContext().getConnection();
        if (conn == null) {
            System.out.println("❌ KHÔNG THỂ KẾT NỐI DB! Kiểm tra lại URL, User, Pass.");
            return;
        }

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, id);
            ps.setString(2, type);
            ps.setDouble(3, lat);
            ps.setDouble(4, lng);

            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("✅ ĐÃ LƯU THÀNH CÔNG: UserID = " + id);
            } else {
                System.out.println("⚠️ Lệnh chạy nhưng không có dòng nào được thêm.");
            }
        } catch (SQLException e) {
            System.out.println("❌ LỖI SQL: " + e.getMessage());
        } finally {
            try { conn.close(); } catch (Exception e) {}
        }
    }
}