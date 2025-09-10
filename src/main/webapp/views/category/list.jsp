<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head><title>Categories</title></head>
<body>
<h2>Category List</h2>
<a href="?action=add">Add new</a>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Action</th></tr>
<c:forEach items="${listcate}" var="c">
<tr>
<td>${c.id}</td>
<td>${c.categoryname}</td>
<td>
  <a href="?action=edit&id=${c.id}">Edit</a> |
  <a href="?action=delete&id=${c.id}">Delete</a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>
