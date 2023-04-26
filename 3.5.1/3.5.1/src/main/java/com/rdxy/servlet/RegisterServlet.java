package com.rdxy.servlet;

import com.rdxy.entity.User;
import com.rdxy.service.UserService;
import com.rdxy.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private UserService userService=new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");


        String method = request.getParameter("method");

        switch (method){
            case "user":
                String name=request.getParameter("name");
                String password=request.getParameter("password");
                userService.insert(new User(name,password));


                User user=userService.find_name_id(name);
                request.setAttribute("user",user);
                request.getRequestDispatcher("/login.jsp").forward(request,response);


                break;



        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
