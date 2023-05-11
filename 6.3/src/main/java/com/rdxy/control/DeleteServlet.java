package com.rdxy.control;

import com.rdxy.model.StudentModel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/students/DeleteServlet")
public class DeleteServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeleteServlet() {
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
       this.doPost(request, response);
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
     		request.setCharacterEncoding("gbk");
     		int id=Integer.parseInt(request.getParameter("id"));
     		StudentModel model = new StudentModel();
	 	    model.delete(id);
	 	    response.sendRedirect("/students/ListStudentServlet");
	}

}
