package dao;

import dal.DBContext; // Giả sử bạn để DBContext ở package context
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

        try {
            conn = new DBContext().getConnection();
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
}