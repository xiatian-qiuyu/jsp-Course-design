<%@ page import="com.hangmaohua.model.User" %><%--
  Created by IntelliJ IDEA.
  User: xiatian0708
  Date: 2022/4/4
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<h1>user info</h1>
<%
    User user=(User) request.getAttribute("user");
%>
<table border="5">
    <tr><td>username:</td><td><%=user.getUsername()%></td></tr>
    <tr><td>password:</td><td><%=user.getPassword()%></td></tr>
    <tr><td>email:</td><td><%=user.getEmail()%></td></tr>
    <tr><td>gender:</td><td><%=user.getGender()%></td></tr>
    <tr><td>birth date:</td><td><%=user.getBirthdate()%></td></tr>
</table>
<%@include file="footer.jsp"%>
