package com.rdxy.control;

import com.rdxy.entity.Student;
import com.rdxy.model.StudentModel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/students/ShowStudentServlet")
public class ShowStudentServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ???????????????ID
		String id = request.getParameter("id");
		if (null==id)
		{
			request.setAttribute("error", "?????????");
			request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
			return ;
		}
		Integer studentId = Integer.valueOf(id);
		// ??????????????????????
 		StudentModel model = new StudentModel();

		Student student = model.load(studentId);
		if (null==student)
		{
			request.setAttribute("error", "????????????????");
			request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
			return ;
		}
		// ????????????request??
		request.setAttribute("student", student);
		// ?????student.jsp
		request.getRequestDispatcher("/jsp/studentshow.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
