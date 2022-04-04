<%--
  Created by IntelliJ IDEA.
  User: xiatian0708
  Date: 2022/3/5
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
  <h1>welcome to my online shop homework</h1>
<%--  <br>--%>
<%--  <a href="HelloWorld">Helloworld Servlet-week1</a>--%>
<%--  <br>--%>
<%--  <a href="hello">Student Info Servlet-week2</a>--%>
<%--  <br>--%>
<%--  <a href="LifeCycleServlet">Life Cycle Servlet-week3</a>--%>
<%--  <br>--%>
<%--  <a href="week2/register.jsp">Register-getParameter-week3</a>--%>
<%--  <br>--%>
<%--  <a href="Config">Config parameter-week4</a>--%>
<%--  <br>--%>
<%--  <a href="week2/register.jsp">Register-JDBC-week4</a>--%>
<%--  <br>--%>
<%--  <a href="index.jsp">include-week5</a>--%>
<%--  <br>--%>
<%--  <a href="login.jsp">Login-week5</a>--%>
  <form method="get" target="_blank" action="search">
      <input type="text" name="txt" size="30">
      <select name="search">
        <option value="baidu">baidu</option>
        <option value="bing">bing</option>
        <option value="google">google</option>
      </select>
      <input type="submit" value="search">
  </form>
<%@include file="footer.jsp"%>

