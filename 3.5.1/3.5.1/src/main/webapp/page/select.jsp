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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>查询</title>
</head>
<body>








<h1>用户成员</h1>

<input type="text" id="msg"><button id="select" onclick="select()">查询</button>
<button id="add" onclick="add()">增加</button><br>

<table align="center" border="2" cellpadding="15px" cellspacing="0">

    <thead>
    <tr>
        <th>id</th> <th>姓名</th> <th>密码</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${list}" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.password}</td>

        <td><button id="delete" onclick="UserDelete(${user.id})">删除</button>
            <button id="update" onclick="UserUpdate(${user.id})">修改</button></td>

    </tr>
    </c:forEach>
    </tbody>
</table>

<script>

    function UserDelete(id) {
        location.href="/3.5.1/UserServlet?id="+id+"&method=delete"
    }
    function UserUpdate(id) {
        location.href="/3.5.1/UserServlet?id="+id+"&method=update"
    }
    function select() {
        msg=document.getElementById('msg').value;
        console.log(msg);
        location.href="/3.5.1/UserServlet?method=select&msg="+msg;
    }
    function add() {
        location.href="/3.5.1/page/insert.jsp"
    }

</script>
</body>
<style>
    body{
        background: url(/images/420.jpg);   /* biu特佛 的背景图片 */
        background-size: 100% 100%;
        color:black;
        font-size: 23px;    /* 文字大小 */
    }
    a{
        text-decoration: none;    /* 去除链接的下划线 */
        color:black;
    }
    table{
        width: 70%;
        height: 50px;
        text-align: center;    /* 文字在单元格中居中 */
    }
    h1{
        text-align: center;
    }
    button{
        background-color:#f66f6a;
        color:white;
        width: 80px;
        height: 20px;
        border:0;
        font-size: 16px;
        box-sizing: content-box;
        border-radius: 5px;
        margin-top: 10px;
        /*padding: 100px;*/
    }
    button:hover{
        background-color: #a54b4a;
    }

</style>
</html>
