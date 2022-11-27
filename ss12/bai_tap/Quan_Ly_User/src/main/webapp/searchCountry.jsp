<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/27/2022
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/user" method="post">
        <table>
            <tr>
                <td>Country</td>
                <td><input type="text" name="country"></td>
            </tr>
            <tr>
                <td><input type="submit"></td>
                <td><input type="reset"></td>
            </tr>
        </table>
        <input type="hidden" value="searchCountry" name="action">
    </form>
</body>
</html>
