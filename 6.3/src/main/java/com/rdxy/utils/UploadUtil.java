package com.rdxy.utils;

import com.rdxy.entity.Student;
import com.rdxy.entity.StudentU;
import com.rdxy.service.StudentService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UploadUtil {

    public static StudentU upload(StudentService service,HttpServletRequest request, HttpServletResponse response) throws FileUploadException, IOException {
        StudentU U=new StudentU();
        Map<String,String> map=new HashMap<>();

        String path = null;
        String fileName=null;

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
                map.put(name,value);
            }else{
                fileName = fileItem.getName();
                long size = fileItem.getSize();
                System.out.println(fileName+":"+size+"Byte");
                InputStream inputStream = fileItem.getInputStream();
// Reader reader = new InputStreamReader(inputStream);
// BufferedReader bufferedReader = new BufferedReader(reader);

                String file=request.getParameter("file");
                if(fileName==null||fileName==""){
                    continue;
                }
                System.out.println("111111111111111111111="+fileName);

                if(fileName.split("\\.")[1].equals("jpg")||fileName.split("\\.")[1].equals("png")){
                    file="images";
                }else{
                    file="file";
                }
                path =
                        request.getServletContext().getRealPath(file+"/"+fileName);
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

            }
        }

        Student s=new Student();
        if(map.size()>0){
            s.setId(Integer.parseInt(map.get("id")));
            s.setName(map.get("name"));
            s.setSex(map.get("sex"));
            s.setAge(Integer.parseInt(map.get("age")));
            s.setGrade(map.get("grade"));
            s.setScore(Float.valueOf(map.get("score")));
        }

        U.setStudent(s);
        U.setFileName(fileName);
        U.setPath(path);


        System.out.println("path1111111111="+path);

        return U;

    }

}
