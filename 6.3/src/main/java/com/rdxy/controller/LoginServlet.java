package com.rdxy.controller;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String password=req.getParameter("password");

        if(name.equals("1001")&&password.equals("123456")){
            req.getSession().setAttribute("admin",name);
            resp.sendRedirect("./page/index.jsp");
            return;
        }
        resp.sendRedirect("./login.jsp");

        return;

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req,resp);
    }
}
