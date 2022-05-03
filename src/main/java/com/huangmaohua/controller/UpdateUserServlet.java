package com.huangmaohua.controller;

import com.huangmaohua.dao.UserDao;
import com.huangmaohua.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name="UpdateUserServlet",value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {

    Connection con;

    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        java.sql.Date birthdate = Date.valueOf(req.getParameter("birthdate"));
        User user = new User();

        user.setId(id);
        user.setUsername(username);
        user.setBirthdate((Date) birthdate);
        user.setEmail(email);
        user.setGender(gender);
        user.setPassword(password);

        UserDao userdao = new UserDao();
        int result=0;
        try {
            result= userdao.updateUser(con, user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(result>0){
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            req.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(req,resp);
        }

    }
}
