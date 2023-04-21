<%--
  Created by IntelliJ IDEA.
  User: 人道逍遥
  Date: 2023/4/20
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录界面</title>
    <link rel="stylesheet" href="css/login.css">

</head>
<body>
<div class="content">

    <!--  登录面板    -->
    <div class="panel">

        <!--  账号和密码组    -->
        <div class="group">
            <label>账号</label>
            <input id="name" placeholder="请输入账号">

        </div>
        <div class="group">
            <label>密码</label>
            <input id="password" placeholder="请输入密码" type="password">
        </div>

        <!--  登录按钮    -->
        <div id="login" class="login">
            <button>登录</button>
        </div>
    </div>

    <!--  注册按钮    -->
    <div class="register">
        <button>创建新账号</button>
    </div>

</div>

<script>

    document.getElementById('login').addEventListener('click',function () {

        name=document.getElementById('name').value
        password=document.getElementById('password').value
        console.log(name+" "+password)

        if(name!=""&&password!=""){
            location.href="http://localhost:8080/3.5.1/login?name="+name+"&password="+password;
        }

    })


</script>
</body>
</html>

