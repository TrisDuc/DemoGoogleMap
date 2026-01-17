package model;

import java.sql.Timestamp;

public class UserLocation {
    private String userID;
    private String userType;
    private double latitude;
    private double longitude;
    private Timestamp lastUpdate;

    // Constructor, Getters và Setters
    public UserLocation() {}

    public UserLocation(String userID, String userType, double latitude, double longitude, Timestamp lastUpdate) {
        this.userID = userID;
        this.userType = userType;
        this.latitude = latitude;
        this.longitude = longitude;
        this.lastUpdate = lastUpdate;
    }

    // (Bạn nhớ Generate Getters/Setters trong NetBeans bằng cách nhấn Alt + Insert nhé)
    public String getUserID() { return userID; }
    public String getUserType() { return userType; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public Timestamp getLastUpdate() { return lastUpdate; }
}