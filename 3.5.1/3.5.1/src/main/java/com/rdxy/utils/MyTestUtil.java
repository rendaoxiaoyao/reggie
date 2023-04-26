package com.rdxy.utils;

import com.rdxy.entity.User;

import java.io.IOException;
import java.util.ArrayList;

public class MyTestUtil {
    public static void main(String[] args) throws IOException {
        ArrayList<User> users=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            users.add(new User(RandomNameUtil.fullName(),"123456"));

        }

        ExcelUtil.GreateExcel(users,"用户");

    }
}
