package com.example.seoul_wifiproject.Service;

import com.example.seoul_wifiproject.dao.InsertTool;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet(name = "AddBookmark", urlPatterns = "/add-bookmark-group")
public class AddBookmark extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String bookmarkName = req.getParameter("bookmark_name");
        int groupOrder = Integer.parseInt(req.getParameter("group_order"));

        InsertTool insertTool = new InsertTool();
        int affected = insertTool.insertBookmarkToDB(bookmarkName, groupOrder);

        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();

        if (affected > 0) {
            out.println("북마크 그룹 정보를 추가하였습니다!");
        } else {
            out.println("북마크 그룹 정보 추가 실패.");
        }
    }
}
