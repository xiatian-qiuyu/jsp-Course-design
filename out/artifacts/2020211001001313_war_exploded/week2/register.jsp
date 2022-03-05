<%--
  Created by IntelliJ IDEA.
  User: xiatian0708
  Date: 2022/3/5
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
 <form action="/hello" method="post">
     <h1>New User Registration</h1>
     <input type="text"><br>
     <input type="password"><br>
     <input type="email"> <br>
     <strong>Gender</strong> <input type="radio" value="男" name="sex">Male
            <input type="radio" value="女" name="sex">Female <br>
     <input type="date"> <br>
     <input type="submit" value="Register">
 </form>
</body>
</html>
