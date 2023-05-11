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
<form action="/6.3/students?method=update" method="post" enctype="multipart/form-data">
    编号：    <input type="text"name="id" value="${student.id}" readonly = "readonly"><br/>
    姓名：   <input type="text" name="name" value="${student.name}" ><br/>
    性别：   <input type="text" name="sex" value="${student.sex}" ><br/>
    年龄：   <input type="text" name="age" value="${student.age}" ><br/>
    班级：   <input type="text" name="grade" value="${student.grade}" ><br/>
    成绩：   <input type="text" name="score" value="${student.score}" ><br/>

    头像： <input type="file" id="file" name="file"><br/>
    <input id="button" type="submit" value="提交">
</form>

</body>
</html>
