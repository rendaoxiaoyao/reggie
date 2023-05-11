<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>新增学生信息</title>
    
  </head>
  
  <body>
  
 <center>
		<h1>插入学生信息</h1>
			<form action="../InsertStudentservlet.do" method="post">

				<p>学号: <input type="text" name="id"></p>
				<p>姓名:
				<input type="text" name="name" />
				<br></p>
				<p>性别:
				<input type="text" name="sex" />
				<br></p>
                <p> 年龄:
				<input type="text" name="age" />
				<br></p>
                <p>  班级:
				<input type="text" name="grade" />
				<br></p>
                <p>  成绩:
				<input type="text" name="score" />
				<br></p>
				<input type="submit" value="提交" />
				<input type="reset" value="重置" />
			</form>
     </center>
  </body>
</html>
