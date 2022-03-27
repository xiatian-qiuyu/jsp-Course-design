<%--
  Created by IntelliJ IDEA.
  User: xiatian0708
  Date: 2022/3/27
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/Login" name="form" method="post" accept-charset="UTF-8" onsubmit="return register()">
    <h3>New User Registration</h3>
    <input type="text" name="username" id="username" placeholder="username" ><span id="span1"></span><br>
    <input type="password" id="password" name="password" placeholder="password"><br>
    <input type="submit" value="Register">
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
</body>
</html>
<%@include file="footer.jsp"%>