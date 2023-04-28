<%@ page import="com.rdxy.model.Model" %>
<%@ page import="com.rdxy.entity.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>显示数据页面</title>
  </head>
  <body>
    <%
     Model model=new Model();
 	 ArrayList<User> arraylist=model.userSelect();
			%>

	<h1>用户成员</h1>
	<table align="center" border="2" cellpadding="15px" cellspacing="0">
		<thead>

		<tr>
			<th>id</th> <th>姓名</th> <th>密码</th>
		</tr>
		</thead>
		<tbody>
		<%for(int i=0;i<arraylist.size();i++){%>
		<tr>
			<td><%=arraylist.get(i).getId()%></td>
			<td><%=arraylist.get(i).getName() %></td>
			<td><%=arraylist.get(i).getPassword() %></td>
		</tr>
		<%
			}
		%>
		</tbody>
	</table>
  </body>
  <style>
	  body{
		  background: url(images/420.jpg);   /* biu特佛 的背景图片 */
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
  </style>
</html>
