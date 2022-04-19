<%@ page import="java.io.PrintWriter" %>
<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: xiatian0708
  Date: 2022/3/27
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%if(!(request.getAttribute("message")==null)){
    out.println("<h3>"+request.getAttribute("message")+"</h3>");
}%>
<%
    Cookie[] allCookies = request.getCookies();
    String username = "",password = "",remember = "0";
    if(allCookies!=null){
        for(Cookie c:allCookies){
            //get one by one
            if(c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if(c.getName().equals("cPassword")){
                password=c.getValue();
            }
            if(c.getName().equals("cRemember")){
                remember=c.getValue();
            }
        }
    }
%>
<form action="Login" method="post" name="form" accept-charset="UTF-8" onsubmit="return register()">
    <h3>New User Registration</h3>
    <input type="text" name="username" value="<%=username%>" id="username" placeholder="username" ><span id="span1"></span><br>
    <input type="password" id="password"value="<%=password%>" name="password" placeholder="password"><br>
    <input type="checkbox" name="rememberMe" checked value="1" <%=Objects.equals(remember, "1") ?"checked":""%>/>Remember Me<br>
    <input type="submit" value="Submit">
</form>
<script>
    function register(){
        let username = document.getElementById("username").value;
        if(username == null || username === ''){
            alert("username must be not null!")
            //document.getElementById("span1").innerHTML="不能为空"
            return false;
        }
        let password = document.getElementById("password").value;
        if(password == null || password ===''){
            alert("password must be not null!")
            return false;
        }
        if(password.length<8){
            alert("length must be at least 8 characters!");
            return false;
        }
    }
</script>

<%@include file="footer.jsp"%>