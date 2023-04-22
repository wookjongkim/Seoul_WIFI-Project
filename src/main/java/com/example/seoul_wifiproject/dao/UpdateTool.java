package com.example.seoul_wifiproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class UpdateTool {
    public UpdateTool() {}
    private final static String url = "jdbc:sqlite:/Users/gim-ugjong/Documents/Seoul_WIFI-Project/identifier.sqlite";
    private final static String className = "org.sqlite.JDBC";

    public int updateBookmark(int id, String bookmarkName, int groupOrder) {
        int affected = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName(className);
            conn = DriverManager.getConnection(url);
            pstmt = conn.prepareStatement("UPDATE bookmark_group SET bookmark_name=?, groupOrder=?, modified_date=? WHERE id=?");
            pstmt.setString(1, bookmarkName);
            pstmt.setInt(2, groupOrder);
            pstmt.setString(3, LocalDateTime.now().toString());
            pstmt.setInt(4, id);
            affected = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return affected;
    }
}
