package com.rdxy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(urlPatterns = {"/*"})

public class StudentFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, IOException {
        System.out.println("这里是doFilter");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String uri = request.getRequestURI();

        System.out.println(request.getRequestURI());
        if(uri.contains("login")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }


        Object Student = request.getSession().getAttribute("admin");
        if(Student==null){
            response.sendRedirect("/6.3/login.jsp");
            return;
        }

        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}
