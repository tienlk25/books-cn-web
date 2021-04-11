<%--
  Created by IntelliJ IDEA.
  User: Truong Huu Tien
  Date: 4/8/2021
  Time: 9:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/nhom24_war_exploded/login">Đăng xuất</a>
<form action="/nhom24_war_exploded/home" method="post">
<p>Nhập tên sách để tìm kiếm:</p>
<input name="book"/>

<div><button type="submit">tìm kiếm</button></div>
</form>
</body>
</html>
