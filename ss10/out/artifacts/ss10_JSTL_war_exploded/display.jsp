<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/18/2022
  Time: 8:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>Tên</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>Hình ảnh</th>
        </tr>
        <c:forEach items="${customer}" var="c">
            <tr>
                <td>${c.name}</td>
                <td>${c.dayOfBirth}</td>
                <td>${c.address}</td>
                <td><img src="1045.jpg"></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
