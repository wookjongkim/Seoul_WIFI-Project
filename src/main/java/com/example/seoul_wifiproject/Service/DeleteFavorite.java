package com.example.seoul_wifiproject.Service;

import com.example.seoul_wifiproject.dao.DeleteTool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteFavorite", urlPatterns = "/deleteFavorite")
public class DeleteFavorite extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String favoriteId = req.getParameter("favoriteId");

        DeleteTool deleteTool = new DeleteTool();
        int affected = deleteTool.deleteFavoriteById(favoriteId);

        if (affected > 0) {
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}