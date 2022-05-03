package com.huangmaohua.week3;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Life extends HttpServlet {
    @Override
    public void init()throws ServletException{
        System.out.println("I am in init!");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("I am in doget");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("I am in dopost");

    }

    @Override
    public void destroy() {
        System.out.println("I am in dertroy");
    }
}
