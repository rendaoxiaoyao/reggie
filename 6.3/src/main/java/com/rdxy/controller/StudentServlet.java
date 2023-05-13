package com.rdxy.controller;

import com.rdxy.entity.Student;
import com.rdxy.entity.StudentU;
import com.rdxy.service.StudentService;
import com.rdxy.service.impl.StudentServiceImpl;
import com.rdxy.utils.UploadUtil;
import org.apache.commons.fileupload.FileUploadException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/students")
public class StudentServlet extends HttpServlet {

    private StudentService service=new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("students");
        String method=request.getParameter("method");
        method=method==null?"select":method;
        System.out.println(method);
        switch (method){
            case "insert":
                insert(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
            case "update":
                update(request,response);
                break;
            case "select":
                select(request,response);
                return;
            default:
                break;
        }
        response.sendRedirect("./students");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }


    private void insert(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("name");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        String grade = request.getParameter("grade");
        String score = request.getParameter("score");

        Student student=new Student(name,sex,Integer.parseInt(age),grade,Float.valueOf(score));

        service.insert(student);


    }
    private void delete(HttpServletRequest request, HttpServletResponse response) {
        String id=request.getParameter("id");
        if(id==null){
            service.delete();
        }else{
            service.delete(Integer.parseInt(id));
        }


    }
    private void update(HttpServletRequest request, HttpServletResponse response) {
        StudentU U = null;
        try {
            U= UploadUtil.upload(service,request,response);
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(U.getFileName()!=null&&U.getFileName()!=""){
            U.getStudent().setFile("./images/"+U.getFileName());
        }



        service.update(U.getStudent());



    }

    private void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String select = request.getParameter("select");
        select=select==null?"all":select;

        switch (select){
            case "one":
                String id=request.getParameter("id");
                Student student=service.getOne(id);
                request.setAttribute("student",student);
                request.getRequestDispatcher("/page/update.jsp").forward(request,response);
                break;

            case "all":
                String msg=request.getParameter("msg");
                if(msg!=null){
                    msg = new String(msg.getBytes("iso-8859-1"), "utf-8");
                }
                List<Student> list = service.getAll(msg);
                request.setAttribute("list",list);

                request.getRequestDispatcher("/page/select.jsp").forward(request,response);
                break;
        }
    }


}
