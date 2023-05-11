<%--
  Created by IntelliJ IDEA.
  User: 人道逍遥
  Date: 2023/4/21
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <title>增加</title>
    <meta charset="UTF-8">

    <link rel="stylesheet" type="text/css" href="../css/common.css">
    <style>
        #button{
            width: 80px;
        }
    </style>
</head>
<body>
<div class="div_1">

    <form action="/6.3/students?method=insert" method="post" method="post" enctype="multipart/form-data">

        请输入姓名：   <input type="text" id="name" name="name"><br/>
        请输入性别：   <input type="text" id="sex" name="sex"><br/>
        请输入年龄：   <input type="text" id="age" name="age"><br/>
        请输入班级：   <input type="text" id="grade" name="grade"><br/>
        请输入成绩：   <input type="text" id="score" name="score"><br/>
        头像： <input type="file" id="file" name="file"><br/>

        <input id="button" type="submit" value="提交" onclick="return add()">
    </form>
    <br>
    <button id="upload" onclick="upload()">批量增加</button>
</div>



<script>


    function add() {
        name=document.getElementById('name').value;


        if(name!=""){
            console.log("你好啊")
            return true
        }
        return false

    }
    function upload() {
        location.href="./common/upload.jsp"
    }

</script>
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
        width: 400px;
        border: 2px solid #466BAF;
        border-radius: 5px;

    }
</style>

</body>
</html>


