<%--
  Created by IntelliJ IDEA.
  User: 19740
  Date: 2020/5/5
  Time: 下午 2:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<a href="params/testParams?username=中文">简单参数绑定</a>--%>
<%--<form action="params/saveAccount" method="post">
    姓名：<input type="text" name="name"/><br>
    密码：<input type="password" name="password"/><br>
    金额：<input type="text" name="money"/><br>

    用户姓名：<input type="text" name="list[0].username"/><br>
    年龄：<input type="text" name="list[0].age"/><br>

    用户姓名：<input type="text" name="map['one'].username"/><br>
    年龄：<input type="text" name="map['one'].age"/><br>
    <input type="submit" value="提交">
</form>--%>
<form action="params/saveUser" method="post">
    用户姓名：<input type="text" name="username"/><br>
    年龄：<input type="text" name="age"/><br>
    生日：<input type="text" name="date"/><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
