package com.hangmaohua.week6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String txt =req.getParameter("txt");
        txt=URLEncoder.encode(txt, StandardCharsets.UTF_8);
        String select =req.getParameter("search");
        if(Objects.equals(txt, "")){
            resp.sendRedirect("index.jsp");
        }else {
            if (Objects.equals(select, "baidu")){
                resp.sendRedirect("https://www.baidu.com/s?wd="+txt);
            }else if (Objects.equals(select, "bing")){
                resp.sendRedirect("https://cn.bing.com/search?q="+txt);
            }else if (Objects.equals(select, "google")){
                resp.sendRedirect("http://www.google.com/search?q="+txt);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
