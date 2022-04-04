<%--
  Created by IntelliJ IDEA.
  User: xiatian0708
  Date: 2022/4/4
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<h1>user info</h1>
<table border="5">
    <tr><td>username:</td><td><%=request.getAttribute("username")%></td></tr>
    <tr><td>password:</td><td><%=request.getAttribute("password")%></td></tr>
    <tr><td>email:</td><td><%=request.getAttribute("email")%></td></tr>
    <tr><td>gender:</td><td><%=request.getAttribute("gender")%></td></tr>
    <tr><td>birth date:</td><td><%=request.getAttribute("birthdate")%></td></tr>
</table>
<%@include file="footer.jsp"%>
