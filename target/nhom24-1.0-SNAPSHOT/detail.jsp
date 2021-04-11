<%--
  Created by IntelliJ IDEA.
  User: Truong Huu Tien
  Date: 4/11/2021
  Time: 10:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.example.nhom24.controller.BookDetailController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/login">Đăng xuất</a>
<div style="margin-left: 5px;">
<%
        BookDetailController bookDetailController = new BookDetailController();
        %>
    <form action="detail.jsp" method="post">
    <p>Id:         : ${book.id}</p>
    <p>Name:       </p> <input name="name" value="${book.name}" type="text">
    <p>Publisher:  </p><input name="publisher" value="${book.publisher}" type="text">
    <p>Price:      </p><input name="price" value="${book.price}" type="number">
        <button type="submit">Cập nhật<button><button onclick="${bookDetailController.delete(book.id)}" type="button">Xoá</button>
    </form>
</body>
</html>
