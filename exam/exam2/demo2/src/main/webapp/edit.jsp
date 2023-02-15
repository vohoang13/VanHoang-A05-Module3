<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/9/2022
  Time: 7:15 PM
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
<form action="/benhan?action=edit" method="post">
    <div class="form-floating mb-3">
        <input type="text" name="maBA" class="form-control" id="floatingInput" value="${benhan.maBenhAn}" readonly>
        <label for="floatingInput">MA BENH AN</label>
    </div>
    <div class="form-floating">
        <input type="text" name="maBN" class="form-control" id="floatingName" value="${benhan.maBenhNhan}" readonly>
        <label for="floatingName">MA BENH NHAN</label>
    </div>
    <div class="form-floating">
        <c:forEach items="${benhnhan}" var="benhnhans">
            <c:if test="${benhnhans.maBenhNhan == benhan.maBenhNhan}">
                <input type="text" name="name" class="form-control" id="floatingPrice" value="${benhnhans.tenBenhNhan}">
                <label for="floatingPrice">TEN BENH NHAN</label>
            </c:if>
        </c:forEach>
    </div>
    <div class="form-floating">
        <input type="date" name="ngayVao" class="form-control" id="floatingAmount" value="${benhan.ngayNhapVien}">
        <label for="floatingAmount">NGAY NHAP VIEN</label>
    </div>
    <div class="form-floating">
        <input type="date" name="ngayRA" class="form-control" id="floatingColor" value="${benhan.ngayRaVien}">
        <label for="floatingColor">NGAY RA VIEN</label>
    </div>
    <div class="form-floating">
        <textarea class="form-control" name="lyDo" id="floatingTextarea">${benhan.lyDo}</textarea>
        <label for="floatingTextarea">LY DO</label>
    </div>
    <div>
        <button class="btn btn-primary" type="submit">Submit</button>
        <button class="btn btn-primary" type="button"><a href="/benhan">Back</a></button>
    </div>
</form>
</body>
</html>
