<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/5/2022
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap.min.css">
    <script src="bootstrap.bundle.min.js"></script>
    <style>
        div{
            margin-top: 20px;
        }

        div button a{
            color: white;
            text-decoration: none;
        }
    </style>
</head>
<body>
<h1>Edit Product</h1>
<form action="/product?action=edit" method="post">
<%--    <table>--%>
<%--        <tr>--%>
<%--            <th>ID</th>--%>
<%--            <th>Name</th>--%>
<%--            <th>Price</th>--%>
<%--            <th>Amount</th>--%>
<%--            <th>Color</th>--%>
<%--            <th>Des</th>--%>
<%--            <th>Category</th>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><input type="number" name="id" value="${p.id}" readonly></td>--%>
<%--            <td><input type="text" name="name" placeholder="${p.productName}"></td>--%>
<%--            <td><input type="number" name="price" placeholder="${p.price}"></td>--%>
<%--            <td><input type="number" name="amount" placeholder="${p.amount}"></td>--%>
<%--            <td><input type="text" name="color" placeholder="${p.color}"></td>--%>
<%--            <td><textarea name="descriptions" placeholder="${p.descriptions}"></textarea></td>--%>
<%--            <td>--%>
<%--                <select class="form-select" name="idCategory" aria-label="Default select example">--%>
<%--                    <option>--%>
<%--                        <c:forEach items="${category}" var="categories">--%>
<%--                            <c:if test="${categories.id == p.idCategory}">--%>
<%--                                ${categories.name}--%>
<%--                            </c:if>--%>
<%--                        </c:forEach>--%>
<%--                    </option>--%>

<%--                    <c:forEach items="${category}" var="categories">--%>
<%--                        <option value="${categories.id}">${categories.name}</option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--    <input type="submit">--%>

    <div class="form-floating mb-3">
        <input type="number" name="id" class="form-control" id="floatingInput" value="${p.id}" readonly>
        <label for="floatingInput">ID Product</label>
    </div>
    <div class="form-floating">
        <input type="text" name="name" class="form-control" id="floatingName" value="${p.productName}">
        <label for="floatingName">Product Name</label>
    </div>
    <div class="form-floating">
        <input type="number" name="price" class="form-control" id="floatingPrice" value="${p.price}">
        <label for="floatingPrice">Product Price</label>
    </div>
    <div class="form-floating">
        <input type="text" name="amount" class="form-control" id="floatingAmount" value="${p.amount}">
        <label for="floatingAmount">Product Amount</label>
    </div>
    <div class="form-floating">
        <input type="text" name="color" class="form-control" id="floatingColor" value="${p.color}">
        <label for="floatingColor">Product Color</label>
    </div>
    <div class="form-floating">
        <textarea class="form-control" name="descriptions" id="floatingTextarea">${p.descriptions}</textarea>
        <label for="floatingTextarea">Comments</label>
    </div>
    <div>
        <select class="form-select" name="idCategory" aria-label="Default select example">
            <option>
                <c:forEach items="${category}" var="categories">
                    <c:if test="${categories.id == p.idCategory}">
                        ${categories.name}
                    </c:if>
                </c:forEach>
            </option>
            <c:forEach items="${category}" var="categories">
                <option value="${categories.id}">${categories.name}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <button class="btn btn-primary" type="submit">Submit</button>
        <button class="btn btn-primary" type="button"><a href="/product">Back</a></button>
    </div>
</form>
</body>
</html>
