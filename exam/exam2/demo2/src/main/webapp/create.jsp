<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/9/2022
  Time: 7:02 PM
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
<h1>Thêm mới bệnh án</h1>
<form action="/benhan" method="post">
  <input hidden name="action" value="create">
  <div class="form-floating mb-3">
    <input type="number" name="mabenhan" class="form-control" id="floatingInput">
    <label for="floatingInput">MA BENH AN</label>
  </div>
  <div class="form-floating">
    <input type="text" name="mabenhnhan" class="form-control" id="floatingName">
    <label for="floatingName">MA BENH NHAN</label>
  </div>
  <div class="form-floating">
    <input type="number" name="tenbenhnhan" class="form-control" id="floatingPrice">
    <label for="floatingPrice">TEN BENH NHAN</label>
  </div>
  <div class="form-floating">
    <input type="date" name="ngayvao" class="form-control" id="floatingAmount">
    <label for="floatingAmount">NGAY NHAP VIEN</label>
  </div>
  <div class="form-floating">
    <input type="date" name="ngayra" class="form-control" id="floatingColor">
    <label for="floatingColor">NGAY RA VIEN</label>
  </div>
  <div class="form-floating">
    <textarea class="form-control" name="descriptions" placeholder="Leave a comment here" id="floatingTextarea"></textarea>
    <label for="floatingTextarea">LY DO</label>
  </div>
  <div>
    <button class="btn btn-primary" type="submit">Submit</button>
    <button class="btn btn-primary" type="button"><a href="/benhan">Back</a></button>
  </div>

</form>
</body>
</html>
