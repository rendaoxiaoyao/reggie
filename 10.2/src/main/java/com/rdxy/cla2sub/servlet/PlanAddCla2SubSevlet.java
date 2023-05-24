package com.rdxy.cla2sub.servlet;

import com.rdxy.impl.ClassesImpl;
import com.rdxy.impl.TeacherImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rdxy.entity.Classes;
import com.rdxy.entity.Teacher;

public class PlanAddCla2SubSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 添加班级课程前查询可选班级
		TeacherImpl teacherImpl = new TeacherImpl();
		ClassesImpl classesImpl = new ClassesImpl();
		List<Teacher> list_teacher;
		List<Classes> list_classes;
		HttpSession session = request.getSession();
		list_classes = classesImpl.query("all", "all");
		list_teacher = teacherImpl.query("all", "all");
		session.setAttribute("list_teacher", list_teacher);
		session.setAttribute("list_classes", list_classes);
		response.sendRedirect("pages/add_classes_subject.jsp");

	}
}
