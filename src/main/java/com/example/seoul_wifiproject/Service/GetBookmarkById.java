package com.example.seoul_wifiproject.Service;

import com.example.seoul_wifiproject.dao.SelectTool;
import com.example.seoul_wifiproject.dto.Bookmark;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GETBookmarkById", urlPatterns = "/getBookmarkById")
public class GetBookmarkById extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        SelectTool selectTool = new SelectTool();
        Bookmark bookmark = selectTool.getBookmarkById(id);

        String jsonData = new Gson().toJson(bookmark);
        resp.getWriter().write(jsonData);
    }
}
