package com.example.seoul_wifiproject.Service;


import com.example.seoul_wifiproject.dao.InsertTool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SaveHistoryServlet", urlPatterns = "/saveHistory")
public class PostHistory extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String xCoordinate = req.getParameter("xCoordinate");
        String yCoordinate = req.getParameter("yCoordinate");
        InsertTool insertTool = new InsertTool();
        insertTool.insertHistoryToDB(xCoordinate, yCoordinate);
    }
}
