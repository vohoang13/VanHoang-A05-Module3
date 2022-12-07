<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/4/2022
  Time: 9:14 PM
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
    <h1>Add New Product</h1>
    <form action="/product?action=create" method="post">
<%--        <input hidden name="action" value="create">--%>
        <div class="form-floating mb-3">
            <input type="number" name="id" class="form-control" id="floatingInput">
            <label for="floatingInput">ID Product</label>
        </div>
        <div class="form-floating">
            <input type="text" name="name" class="form-control" id="floatingName">
            <label for="floatingName">Product Name</label>
        </div>
        <div class="form-floating">
            <input type="number" name="price" class="form-control" id="floatingPrice">
            <label for="floatingPrice">Product Price</label>
        </div>
        <div class="form-floating">
            <input type="text" name="amount" class="form-control" id="floatingAmount">
            <label for="floatingAmount">Product Amount</label>
        </div>
        <div class="form-floating">
            <input type="text" name="color" class="form-control" id="floatingColor">
            <label for="floatingColor">Product Color</label>
        </div>
        <div class="form-floating">
            <textarea class="form-control" name="descriptions" placeholder="Leave a comment here" id="floatingTextarea"></textarea>
            <label for="floatingTextarea">Comments</label>
        </div>
        <div>
            <select class="form-select" name="idCategory" aria-label="Default select example">
                <option>List Category</option>
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
