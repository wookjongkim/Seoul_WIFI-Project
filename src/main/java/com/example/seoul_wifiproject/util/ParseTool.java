package com.example.seoul_wifiproject.util;

import com.example.seoul_wifiproject.dto.WifiInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class ParseTool {
    private BufferedReader br;
    public ParseTool(BufferedReader br){
        this.br = br;
    }
    public List<WifiInfo> parseWifiInfo(){
        Gson gson = new Gson();
        JsonObject object = gson.fromJson(br, JsonObject.class);

        JsonObject tbPublicWifiInfo = object.getAsJsonObject("TbPublicWifiInfo");
        JsonArray wifiArr = tbPublicWifiInfo.getAsJsonArray("row");

        List<WifiInfo> wifiInfoList = new ArrayList<>();
        for(int i = 0; i < wifiArr.size(); i++){
            WifiInfo wifiInfo = new WifiInfo();
            wifiInfo.setDistanceKm(0);
            JsonObject obj = wifiArr.get(i).getAsJsonObject();
            wifiInfo.setManageNum(obj.get("X_SWIFI_MGR_NO").getAsString());
            wifiInfo.setDistrict(obj.get("X_SWIFI_WRDOFC").getAsString());
            wifiInfo.setWifiName(obj.get("X_SWIFI_MAIN_NM").getAsString());
            wifiInfo.setRoadAddress(obj.get("X_SWIFI_ADRES1").getAsString());
            wifiInfo.setDetailAddress(obj.get("X_SWIFI_ADRES2").getAsString());
            wifiInfo.setInstallationFloor(obj.get("X_SWIFI_INSTL_FLOOR").getAsString());
            wifiInfo.setInstallationType(obj.get("X_SWIFI_INSTL_TY").getAsString());
            wifiInfo.setInstallationAgency(obj.get("X_SWIFI_INSTL_MBY").getAsString());
            wifiInfo.setServiceType(obj.get("X_SWIFI_SVC_SE").getAsString());
            wifiInfo.setNetworkType(obj.get("X_SWIFI_CMCWR").getAsString());
            wifiInfo.setInstallationYear(obj.get("X_SWIFI_CNSTC_YEAR").getAsString());
            wifiInfo.setIndoorOutdoor(obj.get("X_SWIFI_INOUT_DOOR").getAsString());
            wifiInfo.setWifiConnectionEnvironment(obj.get("X_SWIFI_REMARS3").getAsString());
            wifiInfo.setXCoordinate(obj.get("LNT").getAsDouble());
            wifiInfo.setYCoordinate(obj.get("LAT").getAsDouble());
            wifiInfo.setOperationDate(obj.get("WORK_DTTM").getAsString());
            wifiInfoList.add(wifiInfo);
        }
        return wifiInfoList;
    }
}
