package com.rdxy.servlet;

import com.rdxy.entity.User;
import com.rdxy.service.UserService;
import com.rdxy.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("doGet");
        req.setCharacterEncoding("UTF-8");
        //Integer id= Integer.valueOf(req.getParameter("id"));
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        System.out.println("name="+name+",password="+password);
        User user=new User(name,password);
        user=userService.getById(user);

        if(user==null||!user.getPassword().equals(password)){
            resp.sendRedirect("http://localhost:8080/3.5.1/login.jsp");
            return;
        }
        System.out.println("user="+user.toString());
        req.getSession().setAttribute("user",user);
        req.setAttribute("user",user);

        req.getRequestDispatcher("/index.jsp").forward(req,resp);
        return;

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req,resp);
    }
}
