<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>学生详细信息</title>
	</head>
	<body>
		<center>
			<h1> 
				删除的学生信息 
			</h1>
		</center>
		<table align="center" width="360" border="1" cellspacing="0"
			cellpadding="5">

			<tr>
				<td align="center">
					编号
				</td>
				<td>
					${student.id}
				</td>
			</tr>

			<tr>
				<td align="center">
					姓名
				</td>
				<td>
					${student.name}
				</td>
			</tr>
			<tr>
				<td align="center">
					性别
				</td>
				<td>
					${student.sex}
				</td>
			</tr>
			<tr>
				<td align="center">
					班级
				</td>
				<td>
					${student.grade}
				</td>
			</tr>

			<tr>
				<td align="center">
					年龄
				</td>
				<td>
					${student.age}
				</td>
			</tr>

			<tr>
				<td align="center">
					成绩
				</td>
				<td>
					${student.score}
				</td>
			</tr>
		</table>
		<table align="center" width="360" border="0">
			<tr>
				<td align="center">
					<form action="DeleteStudentservlet.do?id=${student.id}" method="post">
						<input type="submit" value="删除">
					</form>
				</td>
				<td align="center">
					<form action="ListStudentServlet.do" method="post">
						<input type="submit" value="返回">
					</form>
				</td>
			</tr>
		</table>

	</body>
</html>
