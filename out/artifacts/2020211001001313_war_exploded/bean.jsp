<%@ page import="com.huangmaohua.week10.StringBean" %><%--
  Created by IntelliJ IDEA.
  User: xiatian0708
  Date: 2022/5/3
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>demo2-week10</title>
</head>
<body>
<h1>use java code to access string bean class in jsp</h1>
<jsp:useBean id="bean" class="com.huangmaohua.week10.StringBean"/>

<%
//com.huangmaohua.week10.StringBean bean = new StringBean();

//bean.setMessage("hello mr bean");

%>
<jsp:setProperty name="bean" property="message" value='<%=request.getParameter("message")%>'/>


Message(using java code):<%=bean.getMessage()%>

<h2>use usebean to access StringBean class in jsp </h2>
Message(using getProperty):<jsp:getProperty name="bean" property="message"/>

</body>
</html>
