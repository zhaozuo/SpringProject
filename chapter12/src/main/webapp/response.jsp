<%--
  Created by IntelliJ IDEA.
  User: 19740
  Date: 2020/5/6
  Time: 下午 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.4.1.min.js"></script>
    <%--<script src="https://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>--%>
    <script>
        $(function () {
            $("#btn").click(function () {
                // alert("你好 btn");
                // 发送ajax请求
                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"hehe","password":"123","age":"56"}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        // data是服务端返回的数据
                        alert(data)
                        alert(data.username)
                        alert(data.password)
                        alert(data.age)
                    }
                });
            });
        });
    </script>
</head>
<body>
<a href="user/testString">testString</a>

<br>
<a href="user/testVoid">testVoid</a>

<br>
<a href="user/testModelAndView">testModelAndView</a>

<br>
<a href="user/testForwardOrRedirect">testForwardOrRedirect</a>

<br>
<button id="btn">发送ajax请求</button>
</body>
</html>
