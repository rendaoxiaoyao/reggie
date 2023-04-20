<%@ page import="com.rdxy.model.Model" %>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>显示数据页面</title>
  </head>
  <body>
    <%
    request.setCharacterEncoding("gbk");
    int id=Integer.parseInt(request.getParameter("id"));
    String name=request.getParameter("name");
    String password=request.getParameter("password");
     Model model=new Model();
	%>
	插入完成，请查看插入后的结果
	<%= model.insert(id,name,password) %>
	<form action="allShow.jsp">
	<input type="submit" value="显示所有用户">
	</form>
  </body>
</html>
