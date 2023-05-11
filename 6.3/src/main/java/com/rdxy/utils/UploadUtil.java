package com.rdxy.utils;

import com.rdxy.entity.Student;
import com.rdxy.service.StudentService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class UploadUtil {

    public static String[] upload(StudentService service,HttpServletRequest request, HttpServletResponse response) throws FileUploadException, IOException {
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
            }else{
                fileName = fileItem.getName();
                long size = fileItem.getSize();
                System.out.println(fileName+":"+size+"Byte");
                InputStream inputStream = fileItem.getInputStream();
// Reader reader = new InputStreamReader(inputStream);
// BufferedReader bufferedReader = new BufferedReader(reader);

                String file=request.getParameter("file");
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
        return new String[]{path,fileName};

    }

}
