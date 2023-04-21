package com.example.seoul_wifiproject.util;

import lombok.Getter;

import java.net.HttpURLConnection;
import java.net.URL;

public class MakeReqURL {
    private HttpURLConnection conn;

    public MakeReqURL(int startIndex, int endIndex){
        StringBuilder sb = new StringBuilder("http://openapi.seoul.go.kr:8088");
        sb.append("/" + "6e5250556f646e7236306f6b5a5070");
        sb.append("/" + "json");
        sb.append("/" + "TbPublicWifiInfo");
        sb.append("/" + startIndex);
        sb.append("/" + endIndex);

        try{
            URL url = new URL(sb.toString());
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application.json");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public HttpURLConnection getConn() {
        return conn;
    }
}
