package com.hangmaohua.week3;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LifeCycleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String sex = req.getParameter("sex");
        String date = req.getParameter("date");
        req.getSession().setAttribute("username",username);
        req.getSession().setAttribute("password",password);

        PrintWriter writer = resp.getWriter();
        writer.println("Name:"+username);
        writer.println("password:"+password);
        writer.println("email:"+email);
        writer.println("gender:"+sex);
        writer.println("birthDay "+date);

    }
}
