package com.hangmaohua.week5;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet",value = "/Login")
public class LoginServlet extends HttpServlet {
    private Connection con;
    @Override
    public void init() {
        ServletContext context =this.getServletContext();
        con=null;
        String driver=context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("connetion: "+con);
        }catch (ClassNotFoundException| SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        String sql1="INSERT INTO USERTABLE(username,password) VALUES(?,?)";
//        try {
//            PreparedStatement preparedStatement=con.prepareStatement(sql1);
//            preparedStatement.setString(1,username);
//            preparedStatement.setString(2,password);
//
//            int result = preparedStatement.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        String sql2 ="SELECT* FROM USERTABLE WHERE USERNAME='"+username+"' AND PASSWORD='"+password+"'";
        try {
            PreparedStatement preparedStatement=con.prepareStatement(sql2);
            ResultSet resultSet = preparedStatement.executeQuery(sql2);
            PrintWriter writer = resp.getWriter();
            writer.println("<HTML>");
            writer.println("<HEAD>");
            writer.println("</HEAD>");
            writer.println("<BODY>");
            if(resultSet.next()){

                writer.println("<p>"+"Login Success!"+"</p>");
                writer.println("<p>"+"Welcome"+username+"</p>");
            }else{
                writer.println("Username or Password Error!!!");
                //resp.sendRedirect("week2/register.jsp");
            }
            writer.println("</BODY>");
            writer.println("</HTML>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
