package com.example.seoul_wifiproject.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class TotalCnt {
    public static int getDataTotalCount(){
        MakeReqURL makeReqURL = new MakeReqURL(1,2);
        HttpURLConnection connection = makeReqURL.getConn();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(br, JsonObject.class);
        JsonObject tbPublicWifiInfo = jsonObject.getAsJsonObject("TbPublicWifiInfo");
        int totalCnt = tbPublicWifiInfo.get("list_total_count").getAsInt();
        return totalCnt;
    }
}
