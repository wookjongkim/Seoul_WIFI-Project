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

@WebServlet(name = "GetWifiDetail", urlPatterns = "/get-wifi-detail")
public class GetWifiDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String manageNum = req.getParameter("manageNum");

        SelectTool selectTool = new SelectTool();
        WifiInfo wifiInfo = selectTool.getWifiDetail(manageNum);

        Gson gson = new Gson();
        String json = gson.toJson(wifiInfo);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();

    }
}
