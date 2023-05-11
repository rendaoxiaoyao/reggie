<%--
  Created by IntelliJ IDEA.
  User: 人道逍遥
  Date: 2023/4/20
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>用户综合管理软件</title>
</head>
<body>
<div class="div_1">
    <button id="add">增加</button><br>
    <button id="logout">退出</button><br>
    <button id="update">修改</button><br>
    <button id="select">查询</button><br>
</div>



<script>
    document.getElementById('add').addEventListener('click',function () {
        location.href="insert.jsp"
    })
    document.getElementById('logout').addEventListener('click',function () {
        location.href="/6.3/logout"
    })
    document.getElementById('update').addEventListener('click',function () {
        location.href="update.jsp"
    })
    document.getElementById('select').addEventListener('click',function () {
        location.href="/6.3/students"
    })

</script>
</body>
<style>
    *{
        margin: 0;
        padding: 0;
    }

    body{
        background-color: #66afe9;
    }
    .div_1{
        background-color: #466BAF;
        margin: 250px auto;
        /*margin-top: 10%;*/
        /*margin-left: 20%;*/
        width: 50%;
        border: 2px solid #466BAF;
        border-radius: 5px;

    }
    button{
        background-color:#f66f6a;
        color:white;
        width: 80px;
        height: 40px;
        border:0;
        font-size: 16px;
        box-sizing: content-box;
        border: 2px solid #f66f6a;
        border-radius: 5px;

        margin-top: 10px;
        margin-left: 30%;
        /*padding: 100px;*/
    }
    button:hover{
        background-color: #a54b4a;
    }

</style>
</html>
