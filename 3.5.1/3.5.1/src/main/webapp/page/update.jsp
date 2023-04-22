<%--
  Created by IntelliJ IDEA.
  User: 人道逍遥
  Date: 2023/4/21
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>修改</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css">
</head>
<body>


        请输入id：    <input type="text" id="id" value="${user.id}" readonly = "readonly"><br/>
    请输入姓名：   <input type="text" id="name" value="${user.name}"><br/>
    请输入密码：   <input type="text" id="password" value="${user.password}"><br/>
    <input type="button" value="提交" onclick="update()">

<script>

    function update() {
        id=document.getElementById("id").value;
        name=document.getElementById("name").value;
        password=document.getElementById("password").value;

        console.log("id="+id+"\tname="+name+"\tpassword="+password)

        if(name==null||name==""||password==null||password==""){
            return;
        }
        location.href="/3.5.1/users/UserServlet?method=update&id="+id+"&name="+name+"&password="+password;

    }

</script>

</body>
</html>
