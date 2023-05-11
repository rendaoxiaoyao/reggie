package com.rdxy.controller;

import com.rdxy.entity.Student;
import com.rdxy.service.StudentService;
import com.rdxy.service.impl.StudentServiceImpl;
import com.rdxy.utils.InsertDB;
import com.rdxy.utils.UploadUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@WebServlet(name = "CommonServlet", value = "/CommonServlet")
public class CommonServlet extends HttpServlet {
    private StudentService service=new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");
        System.out.println("这里是CommonServlet");
        String method=request.getParameter("method");
        System.out.println(method);
        switch(method){
            case "upload":
                try {
                    String[] s = UploadUtil.upload(service, request, response);
                    String path=s[0];
                    String fileName=s[1];
                    if(fileName.split("\\.")[1].equals("xlsx")){
                        System.out.println("数据批量导入路径："+path);
                        InsertDB.insert(path);
                    }

                    response.sendRedirect("/6.3/students?method=select");

                } catch (FileUploadException e) {
                    e.printStackTrace();
                }

                System.out.println("成功了吗？");

                break;

            case "download":

                break;
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
}
