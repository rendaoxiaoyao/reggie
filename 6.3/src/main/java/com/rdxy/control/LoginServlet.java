package com.rdxy.control;

import com.rdxy.dbutil.ExcelUtil;
import com.rdxy.entity.Student;
import com.rdxy.service.StudentService;
import com.rdxy.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private StudentService StudentService=new StudentServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        System.out.println("doGet");
        req.setCharacterEncoding("UTF-8");

        req.getRequestDispatcher("/index.jsp").forward(req,resp);
        return;

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req,resp);
    }
}
