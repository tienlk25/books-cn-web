
<%@ page import="com.example.nhom24.model.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Truong Huu Tien
  Date: 4/9/2021
  Time: 12:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/login">Đăng xuất</a>
<p> kết quả tìm kiếm với : ${search}</p>
<c:forEach items="${books}" var="book">
    <div style="margin-left: 5px;">
    <p>Id:         ${book.id}</p>
    <p>Name:       ${book.name}</p>
    <p>Publisher:  ${book.publisher}</p>
    <p>Price:      ${book.price}</p>
    <a href="/nhom24_war_exploded/detail?bookId=${book.id}">xem chi tiêt</a>
    </div>
</c:forEach>
</body>
</html>
