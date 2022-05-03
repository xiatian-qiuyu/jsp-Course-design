package com.huangmaohua.controller;

import com.huangmaohua.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.swing.*;
import java.io.IOException;
@WebServlet(name = "AdminHomeServlet",value="/admin/home")
public class AdminHomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
    if(session!=null&&session.getAttribute("user")!=null){
        User user = (User) session.getAttribute("user");
        if("admin".equals(user.getUsername())){
            req.getRequestDispatcher("../WEB-INF/views/admin/index.jsp").forward(req,resp);
        }else{
            //not admin user
            session.invalidate();//kill session
            req.setAttribute("message","Unauthorized Access admin module");
            req.getRequestDispatcher("../WEB-INF/views/login.jsp").forward(req,resp);
        }
    }else {//ask for login
        req.setAttribute("message","Please login as admin");
        req.getRequestDispatcher("../WEB-INF/views/login.jsp").forward(req,resp);
    }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
