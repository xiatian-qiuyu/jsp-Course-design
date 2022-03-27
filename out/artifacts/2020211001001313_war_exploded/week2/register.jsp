<%--
  Created by IntelliJ IDEA.
  User: xiatian0708
  Date: 2022/3/5
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../header.jsp" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
 <form action="${pageContext.request.contextPath}/register" name="form" method="post" accept-charset="UTF-8" onsubmit="return register()">
     <h3>New User Registration</h3>
     <input type="text" name="username" id="username" placeholder="username" ><span id="span1"></span><br>
     <input type="password" id="password" name="password" placeholder="password"><br>
     <input type="email" id="email" name="email" placeholder="email"> <br>
     <strong>Gender</strong> <input type="radio" value="male" name="sex">Male
            <input type="radio" value="female" name="sex">Female <br>
     <input type="date" id="time" name="date"> <br>
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
        let email = document.getElementById("email").value;
        const reg = /^([a-zA-Z0-9])+(([a-zA-Z0-9])|([._-][a-zA-Z0-9])*)+@([a-zA-Z0-9-])+((\.[a-zA-Z0-9-]{2,3}){1,2})$/;
        if(!reg.test(email)){
            alert("invalid email! ")
           return false;
        }
    }
</script>
</body>
</html>
<%@include file="../footer.jsp" %>
