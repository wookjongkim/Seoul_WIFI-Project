package com.example.seoul_wifiproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
}
