package com.rdxy.classes.servlet;

import com.rdxy.impl.MajorImpl;
import com.rdxy.impl.TeacherImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rdxy.entity.Major;
import com.rdxy.entity.Teacher;

public class PlanAddClassesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 准备添加班级
		TeacherImpl teacherImpl = new TeacherImpl();
		MajorImpl majorImpl = new MajorImpl();
		List<Teacher> list_teacher;
		List<Major> list_major;
		HttpSession session = request.getSession();
		list_major = majorImpl.query("all", "all");
		list_teacher = teacherImpl.query("all", "all");
		session.setAttribute("list_teacher", list_teacher);
		session.setAttribute("list_major", list_major);
		response.sendRedirect("pages/add_classes.jsp");
	}
}
