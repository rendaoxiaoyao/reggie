<%@ page language="java" import="java.util.*,dbutil.*,entity.*,model.*"
	pageEncoding="gbk"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>修改学生信息</title>
	</head>

	<body>
		<center>
			<h1>
				修改学生信息
			</h1>
			<form action="DoUpdatStudenteservlet.do?id=${student.id}" method="post">
				<p>
					学号: ${student.id}
				</p>
				<p>
					姓名:
					<input type="text" name="name" value="${student.name}" />
					<br>
				</p>
				<p>
					性别:
					<input type="text" name="sex" value="${student.sex}" />
					<br>
				</p>
				<p>
					年龄:
					<input type="text" name="age" value="${student.age}" />
					<br>
				</p>
				<p>
					班级:
					<input type="text" name="grade" value="${student.grade}" />
					<br>
				</p>
				<p>
					成绩:
					<input type="text" name="score" value="${student.score}" />
					<br>
				</p>
				<input type="submit" value="修改" />
				<input type="reset" value="重置" />
			</form>

		</center>
	</body>
</html>
