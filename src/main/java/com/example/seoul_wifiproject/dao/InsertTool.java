package com.example.seoul_wifiproject.dao;

import com.example.seoul_wifiproject.dto.WifiInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class InsertTool {
    public InsertTool(){};
    private final static String url = "jdbc:sqlite:/Users/gim-ugjong/Documents/Seoul_WIFI-Project/identifier.sqlite";
    private final static String className = "org.sqlite.JDBC";

    public void insertWifiInfoToDB(List<WifiInfo> wifiInfoList){
        try{
            Class.forName(className);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = DriverManager.getConnection(url);
            String sql = "INSERT INTO WifiInfo"+
                    "(distanceKm, manageNum, district, wifiName, roadAddress, detailAddress,"+
                    "installationFloor, installationType, installationAgency, serviceType, networkType, "+
                    "installationYear, indoorOutdoor, wifiConnectionEnvironment, xCoordinate, "+
                    "yCoordinate, operationDate)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            for(WifiInfo wifiInfo : wifiInfoList){
                preparedStatement.setDouble(1, wifiInfo.getDistanceKm());
                preparedStatement.setString(2, wifiInfo.getManageNum());
                preparedStatement.setString(3, wifiInfo.getDistrict());
                preparedStatement.setString(4, wifiInfo.getWifiName());
                preparedStatement.setString(5, wifiInfo.getRoadAddress());
                preparedStatement.setString(6, wifiInfo.getDetailAddress());
                preparedStatement.setString(7, wifiInfo.getInstallationFloor());
                preparedStatement.setString(8, wifiInfo.getInstallationType());
                preparedStatement.setString(9, wifiInfo.getInstallationAgency());
                preparedStatement.setString(10, wifiInfo.getServiceType());
                preparedStatement.setString(11, wifiInfo.getNetworkType());
                preparedStatement.setString(12, wifiInfo.getInstallationYear());
                preparedStatement.setString(13, wifiInfo.getIndoorOutdoor());
                preparedStatement.setString(14, wifiInfo.getWifiConnectionEnvironment());
                preparedStatement.setDouble(15, wifiInfo.getXCoordinate());
                preparedStatement.setDouble(16, wifiInfo.getYCoordinate());
                preparedStatement.setString(17, wifiInfo.getOperationDate());

                preparedStatement.addBatch(); // 명령을 배치에 추가
            }
            int[] affectedRows = preparedStatement.executeBatch();
            int cnt = Arrays.stream(affectedRows).sum();
            System.out.println(cnt + "개의 데이터 저장 성공");
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    public void insertHistoryToDB(String xCoordinate, String yCoordinate){
        if(xCoordinate != null && yCoordinate != null){
            try{
                Class.forName(className);
                Connection conn = DriverManager.getConnection(url);
                PreparedStatement pstmt = conn.prepareStatement(
                        "INSERT INTO history(xCoordinate, yCoordinate, InquiryDate)"
                        + " VALUES(?,?,datetime('now'))");
                pstmt.setDouble(1, Double.parseDouble(xCoordinate));
                pstmt.setDouble(2, Double.parseDouble(yCoordinate));
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public int insertBookmarkToDB(String bookmarkName, int groupOrder){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int affected = 0;

        try{
            Class.forName(className);
            connection = DriverManager.getConnection(url);

            String sql = "INSERT INTO bookmark_group (bookmark_name, groupOrder, register_date) VALUES(?,?,?)";
            System.out.println("SQL Query: " + sql); // 추가된 부분
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,bookmarkName);
            preparedStatement.setInt(2,groupOrder);
            preparedStatement.setString(3, LocalDateTime.now().toString());

            affected = preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return affected;
    }
}
