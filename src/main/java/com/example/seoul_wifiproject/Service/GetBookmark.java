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
import java.util.List;

@WebServlet(name = "GetBookmark", urlPatterns = "/getBookmark")
public class GetBookmark extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        SelectTool selectTool = new SelectTool();
        List<Bookmark> bookmarkList = selectTool.getBookmarkGroups();

        String jsonData = new Gson().toJson(bookmarkList);
        resp.getWriter().write(jsonData);
    }
}
