<%--
  Created by IntelliJ IDEA.
  User: 人道逍遥
  Date: 2023/4/21
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css">
    <style>
        #button{
            width: 80px;
        }
    </style>
</head>
<body>
<div class="div_1">
    <form action="/3.5.1/users/UserServlet?method=add" method="post">
        <%--    请输入id：    <input type="text" name="id"><br/>--%>
        请输入姓名：   <input type="text" id="name" name="name"><br/>
        请输入密码：   <input type="text" id="password" name="password"><br/>
        <input id="button" type="submit" value="提交" onclick="return add()">
    </form>

</div>


<script>
    function add() {
        name=document.getElementById('name').value;
        password=document.getElementById('password').value;

        if(name==""||password==""){
            return false;
        }

        console.log("你好啊")
        return true
    }

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
    form{


        position:relative;

        left:50%;

        top:50%;

        margin-left:-150px;

        margin-top:-80px;
    }
    .div_1{

        background-color: #466BAF;
        margin: 250px auto;
        /*margin-top: 10%;*/
        /*margin-left: 20%;*/
        height: 30%;
        width: 30%;
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

