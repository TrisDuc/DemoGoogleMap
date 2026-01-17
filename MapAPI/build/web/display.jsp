<!--
<!DOCTYPE html>
<html>
    <head>
        <title>User Location List</title>
        <style>
            table { width: 80%; border-collapse: collapse; margin: 20px auto; }
            th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
            th { background-color: #f2f2f2; }
        </style>
    </head>
    <body>
        <h2 style="text-align: center;">Danh sách vị trí người dùng</h2>
        <table>
            <tr>
                <th>UserID</th>
                <th>User Type</th>
                <th>Latitude</th>
                <th>Longitude</th>
                <th>Last Update</th>
            </tr>
            <c:forEach items="${data}" var="u">
                <tr>
                    <td>${u.userID}</td>
                    <td>${u.userType}</td>
                    <td>${u.latitude}</td>
                    <td>${u.longitude}</td>
                    <td>${u.lastUpdate}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

-->

<%@page import="model.UserLocation"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách vị trí</title>
    <style>
        table { width: 80%; border-collapse: collapse; margin: 20px auto; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h2 style="text-align: center;">Danh sách vị trí người dùng</h2>
    <table>
        <tr>
            <th>UserID</th>
            <th>User Type</th>
            <th>Latitude</th>
            <th>Longitude</th>
        </tr>
        <%
            // Lấy list "data" từ Servlet gửi sang
            List<UserLocation> list = (List<UserLocation>) request.getAttribute("data");
            if (list != null) {
                for (UserLocation u : list) {
        %>
        <tr>
            <td><%= u.getUserID() %></td>
            <td><%= u.getUserType() %></td>
            <td><%= u.getLatitude() %></td>
            <td><%= u.getLongitude() %></td>
        </tr>
        <% 
                }
            } else {
        %>
        <tr><td colspan="4">Không có dữ liệu truyền sang Servlet!</td></tr>
        <% } %>
    </table>
</body>
</html>