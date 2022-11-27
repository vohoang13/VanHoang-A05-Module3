<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/26/2022
  Time: 11:46 PM
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
              <td>ID</td>
              <td><input type="number" name="id"></td>
          </tr>
          <tr>
              <td><input type="submit"></td>
              <td><input type="reset"></td>
          </tr>
      </table>
      <input type="hidden" value="delete" name="action">
    </form>
</body>
</html>
