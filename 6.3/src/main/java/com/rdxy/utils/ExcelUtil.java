package com.rdxy.utils;

import com.rdxy.entity.Student;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class ExcelUtil {

    public static void NumberExcel(int num) throws IOException {
        ArrayList<Student> list=new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(new Student(RandomNameUtil.fullName(),"男",20,null,100));

        }

        ExcelUtil.GreateExcel(list,"学生");
    }

    public static void GreateExcel(ArrayList<Student> list, String ExcelName) throws IOException {

        //1. 创建一个Excel表格
        XSSFWorkbook workbook = new XSSFWorkbook();
        //2. 创建工作表
        XSSFSheet sheet = workbook.createSheet(ExcelName);

        //3. 创建行
        XSSFRow row = sheet.createRow(0);
        //4. 创建单元格赋值
        XSSFCell cell1 = row.createCell(0);
        cell1.setCellValue("id");
        XSSFCell cell2 = row.createCell(1);
        cell2.setCellValue("姓名");
        XSSFCell cell3 = row.createCell(2);
        cell3.setCellValue("性别");
        XSSFCell cell4 = row.createCell(2);
        cell3.setCellValue("年龄 ");
        XSSFCell cell5 = row.createCell(2);
        cell3.setCellValue("班级");
        XSSFCell cell6 = row.createCell(2);
        cell3.setCellValue("成绩");


        int start_len=1001;

        for (int i = 0; i < list.size(); i++) {

            //3. 创建行
            row = sheet.createRow(i+1);
            //4. 创建单元格赋值
            cell1 = row.createCell(0);
            cell1.setCellValue(start_len+i);

            cell2 = row.createCell(1);
            cell2.setCellValue(list.get(i).getName());

            cell3 = row.createCell(2);
            cell3.setCellValue(list.get(i).getSex());

            cell4 = row.createCell(2);
            cell4.setCellValue(list.get(i).getAge());

            cell5 = row.createCell(2);
            cell5.setCellValue(list.get(i).getGrade());

            cell6 = row.createCell(2);
            cell6.setCellValue(list.get(i).getScore());


        }



        //5. 通过输出流将对象下载到磁盘
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Students.xlsx");
        workbook.write(fileOutputStream);
        //刷新输出流
        fileOutputStream.flush();
        //6. 释放资源
        fileOutputStream.close();
        workbook.close();


    }

}
