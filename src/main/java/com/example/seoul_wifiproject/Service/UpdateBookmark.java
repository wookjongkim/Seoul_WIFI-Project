package com.example.seoul_wifiproject.Service;

import com.example.seoul_wifiproject.dao.UpdateTool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdateBookmark", urlPatterns = "/updateBookmark")
public class UpdateBookmark extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));
        String bookmarkName = req.getParameter("bookmark_name");
        int groupOrder = Integer.parseInt(req.getParameter("group_order"));

        UpdateTool updateTool = new UpdateTool();
        int affected = updateTool.updateBookmark(id,bookmarkName,groupOrder);

        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();

        if(affected > 0){
            out.println("수정이 완료되었습니다.");
        }else{
            out.println("수정이 실패하였습니다.");
        }
    }
}
