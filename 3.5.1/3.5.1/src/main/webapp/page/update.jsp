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
</head>
<body>

<form action="/3.5.1/UserServlet?method=update&" method="get">
        请输入id：    <input type="text" name="id" value="${user.id}" readonly = "readonly"><br/>
    请输入姓名：   <input type="text" name="name" value="${user.name}"><br/>
    请输入密码：   <input type="text" name="password" value="${user.password}"><br/>
    <input type="submit" value="提交">
</form>

</body>
</html>
