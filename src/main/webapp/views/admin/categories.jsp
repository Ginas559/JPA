<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý Category</title>
<style>
  table, th, td { border: 1px solid #ccc; border-collapse: collapse; padding: 6px; }
  form { margin: 0; }
</style>
</head>
<body>
<h2>Danh sách Category</h2>

<!-- Form thêm mới -->
<form action="${pageContext.request.contextPath}/admin/category" method="post">
    <input type="text" name="name" placeholder="Tên category" required />
    <button type="submit">Thêm mới</button>
</form>

<br/>

<table>
	<h1>aaaaaaaaaaaaa</h1>
  <tr>
    <th>ID</th>
    <th>Tên</th>
    <th>Hành động</th>
  </tr>
  <c:forEach items="${listCategory}" var="cat">
    <tr>
      <td>${cat.id}</td>
      <td>${cat.categoryname}</td>
      <td>
        <!-- Form sửa -->
        <form action="${pageContext.request.contextPath}/admin/category" method="post" style="display:inline">
            <input type="hidden" name="id" value="${cat.id}" />
            <input type="text" name="name" value="${cat.categoryname}" />
            <button type="submit">Cập nhật</button>
        </form>

        <!-- Form xóa -->
        <form action="${pageContext.request.contextPath}/admin/category?action=delete&id=${cat.id}" 
              method="post" style="display:inline" 
              onsubmit="return confirm('Bạn chắc chắn muốn xóa?')">
            <button type="submit">Xóa</button>
        </form>
      </td>
    </tr>
  </c:forEach>
</table>

</body>
</html>
