package com.rdxy.test;

public class Test {
    public static void main(String[] args) {

        String file="a.ba.c.d.e.f.g";

        String[] split = file.split("\\.");
        for (String s : split) {
            System.out.println(s);
        }



    }

}
