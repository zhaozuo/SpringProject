<%--
  Created by IntelliJ IDEA.
  User: 19740
  Date: 2020/5/6
  Time: 下午 1:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="annotation/testRequestParam?name=哈哈">RequestParam</a>
<br>
<form action="annotation/testRequestBody" method="post">
    姓名：<input type="text" name="username"/><br>
    年龄：<input type="text" name="age"/><br>
    <input type="submit" value="提交">
</form>
<br>
<a href="annotation/testPathVariable/18">PathVariable</a>

<br>
<form action="annotation/testModelAttribute" method="post">
    姓名：<input type="text" name="username"/><br>
    年龄：<input type="text" name="age"/><br>
    <input type="submit" value="提交">
</form>

<br>
<a href="annotation/testSessionAttributes">testSessionAttributes</a>
<br>
<a href="annotation/getSessionAttributes">getSessionAttributes</a>
<br>
<a href="annotation/delSessionAttributes">delSessionAttributes</a>
</body>
</html>
