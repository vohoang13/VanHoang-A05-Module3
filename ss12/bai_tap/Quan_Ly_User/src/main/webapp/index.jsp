<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>

<a href="/user?action=create">Create</a>
<a href="/user?action=list">List</a>
<a href="/user?action=delete">Delete</a>
<a href="/user?action=update">Update</a>
<a href="/user?action=sort">Sort</a>
<a href="/user?action=searchCountry">Search</a>
</body>
</html>