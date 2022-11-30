<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/30/2022
  Time: 4:32 PM
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
        <td>Name</td>
        <td><input type="text" name="name"></td>
      </tr>
      <tr>
        <td><input type="submit"></td>
        <td><input type="reset"></td>
      </tr>
    </table>
    <input type="hidden" value="deleteName" name="action">
  </form>
</body>
</html>
