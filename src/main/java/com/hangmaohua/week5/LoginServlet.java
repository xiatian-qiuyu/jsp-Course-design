package com.hangmaohua.week5;

import com.hangmaohua.dao.UserDao;
import com.hangmaohua.model.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet",value = "/Login")
public class LoginServlet extends HttpServlet {
    private Connection con;
    @Override
    public void init() {
//        ServletContext context =this.getServletContext();
//        con=null;
//        String driver=context.getInitParameter("driver");
//        String url = context.getInitParameter("url");
//        String username=context.getInitParameter("username");
//        String password=context.getInitParameter("password");
//        try{
//            Class.forName(driver);
//            con = DriverManager.getConnection(url, username, password);
//            System.out.println("connetion: "+con);
//        }catch (ClassNotFoundException| SQLException e){
//            e.printStackTrace();
//        }
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDao userDao = new UserDao();
        try {
            User user = userDao.findByUsernamePassword(con, username, password);
            if (user!=null){
                if(req.getParameter("rememberMe").equals("1")){
                    //create cookies
                    Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie = new Cookie("cPassword", user.getPassword());
                    Cookie rememberCookie =new Cookie("cRemember",req.getParameter("rememberMe"));
                    //setage
                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberCookie.setMaxAge(5);
                    //add cookie into response
                    resp.addCookie(usernameCookie);
                    resp.addCookie(passwordCookie);
                    resp.addCookie(rememberCookie);
                }
                //create session
                HttpSession session = req.getSession();
                System.out.println("session id--"+session.getId());

                session.setAttribute("user",user);
                req.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(req,resp);
            }else{
                req.setAttribute("message","username or password error!!!");
                req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

//                writer.println("<p>"+"Login Success!"+"</p>");
//                writer.println("<p>"+"Welcome"+username+"</p>");
                req.setAttribute("id",resultSet.getInt("id"));
                req.setAttribute("username",resultSet.getString("username"));
                req.setAttribute("password",resultSet.getString("password"));
                req.setAttribute("email",resultSet.getString("email"));
                req.setAttribute("gender",resultSet.getString("gender"));
                req.setAttribute("birthdate",resultSet.getString("birthdate"));

                req.getRequestDispatcher("userinfo.jsp").forward(req,resp);
            }else{
//                writer.println("Username or Password Error!!!");
                //resp.sendRedirect("week2/register.jsp");
                req.setAttribute("message","username or password error!!!");
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }
            writer.println("</BODY>");
            writer.println("</HTML>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
