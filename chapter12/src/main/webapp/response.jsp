<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <%--<script src="js/jquery-3.4.1.min.js"></script>--%>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
</head>
<body>
<%--<a href="user/testString">testString</a>

<br>
<a href="user/testVoid">testVoid</a>

<br>
<a href="user/testModelAndView">testModelAndView</a>

<br>
<a href="user/testForwardOrRedirect">testForwardOrRedirect</a>--%>

<br>
<button id="btn">发送ajax请求</button>

<br>
<div>
    <label for="name">请输入你的姓名：</label><input type="text" id="name" value=""/><br>
    <input type="button" onclick="sendName()" value="提交"/><br>
    <p id="result"></p>
    <p id="time"></p>
</div>
<script>
    window.onload = function(){
        let t = new Date();
        document.getElementById('time').innerText = t.getMilliseconds().toString();
    };
    $(function () {
        $("#btn").click(function () {
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
    function sendName() {
        let name = document.getElementById('name').value;
        if (name === '' || name.length === 0){
            alert('请输入姓名！');
            return false;
        }
        $.ajax({
            url: 'user/ajax',
            data: {inputName: name},
            dataType: 'json',
            type: 'POST',
            success: function (data) {
                // alert('获取到了数据');
                document.getElementById('result').innerText = data.hello;
            },
            error: function () {
                alert('获取数据失败！');
            }
        });
    }
</script>
</body>
</html>
