<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head><title>Register</title></head>
<body>
<h2>Register</h2>
<form action="${pageContext.request.contextPath}/register" method="post">
  Username: <input type="text" name="username"/><br/>
  Password: <input type="password" name="password"/><br/>
  Fullname: <input type="text" name="fullname"/><br/>
  Email: <input type="text" name="email"/><br/>
  Phone: <input type="text" name="phone"/><br/>
  <input type="submit" value="Register"/>
</form>
<c:if test="${not empty alert}">
  <p style="color:red">${alert}</p>
</c:if>
<a href="${pageContext.request.contextPath}/login">Back to login</a>
</body>
</html>
