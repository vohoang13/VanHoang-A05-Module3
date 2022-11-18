<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/15/2022
  Time: 9:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h1>Phép cộng 2 số</h1>
    <%--    <form action="result.jsp">--%>
    <form action="/sum">
      <input type="number" name="number1" /> <br>
      <input type="number" name="number2" /> <br>
      <input type="submit" value="Tính tổng">
    </form>
  </body>
</html>
