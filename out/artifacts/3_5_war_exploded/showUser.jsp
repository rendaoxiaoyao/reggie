<%@ page import="com.rdxy.model.Model" %>
<%@ page import="com.rdxy.entity.User" %>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>显示数据页面</title>
  </head>
  <body>
    <%
    int id=Integer.parseInt(request.getParameter("id"));
     Model model=new Model();
 	 User user=model.load(id);
	%>
	<%=user.getId() %>
	<%=user.getName() %>
	<%=user.getPassword() %>
  </body>
</html>
