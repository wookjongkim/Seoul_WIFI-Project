package com.example.seoul_wifiproject.Service;

import com.example.seoul_wifiproject.dao.InsertTool;
import com.example.seoul_wifiproject.dto.WifiInfo;
import com.example.seoul_wifiproject.util.MakeReqURL;
import com.example.seoul_wifiproject.util.ParseTool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.List;

import static com.example.seoul_wifiproject.util.TotalCnt.getDataTotalCount;

@WebServlet(name = "LoadWifiData", urlPatterns = "/load-wifi-data")
public class LoadWifiData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int total = getDataTotalCount();
        for(int i = 1; i <= (total/1000) + 1; i++){
            int startIndex = (i==1)? 1: 1+(1000 * (i-1));
            int endIndex = startIndex + (1000-1);

            MakeReqURL makeReqURL = new MakeReqURL(startIndex,endIndex);
            HttpURLConnection connection = makeReqURL.getConn();

            BufferedReader br;
            if(connection.getResponseCode() >= 200 && connection.getResponseCode() <= 300){
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                ParseTool parseTool = new ParseTool(br);
                List<WifiInfo> list = parseTool.parseWifiInfo();
                InsertTool insertTool = new InsertTool();
                insertTool.insertWifiInfoToDB(list);
            }
        }
        HttpSession session = req.getSession();
        session.setAttribute("total", total);
        resp.sendRedirect("load-wifi.jsp");
    }
}
