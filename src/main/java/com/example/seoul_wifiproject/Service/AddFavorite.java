package com.example.seoul_wifiproject.Service;

import com.example.seoul_wifiproject.dao.InsertTool;
import com.example.seoul_wifiproject.dao.SelectTool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddFavorite", urlPatterns = "/addFavorite")
public class AddFavorite extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String bookmarkName = req.getParameter("bookmarkName");
        String manageNum = req.getParameter("manageNum");

        SelectTool selectTool = new SelectTool();
        String wifiName = selectTool.getWifiNameByManageNum(manageNum);

        InsertTool insertTool = new InsertTool();
        int affected = insertTool.insertFavoriteToDB(bookmarkName, wifiName);

        if(affected > 0){
            resp.setStatus(HttpServletResponse.SC_OK);
        }else{
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
