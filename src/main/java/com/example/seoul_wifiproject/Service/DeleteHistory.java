package com.example.seoul_wifiproject.Service;

import com.example.seoul_wifiproject.dao.DeleteTool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteHistory", urlPatterns = "/deleteHistory")
public class DeleteHistory extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        DeleteTool deleteTool = new DeleteTool();
        deleteTool.delHistory(id);
    }
}
