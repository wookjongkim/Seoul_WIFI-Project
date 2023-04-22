package com.example.seoul_wifiproject.Service;

import com.example.seoul_wifiproject.dao.SelectTool;
import com.example.seoul_wifiproject.dto.Favorite;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "GetFavorites", urlPatterns = "/getFavorites")
public class GetFavorites extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SelectTool selectTool = new SelectTool();
        List<Favorite> favorites = selectTool.getFavorites();
        resp.setContentType("application/json;charset=UTF-8");

        Gson gson = new Gson();
        String json = gson.toJson(favorites);

        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();
    }
}
