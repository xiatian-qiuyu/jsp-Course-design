package com.hangmaohua.week4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name="Config",value="/Config",
initParams = {
        @WebInitParam(name="name",value = "huang maohau"),
        @WebInitParam(name="studentId",value="2020211001001313")
})

public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = this.getServletConfig().getInitParameter("name");
        String id = this.getServletConfig().getInitParameter("studentId");
        PrintWriter writer=resp.getWriter();
        writer.println("<HTML>");
        writer.println("<HEAD>");
        writer.println("</HEAD>");
        writer.println("<BODY>");
        writer.println("<p>Name: "+name+"</p>");
        writer.println("<p>studentId: "+id+"</p>");
        writer.println("</BODY>");
        writer.println("</HTML>");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

}
