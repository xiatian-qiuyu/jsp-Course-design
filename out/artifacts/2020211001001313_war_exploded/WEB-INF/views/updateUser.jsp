<%--
  Created by IntelliJ IDEA.
  User: xiatian0708
  Date: 2022/4/19
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1> User Update</h1>
<%
    //get user from session
    User u = (User) session.getAttribute("user");
%>
<form action="${pageContext.request.contextPath}/updateUser" name="form" method="post" accept-charset="UTF-8" onsubmit="return register()">
    <h3>New User Registration</h3>
    <input type="hidden" name="id" value="<%=u.getId()%>">
    <input type="text" name="username" value="<%=u.getUsername()%>" id="username" placeholder="username" ><span id="span1"></span><br>
    <input type="password" id="password" value="<%=u.getPassword()%>" name="password" placeholder="password"><br>
    <input type="email" id="email" value="<%=u.getEmail()%>" name="email" placeholder="email"> <br>
    <strong>Gender</strong>
    <input type="radio" value="male"  <%="male".equals(u.getGender())?"checked":""%>name="gender"> Male
    <input type="radio" value="female"<%="female".equals(u.getGender())?"checked":""%> name="gender"> Female <br>
    <input type="date" id="time" value="<%=u.getBirthdate()%>" name="birthdate"> <br>
    <input type="submit" value="Save Changes">
</form>
<%@include file="footer.jsp"%>
