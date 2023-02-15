<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/9/2022
  Time: 6:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap.min.css">
    <script src="bootstrap.bundle.min.js"></script>
    <style>
        div {
            margin-left: 20px;
        }
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
        .sort{
            background-color: #0a58ca;
            padding: 20px;
            border-radius: 10px;
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
            margin-top: 30px;
        }
    </style>
</head>
<body>
<h1>Danh sách bệnh án</h1>
<div>
    <form action="/benhan">
        <table>
            <tr>
                <td>
                    <input type="text" name="color" class="form-control" placeholder="What are you looking for?">
                </td>
                <td>
                    <select name="idCategory" class="form-select">
                        <option>List Category</option>
                        <c:forEach items="${category}" var="categories">
                            <option value="${categories.id}">${categories.name}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <button class="btn btn-primary" type="submit">Search</button>
                </td>
            </tr>
        </table>
        <input type="hidden" name="action" value="search">
    </form>
</div>
<table class="table table-striped">
    <tr>
        <th>MA BENH AN</th>
        <th>MA BENH NHAN</th>
        <th>TEN BENH NHAN</th>
        <th>NGAY NHAP VIEN</th>
        <th>NGAY RA VIEN</th>
        <th>LY DO</th>
        <th>Chức Năng</th>
    </tr>
    <c:forEach items="${benhan}" var="benhans">
        <tr>
            <td name="mabenhan">${benhans.maBenhAn}</td>
            <td>${benhans.maBenhNhan}</td>
            <td>
                <c:forEach items="${benhnhan}" var="benhnhans">
                    <c:if test="${benhans.maBenhNhan == benhnhans.maBenhNhan}">
                        ${benhnhans.tenBenhNhan}
                    </c:if>
                </c:forEach>
            </td>
            <td>${benhans.ngayNhapVien}</td>
            <td>${benhans.ngayRaVien}</td>
            <td>${benhans.lyDo}</td>
            <td>
                <button type="button" class="btn btn-primary">
                    <a class="edit" href="/benhan?action=edit&mabenhan=${benhans.maBenhAn}">Edit</a>
                </button>
                <button type="button" class="btn btn-primary">
                    <a class="delete" href="/benhan?action=delete&mabenhan=${benhans.maBenhAn}">Delete</a>
                </button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
