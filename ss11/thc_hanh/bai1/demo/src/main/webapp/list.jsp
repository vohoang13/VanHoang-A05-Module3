<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/21/2022
  Time: 9:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>List Book</h1>
    <table border="1px">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Author</th>
            <th>Category</th>
        </tr>
        <c:forEach items="${book}" var="books">
            <tr>
                <td>${books.id}</td>
                <td>${books.name}</td>
                <td>${books.author}</td>
                <td>${books.category.name}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
