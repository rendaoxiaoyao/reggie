<%@ page language="java" pageEncoding="gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>修改用户</title>
  </head>
  <body>
  <h1>根据id修改你的姓名和密码</h1><br/>
<form action="updateShow.jsp" method="post">
   请输入id：     <input type="text" name="id"><br/>
   请输入姓名： <input type="text" name="name"><br/>
    请输入密码：<input type="text" name="password"><br/>
    <input type="submit" value="提交">
</form>
  </body>
</html>
