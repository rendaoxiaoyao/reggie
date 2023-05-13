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
    <meta charset="UTF-8">

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="./css/common.css">
    <link rel="stylesheet" type="text/css" href="./css/page/select.css">

    <script type="text/javascript" src="./js/page/select.js" charset="UTF-8"></script>

    <style type="text/css">
        body{
            background:url("./images/420.jpg");   /* biu特佛 的背景图片 */
            background-size: 100% ;
            color:black;
            font-size: 23px;    /* 文字大小 */
        }
    </style>

    <script type="text/javascript">
        window.onload = function () {
            initf();
            setpage(1, 5);
        }
    </script>
</head>
<body>



<h1>学生管理</h1>
<div>
    <input type="text" id="msg" class="msg">
    <button id="select" onclick="select()">查询</button>
    <button id="add" onclick="add()">增加</button>
    <button id="deletes" onclick="StudentDeletes()">清空</button>
</div>
<table align="center" border="2" cellpadding="15px" cellspacing="0">
    <thead>
    <tr>
        <th>头像</th>
        <th>编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>班级</th>
        <th>成绩</th>
        <th>操作</th>
    </tr>
    </thead>
</table>
<style>
    img{
        width: 150px;
        height: 140px;
        object-fit: contain;
    }
</style>
<table id="tableId" align="center" border="2" cellpadding="15px" cellspacing="0">

    <tbody>

    <c:forEach items="${list}" var="student">
        <tr>
            <td><img src="${student.file}"></td>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.sex}</td>
            <td>${student.age}</td>
            <td>${student.grade}</td>
            <td>${student.score}</td>

            <td><button id="delete" onclick="StudentDelete(${student.id})">删除</button>
                <button id="update" onclick="StudentUpdate(${student.id})">修改</button>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>

<div style="float: right">
    <!--条数说明： 第N页/共N页     -->
    <span id="page_n" name="page_n"></span>
    <!--下拉选择条数：默认：15 50 100 200-->
    <span>
        &emsp;<span>每页显示：</span>
        <span id="page_s" name="page_s"></span>条。&emsp;&emsp;
    </span>
    <!--上一步 1 2 3 4 5 6 下一步-->
    <span id="page_t" name="page_t"> </span>
    <!--跳转：-->
    &emsp;&emsp;
    <span>
        <span id="input_put"></span>&emsp;
        <span id="page_b" name="page_b"></span>
    </span>
</div>


<style>

</style>
</body>

</html>
