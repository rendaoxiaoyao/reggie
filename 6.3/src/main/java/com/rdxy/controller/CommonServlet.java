package com.rdxy.controller;

import com.rdxy.utils.InsertDB;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@WebServlet(name = "CommonServlet", value = "/CommonServlet")
public class CommonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");
        System.out.println("这里是CommonServlet");
        String method=request.getParameter("method");
        System.out.println(method);
        switch(method){
            case "upload":
                try {
                    DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
                    ServletFileUpload servletFileUpload = new
                            ServletFileUpload(fileItemFactory);
                    List<FileItem> list = servletFileUpload.parseRequest(request);
                    for(FileItem fileItem : list){
                        System.out.println(fileItem);
                        if(fileItem.isFormField()){
                            String name = fileItem.getFieldName();
                            String value = fileItem.getString("UTF-8");
                            System.out.println(name+":"+value);
                        }else{
                            String fileName = fileItem.getName();
                            long size = fileItem.getSize();
                            System.out.println(fileName+":"+size+"Byte");
                            InputStream inputStream = fileItem.getInputStream();
// Reader reader = new InputStreamReader(inputStream);
// BufferedReader bufferedReader = new BufferedReader(reader);
                            String path =
                                    request.getServletContext().getRealPath("file/"+fileName);
                            OutputStream outputStream = new FileOutputStream(path);
// Writer writer = new OutputStreamWriter(outputStream);
// BufferedWriter bufferedWriter = new BufferedWriter(writer);
                            int temp = 0;
                            while((temp = inputStream.read())!=-1){
                                outputStream.write(temp);
                            }
// bufferedWriter.close();
// writer.close();
                            outputStream.close();
// bufferedReader.close();
// reader.close();
                            inputStream.close();
                            System.out.println("上传成功");

                            if(fileName.split("\\.")[1].equals("xlsx")){
                                System.out.println("数据批量导入路径："+path);
                                InsertDB.insert(path);
                            }

                            response.sendRedirect("/3.5.1/Students/StudentServlet?method=select");
                        }
                    }
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
