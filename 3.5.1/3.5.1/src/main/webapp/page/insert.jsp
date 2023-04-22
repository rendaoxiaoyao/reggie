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
    <link rel="stylesheet" type="text/css" href=".../css/common.css">
    <style>
        #button{
            width: 80px;
        }
    </style>
</head>
<body>

<form action="/3.5.1/users/UserServlet?method=add" method="post">
<%--    请输入id：    <input type="text" name="id"><br/>--%>
    请输入姓名：   <input type="text" id="name" name="name"><br/>
    请输入密码：   <input type="text" id="password" name="password"><br/>
                <input id="button" type="submit" value="提交" onclick="return add()">
</form>

<script>
    function add() {
        name=document.getElementById('name').value;
        password=document.getElementById('password').value;

        if(name==""||password==" "){
            return false;
        }

        console.log("你好啊")
        return true
    }

</script>


</body>
</html>


