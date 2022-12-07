<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/3/2022
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="bootstrap.min.css">
    <script src="bootstrap.bundle.min.js"></script>
    <title>Title</title>
    <style>
        th{
            text-align: center;
        }

        .add{
            text-decoration: none;
            margin-left: 20px;
            background-color: #0a58ca;
            padding: 20px;
            border-radius: 10px;
            color: white;
        }

        table a{
            text-decoration: none;
            color: white;
        }

        a:hover{
            color: red;
        }

        td{
            text-align: center;
        }

        h1{
            text-align: center;
            margin-bottom: 20px;
        }

        table{
            margin-top: 60px;
        }
    </style>
</head>
<body>
        <h1>Danh sách sản phẩm</h1>
        <a class="add" href="/product?action=create">+ Add new product</a>
        <table class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Amount</th>
                <th>Color</th>
                <th>Des</th>
                <th>Category</th>
                <th>Chức Năng</th>
            </tr>
            <c:forEach items="${product}" var="products">
                <tr>
                    <td name="id">${products.id}</td>
                    <td>${products.productName}</td>
                    <td>${products.price}</td>
                    <td>${products.amount}</td>
                    <td>${products.color}</td>
                    <td>${products.descriptions}</td>
                    <c:forEach items="${category}" var="categories">
                        <c:if test="${categories.id == products.idCategory}">
                            <td>
                                ${categories.name}
                            </td>
                        </c:if>
                    </c:forEach>
                    <td>
                        <button type="button" class="btn btn-primary">
                            <a class="edit" href="/product?action=edit&id=${products.id}">Edit</a>
                        </button>
                        <button type="button" class="btn btn-primary">
                            <a class="delete" href="/product?action=delete&id=${products.id}">Delete</a>
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
</body>
</html>
