<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/15/2022
  Time: 11:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .login {
            height: 200px;
            width: 200px;
            margin-top: 20px;
            border: 1px gray solid;
        }
        .login input{
            width: 150px;
            margin: 10px;
        }
    </style>
</head>
<body>
    <form action="/login" method="post">
        <div class="login">
            <h1>Login</h1>
            <input type="text" name="user" placeholder="username">
            <input type="password" name="pass" placeholder="password">
            <input type="submit" value="Sign in">
        </div>
    </form>
</body>
</html>
