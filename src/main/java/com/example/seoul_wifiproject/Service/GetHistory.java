package com.example.seoul_wifiproject.Service;

import com.example.seoul_wifiproject.dao.SelectTool;
import com.example.seoul_wifiproject.dto.History;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GetHistory", urlPatterns = "/getHistory")
public class GetHistory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        SelectTool selectTool = new SelectTool();
        List<History> historyList = selectTool.getHistory();

        String jsonData = new Gson().toJson(historyList);
        resp.getWriter().write(jsonData);
    }
}
