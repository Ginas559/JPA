<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head><title>Login</title></head>
<body>
<h2>Login</h2>
<form action="${pageContext.request.contextPath}/login" method="post">
  Username: <input type="text" name="username"/><br/>
  Password: <input type="password" name="password"/><br/>
  Remember me: <input type="checkbox" name="remember"/><br/>
  <input type="submit" value="Login"/>
</form>
<c:if test="${not empty alert}">
  <p style="color:red">${alert}</p>
</c:if>
<a href="${pageContext.request.contextPath}/register">Register</a>
</body>
</html>
