<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/27/2022
  Time: 12:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/user" method="post">
      <table border="1">
        <tr>
          <td>ID</td>
          <td><input type="number" name="id"></td>
        </tr>
        <tr>
          <td>User Name</td>
          <td><input type="text" name="name" placeholder="HuyHoang2"></td>
        </tr>
        <tr>
          <td>Email</td>
          <td><input type="text" name="email" placeholder="hoangvanvo@gmail.com"></td>
        </tr>
        <tr>
          <td>Country</td>
          <td><input type="text" name="country"></td>
        </tr>
        <tr>
          <td><input type="submit"></td>
          <td><input type="reset"></td>
        </tr>
      </table>
      <input type="hidden" name="action" value="update">
    </form>
</body>
</html>
