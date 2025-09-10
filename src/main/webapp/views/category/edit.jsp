<html>
<head><title>Edit Category</title></head>
<body>
<h2>Edit Category</h2>
<form method="post" action="">
  <input type="hidden" name="action" value="edit"/>
  <input type="hidden" name="id" value="${cate.id}"/>
  Name: <input type="text" name="name" value="${cate.categoryname}"/>
  <input type="submit" value="Update"/>
</form>
</body>
</html>
ok