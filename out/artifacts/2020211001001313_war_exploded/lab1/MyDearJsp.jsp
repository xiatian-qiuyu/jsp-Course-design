<%--
  Created by IntelliJ IDEA.
  User: xiatian0708
  Date: 2022/5/18
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        String name = request.getParameter("name");
        String submit = request.getParameter("submit");
        String  myClass = request.getParameter("myclass");
        String id = request.getParameter("id");

    %>

    <h2>
        <br> name:<%=request.getParameter("name")%> <br>
        class:<%=request.getParameter("myclass")%> <br>
        id:<%=request.getParameter("id")%> <br>
        submit:<%=request.getParameter("submit")%><br>

        name:${param.name} <br>
        submit:${param.submit}<br>
        id:${param.id} <br>
        class:${param.myclass} <br>
    </h2>

</body>
</html>
