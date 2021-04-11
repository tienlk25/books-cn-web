<%--
  Created by IntelliJ IDEA.
  User: nguyen
  Date: 4/11/21
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Login!" %>
</h1>

<br/>
<form action="/nhom24_war_exploded/login" method="post">
    <div>
        username
        <input name="username" type="text"/></div>
    <br>
    <div>
        password
        <input name="password" type="password"/></div>
    <div style="color:#ff0000"><%=request.getAttribute("mes") %></div>
    <br>
    <div><button type="submit">login</button></div>
</form>
</body>
</html>