package com.example.seoul_wifiproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTool {
    public DeleteTool() {
    }

    private final static String url = "jdbc:sqlite:/Users/gim-ugjong/Documents/Seoul_WIFI-Project/identifier.sqlite";
    private final static String className = "org.sqlite.JDBC";

    public void delHistory(String id){
        if(id != null){
            try{
                Class.forName(className);
                Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement("DELETE FROM history WHERE id = ?");
                pstmt.setInt(1,Integer.parseInt(id));
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public int deleteBookmark(int id) {
        int affected = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            Class.forName(className);
            conn = DriverManager.getConnection(url);
            pstmt = conn.prepareStatement("DELETE FROM bookmark_group WHERE id =?");
            pstmt.setInt(1,id);
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
