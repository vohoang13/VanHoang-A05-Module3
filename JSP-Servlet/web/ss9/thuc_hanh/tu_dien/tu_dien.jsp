<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/16/2022
  Time: 11:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Vietnamese Dictionary</h1>
    <form action="/tudien" method="post">
        <div class="tudien">
            <input type="text" name="word" placeholder="Enter your word:">
            <input type="submit" value="Search">
        </div>
    </form>
</body>
</html>
