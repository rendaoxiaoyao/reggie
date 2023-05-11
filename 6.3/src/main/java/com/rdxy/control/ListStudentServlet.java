
package com.rdxy.control;

import com.rdxy.model.StudentModel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ListStudentServlet  extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

 		StudentModel model = new StudentModel();

		List list = model.search();
		request.setAttribute("studentlist", list);
		request.getRequestDispatcher("/jsp/studentlist.jsp").forward(request, response);
		//response.sendRedirect("jsp/studentlist.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}






