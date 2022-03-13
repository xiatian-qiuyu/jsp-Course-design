package com.hangmaohua.week3;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
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
        writer.println("<HTML>");
        writer.println("<HEAD>");
        writer.println("</HEAD>");
        writer.println("<BODY>");
        writer.println("<p>Name:"+username+"</p>");
        writer.println("<p>password:"+password+"<p>");
        writer.println("<p>email:"+email+"</p>");
        writer.println("<p>gender:"+sex+"</p>");
        writer.println("<p>birthDay "+date+"</p>");
        writer.println("</BODY>");
        writer.println("</HTML>");
    }
}
