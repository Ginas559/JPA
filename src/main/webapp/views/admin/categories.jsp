<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý Category</title>
<style>
  table, th, td { border: 1px solid #ccc; border-collapse: collapse; padding: 4px; }
</style>
</head>
<body>
<h2>Danh sách Category</h2>

<!-- Form thêm mới -->
<form action="CategoryServlet" method="post">
    <input type="hidden" name="action" value="insert" />
    Tên category:
    <input type="text" name="categoryname" required />
    <button type="submit">Thêm mới</button>
</form>

<br/>

<table>
  <tr>
    <th>ID</th>
    <th>Tên</th>
    <th>Hành động</th>
  </tr>
  <c:forEach items="${listcate}" var="cat">
    <tr>
      <td>${cat.id}</td>
      <td>${cat.categoryname}</td>
      <td>
        <!-- Form sửa -->
        <form action="CategoryServlet" method="post" style="display:inline">
            <input type="hidden" name="action" value="update" />
            <input type="hidden" name="id" value="${cat.id}" />
            <input type="text" name="categoryname" value="${cat.categoryname}" />
            <button type="submit">Cập nhật</button>
        </form>

        <!-- Form xóa -->
        <form action="CategoryServlet" method="post" style="display:inline" 
              onsubmit="return confirm('Bạn chắc chắn muốn xóa?')">
            <input type="hidden" name="action" value="delete" />
            <input type="hidden" name="id" value="${cat.id}" />
            <button type="submit">Xóa</button>
        </form>
      </td>
    </tr>
  </c:forEach>
</table>

</body>
</html>
