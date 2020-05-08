<%--
  Created by IntelliJ IDEA.
  User: 19740
  Date: 2020/5/7
  Time: 下午 5:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>文件上传</h1>
<form action="user/fileUpload" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload"/><br>
    <input type="submit" value="上传" />
</form>
<a href="user/testException">testException</a>
</body>
</html>
