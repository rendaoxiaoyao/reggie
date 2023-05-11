package com.rdxy.control;

import com.rdxy.model.StudentModel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Insertservlet extends HttpServlet {

	public Insertservlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    request.setCharacterEncoding("gbk");
	 		int id = Integer.parseInt(request.getParameter("id"));
	 		String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			int age = Integer.parseInt(request.getParameter("age"));
			String grade = request.getParameter("grade");
			float score = Float.parseFloat(request.getParameter("score"));

     		StudentModel model = new StudentModel();
	 	    model.insert(id, name, sex, age, grade, score);
	 	    response.sendRedirect("ListStudentServlet.do");
	}

}
