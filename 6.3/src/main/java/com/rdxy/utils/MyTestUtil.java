package com.rdxy.utils;

import com.rdxy.entity.Student;

import java.io.IOException;
import java.util.ArrayList;

public class MyTestUtil {
    public static void main(String[] args) throws IOException {
        ArrayList<Student> lists=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            lists.add(new Student(RandomNameUtil.fullName(),"男",20,null,100));

        }

        ExcelUtil.GreateExcel(lists,"学生");

    }
}
