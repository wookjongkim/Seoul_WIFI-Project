package com.example.seoul_wifiproject.Service;

import com.example.seoul_wifiproject.dao.SelectTool;
import com.example.seoul_wifiproject.dto.WifiInfo;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "getNearbyWifiInfo", urlPatterns = "/get-nearby-wifi")
public class getNearbyWifiInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double lat = Double.parseDouble(req.getParameter("lat"));
        double lon = Double.parseDouble(req.getParameter("lon"));

        SelectTool selectTool = new SelectTool();
        List<WifiInfo> nearbyWifi = selectTool.getNearbyWifiInfo(lat,lon);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        out.print(new Gson().toJson(nearbyWifi));
        out.flush();
    }
}
