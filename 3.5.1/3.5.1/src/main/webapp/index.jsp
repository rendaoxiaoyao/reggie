<%--
  Created by IntelliJ IDEA.
  User: 人道逍遥
  Date: 2023/4/20
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>用户综合管理软件</title>
  </head>
  <body>
  <button id="add">增加</button><br>
  <button id="delete">删除</button><br>
  <button id="update">修改</button><br>
  <button id="select">查询</button><br>


  <script>
  document.getElementById('add').addEventListener('click',function () {
    location.href="/3.5.1/page/insert.jsp"
  })
  document.getElementById('delete').addEventListener('click',function () {
    location.href="/3.5.1/page/delete.jsp"
  })
  document.getElementById('update').addEventListener('click',function () {
    location.href="/3.5.1/page/update.jsp"
  })
  document.getElementById('select').addEventListener('click',function () {
    location.href="/3.5.1/UserServlet?method=select"
  })

  </script>
  </body>
<style>
  button{
    background-color:#f66f6a;
    color:white;
    width: 80px;
    height: 40px;
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
