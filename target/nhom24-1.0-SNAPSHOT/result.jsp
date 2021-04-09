
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
<html>
<head>
    <title>Title</title>
</head>
<body>
<p> kết quả tìm kiếm với : ${search}</p>

<%  List<Book> books = (List<Book>) request.getAttribute("books");
    PrintWriter output = response.getWriter();
    for (int i = 0; i< books.size(); i ++) {
        output.println("<p>"+ books.get(i).getId() + "</p>");
        output.println("<p>"+ books.get(i).getName() + "</p>");
        output.println("<p>"+ books.get(i).getPublisher() + "</p>");
        output.println("<p>"+ books.get(i).getPrice() + "</p>");
    } %>

</body>
</html>
