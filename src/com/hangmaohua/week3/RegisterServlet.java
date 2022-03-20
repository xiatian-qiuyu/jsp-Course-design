package com.hangmaohua.week3;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name="register",value = "/register")
public class RegisterServlet extends HttpServlet {
    private Connection con;
    @Override
    public void init() throws ServletException {
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
        String email = req.getParameter("email");
        String gender = req.getParameter("sex");
        String birthdate = req.getParameter("date");
        String sql="INSERT INTO USERTABLE(username,password,email,gender,birthdate) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement=con.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,email);
            preparedStatement.setString(4,gender);
            preparedStatement.setDate(5, Date.valueOf(birthdate));
            int result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        PrintWriter writer = resp.getWriter();
        writer.println("<HTML>");
        writer.println("<HEAD>");
        writer.println("</HEAD>");
        writer.println("<BODY>");
        writer.println("<table border='5'><tr><th>ID</th><th>UserName</th><th>Password</th><th>Email</th><th>Gender</th><th>BirthDate</th></tr>");
        String sql1 ="SELECT ID,USERNAME,PASSWORD,EMAIL,GENDER,BIRTHDATE FROM USERTABLE";
        try{
            PreparedStatement preparedStatement=con.prepareStatement(sql1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                writer.println("<tr><td>" +resultSet.getInt("ID")+"</td><td>"+resultSet.getString("username")+ "</td><td>"+resultSet.getString("password")+ "</td><td>"+resultSet.getString("email")+ "</td><td>"+resultSet.getString("gender")+ "</td><td>" +resultSet.getString("birthdate")+"</td></tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        writer.println("</table>");
        writer.println("</BODY>");
        writer.println("</HTML>");
    }
}
