<%--
  Created by IntelliJ IDEA.
  User: 人道逍遥
  Date: 2023/4/20
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录界面</title>


</head>
<body>
<div class="content">

    <!--  登录面板    -->
    <div class="panel">

        <!--  账号和密码组    -->
        <div class="group">
            <label>账号</label>
            <input id="name" placeholder="请输入账号" value="${user.id}">

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
        <button onclick="add()">创建新账号</button>
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

    function add() {
        location.href="http://localhost:8080/3.5.1/register.jsp";
    }


</script>
<style>
    /*按照样图要求，添加一个浅灰色背景*/
    body{
        background-color: #F2F2F2;
    }

    /*设置内容模块距离顶部一个有一段距离150px*/
    .content {
        margin-top: 150px;
    }

    /*登录和注册按钮的整体样式*/
    .content button {
        height: 30px;/*登录和注册按钮的高度*/
        color:  white;/*登录和注册按钮字体颜色为白色*/
        font-size: 18px;/*登录和注册按钮的字体大小*/
        border: 0px;/*无边框*/
        padding: 0px;/*无内边距*/
        cursor: pointer;/*登录和注册按钮的选择时为手形状*/
    }

    /*登录面板*/
    .content .panel {
        background-color: white;/*登录面板背景颜色为白色*/
        width: 302px;/*宽度为302px*/
        text-align: center;/*子内容居中*/
        margin: 0px auto;/*自身居中*/
        padding-top: 20px;/*顶部的内边距为20px*/
        padding-bottom: 20px;/*底部的内边距为20px*/
        border: 1px solid #ddd;/*边框颜色为灰色*/
        border-radius: 5px;/*边框边角有5px的弧度*/

    }

    /*登录和密码组*/
    .content .panel .group {
        text-align: left;/*子内容居中*/
        width: 262px;/*宽度为262px*/
        margin: 0px auto 20px;/*自身居中，并距离底部有20px的间距*/
    }
    .content .panel .group label {
        line-height: 30px;/*高度为30px*/
        font-size: 18px;/*字体大小为18px*/
    }
    .content .panel .group input {
        display: block;/*设置为块，是为了让输入框独占一行*/
        width: 250px;/*宽度为250px*/
        height: 30px;/*高度为30px*/
        border: 1px solid #ddd;/*输入框的边框*/
        padding: 0px 0px 0px 10px;/*左边内边距为10px，显得美观*/
        font-size: 16px;/*字体大小*/
    }
    .content .panel .group input:focus{

        border-left: 1px solid #CC865E;/*当输入框成为焦点时，左边框颜色编程褐色*/
    }
    .content .panel .login button {
        background-color: #CC865E;/*按钮的背景颜色*/
        width: 260px;/*按钮的宽度*/
    }
    .content .panel .login button:hover {
        background-color: white;/*按钮选中后背景颜色为白色*/
        color:  #CC865E;/*按钮选中后字体颜色为褐色*/
        border: 1px solid #CC865E;/*按钮选中后边框颜色为褐色*/
    }

    /*注册按钮*/
    .content .register {
        text-align: center;/*子内容居中*/
        margin-top: 20px;/*顶部的内边距为20px*/
    }
    .content .register button {
        background-color: #466BAF;/*按钮的背景颜色为蓝色*/
        width: 180px;/*按钮的宽度*/
    }

    .content .register button:hover {
        background-color: white;/*按钮选中后背景颜色为白色*/
        color: #466BAF;/*按钮选中后字体颜色为蓝色*/
        border: 1px solid #466BAF;/*按钮选中后边框颜色为蓝色*/
    }

</style>
</body>
</html>

