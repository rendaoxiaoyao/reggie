package com.rdxy.dbutil;

import com.rdxy.entity.Student;

import java.io.IOException;
import java.util.ArrayList;

public class MyTestUtil {
    public static void main(String[] args) throws IOException {
        ArrayList<Student> Students=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            //Students.add(new Student(RandomNameUtil.fullName(),"123456"));

        }

        ExcelUtil.GreateExcel(Students,"用户");

    }
}
