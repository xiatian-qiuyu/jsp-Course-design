package com.huangmaohua.lab1;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class MyDearServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        PrintWriter writer = response.getWriter();
        writer.println("<HTML>");
        writer.println("<HEAD>");
        writer.println("</HEAD>");
        writer.println("<BODY>");
        writer.println("<h1>"+"name:huangmaohau"+"</h1>");
        writer.println("<h1>"+"send data to server"+"</h1>");
        writer.println("<h1>"+"class:13"+"</h1>");
        writer.println("<id>"+"class:2020211001001313"+"</h1>");
        writer.println("</BODY>");
        writer.println("</HTML>");

    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
