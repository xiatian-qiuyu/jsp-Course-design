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

@WebServlet(name = "UpdateUserServlet",value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    private Connection connection;
    @Override
    public void init() throws ServletException {
        connection= (Connection) this.getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        long id=((User)session.getAttribute("user")).getId();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String date = req.getParameter("date");
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(String.valueOf(Long.parseLong(gender)));
        user.setBirthdate(Date.valueOf(date));
        UserDao userDao = new UserDao();
        try {
            int n = userDao.updateUser(connection,user);
            User updatedUser = userDao.findById(connection, (int) id);
            session.removeAttribute("user");
            session.setAttribute("user",updatedUser);
            req.getRequestDispatcher("accountDetails").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}