package com.rdxy.student.servlet;

import com.rdxy.impl.StudentImpl;
import com.rdxy.impl.TeacherImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rdxy.entity.Classes;
import com.rdxy.entity.Operator;
import com.rdxy.entity.Student;
import com.rdxy.entity.Teacher;

public class SearchClassmatesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 学生查找同班同学
		StudentImpl studentImpl = new StudentImpl();
		TeacherImpl teacherImpl = new TeacherImpl();
		List<Student> list_student;
		HttpSession session = request.getSession();
		Operator operator = (Operator) session.getAttribute("log_operator");
		Student student = studentImpl.query("ope_id", operator.getId() + "")
				.get(0);
		Classes classes = student.getClasses();
		Teacher teacher = teacherImpl.query("stu_id", student.getId() + "")
				.get(0);
		list_student = studentImpl.query("cla_id", classes.getId() + "");
		session.setAttribute("list_student", list_student);
		session.setAttribute("classes", classes);
		session.setAttribute("teacher", teacher);
		session.setAttribute("studentNum", list_student.size());
		response.sendRedirect("pages/search_classmate.jsp");
	}
}
