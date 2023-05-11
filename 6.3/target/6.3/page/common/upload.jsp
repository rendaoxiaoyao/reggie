<%--
  Created by IntelliJ IDEA.
  User: 人道逍遥
  Date: 2023/4/26
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
    <title>增加</title>
    <meta charset="UTF-8">

    <link rel="stylesheet" type="text/css" href="/src/main/webapp/css/common.css">
    <style>
        #button{
            width: 80px;
        }
    </style>
</head>
<body>
<div class="div_1">

    <form action="/6.3/CommonServlet?method=upload" method="post" enctype="multipart/form-data">

        文件上传： <input type="file" id="file" name="file"><br/>
        <input id="button" type="submit" value="提交" onclick="return adds()">
    </form>
</div>



<script>
    function adds() {
        file=document.getElementById('name').value;
        console.log(file)

        if(file!=null&&file!=""){
            console.log("你好啊")
            return true
        }
        return false

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


