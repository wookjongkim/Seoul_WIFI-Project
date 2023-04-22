package com.example.seoul_wifiproject.Service;

import com.example.seoul_wifiproject.dao.SelectTool;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetBookmarkNameList", urlPatterns = "/getBookmarkNameList")
public class GetBookmarkNameList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SelectTool selectTool = new SelectTool();
        List<String> bookmarkNames = selectTool.getBookmarkNames();

        Gson gson = new Gson();
        String json = gson.toJson(bookmarkNames);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
