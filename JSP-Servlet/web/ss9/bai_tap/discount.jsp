<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/17/2022
  Time: 6:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        h2 {
            margin-top: 10px;
        }
        .discount {
            border: 1px solid black;
            width: 200px;
        }

        .discount input {
            margin: 10px;
            width: 150px;
        }
    </style>
</head>
<body>
    <h2>Discount</h2>
    <form class="discount" action="/display" method="post">
        <input type="text" name="productDes" placeholder="Product Description">
        <input type="number" name="price" placeholder="List Price">
        <input type="number" name="percent" placeholder="Discount Percent">
        <input type="submit" value="Calculate Discount">
    </form>
</body>
</html>
