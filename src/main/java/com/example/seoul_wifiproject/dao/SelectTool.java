package com.example.seoul_wifiproject.dao;

import com.example.seoul_wifiproject.dto.History;
import com.example.seoul_wifiproject.dto.WifiInfo;
import com.google.gson.Gson;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.example.seoul_wifiproject.util.calculateUtil.calculateDistance;

public class SelectTool {
    public SelectTool(){};

    private final static String url = "jdbc:sqlite:/Users/gim-ugjong/Documents/Seoul_WIFI-Project/identifier.sqlite";
    private final static String className = "org.sqlite.JDBC";

    public List<WifiInfo> getNearbyWifiInfo(double userLat, double userLon){
        List<WifiInfo> nearbyWifiList = new ArrayList<>();
        List<WifiInfo> wifiInfoList = new ArrayList<>();
        String query = "SELECT "+
                "manageNum, district, wifiName, roadAddress, detailAddress, " +
                "installationFloor, installationType, installationAgency, serviceType, networkType, "+
                "installationYear, indoorOutdoor, wifiConnectionEnvironment, xCoordinate, yCoordinate, operationDate " +
                "FROM WifiInfo";
        try{
            Class.forName(className);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            Connection connection = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                WifiInfo wifiInfo = new WifiInfo();
                wifiInfo.setManageNum(resultSet.getString("manageNum"));
                wifiInfo.setDistrict(resultSet.getString("district"));
                wifiInfo.setWifiName(resultSet.getString("wifiName"));
                wifiInfo.setRoadAddress(resultSet.getString("roadAddress"));
                wifiInfo.setDetailAddress(resultSet.getString("detailAddress"));
                wifiInfo.setInstallationFloor(resultSet.getString("installationFloor"));
                wifiInfo.setInstallationType(resultSet.getString("installationType"));
                wifiInfo.setInstallationAgency(resultSet.getString("installationAgency"));
                wifiInfo.setServiceType(resultSet.getString("serviceType"));
                wifiInfo.setNetworkType(resultSet.getString("networkType"));
                wifiInfo.setInstallationYear(resultSet.getString("installationYear"));
                wifiInfo.setIndoorOutdoor(resultSet.getString("indoorOutdoor"));
                wifiInfo.setWifiConnectionEnvironment(resultSet.getString("wifiConnectionEnvironment"));
                wifiInfo.setXCoordinate(resultSet.getDouble("xCoordinate"));
                wifiInfo.setYCoordinate(resultSet.getDouble("yCoordinate"));
                wifiInfo.setOperationDate(resultSet.getString("operationDate"));
                wifiInfoList.add(wifiInfo);
            }
            for(WifiInfo wifiInfo : wifiInfoList){
                double distance = calculateDistance(userLat, userLon, wifiInfo.getXCoordinate(), wifiInfo.getYCoordinate());
                wifiInfo.setDistanceKm(distance);
            }
            wifiInfoList.sort(Comparator.comparingDouble(WifiInfo::getDistanceKm));

            // 가까운 20개 정보 반환
            for(int i = 0; i < 20 && i < wifiInfoList.size(); i++){
                nearbyWifiList.add(wifiInfoList.get(i));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return nearbyWifiList;
    }
    public List<History> getHistory(){
        List<History> historyList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            Class.forName(className);
            conn = DriverManager.getConnection(url);
            pstmt = conn.prepareStatement("SELECT * from history");
            rs = pstmt.executeQuery();

            while(rs.next()){
                History history = new History();
                history.setId(rs.getInt("id"));
                history.setXCoordinate(rs.getDouble("xCoordinate"));
                history.setYCoordinate(rs.getDouble("yCoordinate"));
                history.setInquiryDate(rs.getString("InquiryDate"));
                historyList.add(history);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
        return historyList;
    }
    public WifiInfo getWifiDetail(String manageNum){

            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            WifiInfo wifiInfo = null;

            try{
                Class.forName(className);
                connection = DriverManager.getConnection(url);
                String sql = "SELECT * FROM WifiInfo WHERE manageNum = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, manageNum);

                resultSet = preparedStatement.executeQuery();

                if(resultSet.next()){
                    wifiInfo = new WifiInfo();
                    wifiInfo.setDistanceKm(resultSet.getDouble("distanceKm"));
                    wifiInfo.setManageNum(resultSet.getString("manageNum"));
                    wifiInfo.setDistrict(resultSet.getString("district"));
                    wifiInfo.setWifiName(resultSet.getString("wifiName"));
                    wifiInfo.setRoadAddress(resultSet.getString("roadAddress"));
                    wifiInfo.setDetailAddress(resultSet.getString("detailAddress"));
                    wifiInfo.setInstallationFloor((resultSet.getString("installationFloor")));
                    wifiInfo.setInstallationType(resultSet.getString("installationType"));
                    wifiInfo.setInstallationAgency(resultSet.getString("installationAgency"));
                    wifiInfo.setServiceType(resultSet.getString("serviceType"));
                    wifiInfo.setNetworkType(resultSet.getString("networkType"));
                    wifiInfo.setInstallationYear(resultSet.getString("installationYear"));
                    wifiInfo.setIndoorOutdoor(resultSet.getString("indoorOutdoor"));
                    wifiInfo.setWifiConnectionEnvironment(resultSet.getString("wifiConnectionEnvironment"));
                    wifiInfo.setXCoordinate(resultSet.getDouble("xCoordinate"));
                    wifiInfo.setYCoordinate(resultSet.getDouble("yCoordinate"));
                    wifiInfo.setOperationDate(resultSet.getString("operationDate"));
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return wifiInfo;
        }
}
