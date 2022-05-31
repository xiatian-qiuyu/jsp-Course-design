<%--
  Created by IntelliJ IDEA.
  User: xiatian0708
  Date: 2022/5/31
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cal</title>
</head>
<body>
<form method="post" action="<c:url value="/CalServlet"/>" name="myForm" id="myForm">
    <label>
        First Val:
        <input type="text" name="firstVal" value="<%=session.getAttribute("cFirstVal")!=null?session.getAttribute("cFirstVal"):""%>">
    </label>
    <br>
    <label>
        Enter a Name:
        <input type="text" name="cName" value="<%=session.getAttribute("cName")!=null?session.getAttribute("cName"):""%>">
    </label>
    <br>
    <label>
        Second Val:
        <input type="text" name="secondVal" value="<%=session.getAttribute("cSecondVal")!=null?session.getAttribute("cSecondVal"):""%>">
    </label>
    <br>
    <label>
        Length:
        <input type="text" name="computeLength" value="<%=session.getAttribute("cLength")!=null?session.getAttribute("cLength"):""%>">
    </label>
    <br>
    <label>
        Result:
        <input type="text" name="result" value="<%=session.getAttribute("cResult")!=null?session.getAttribute("cResult"):""%>">
    </label>
    <br>
    <input type="hidden" name="action" value="">
    <%--    set value of <input type=hidden name=action >--%>
    <button type="submit" name="action" value="add" onclick="check('add')">add</button>
    <button type="submit" name="action" value="substrata" onclick="check('substrata')">substrata</button>
    <button type="submit" name="action" value="multiply" onclick="check('multiply')">multiply</button>
    <button type="submit" name="action" value="divide" onclick="check('divide')">divide</button>
    <br>
    <button type="submit" name="action" value="computerLength" onclick="check('computerLength')">computerLength</button>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <button type="reset" name="action" value="Reset">Reset</button>
</form>
</body>
<script>
    function check(ways) {
        var firstVal = document.getElementsByName("firstVal")[0].value;
        var secondVal = document.getElementsByName("secondVal")[0].value;
        var cName = document.getElementsByName("cName")[0].value;
        document.getElementsByName("action")[0].value = ways;
        if(ways==="add"||ways==="substrata"||ways==="multiply"||ways==="divide") {
            var reg = /^[0-9]*$/;
            if(!reg.test(firstVal) || firstVal==="") {
                alert("First Val is not a number!");
                return false;
            }
            if(!reg.test(secondVal) || secondVal==="") {
                alert("Second Val is not a number!");
                return false;
            }
        }
        if(action==="computerLength") {
            var reg1 = /^[a-zA-Z]+$/;
            if(!reg1.test(cName)) {
                alert("Name is not valid!");
                return false;
            }
        }
    }
</script>
</html>
