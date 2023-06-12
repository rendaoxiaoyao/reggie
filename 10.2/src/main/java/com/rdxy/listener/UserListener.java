package com.rdxy.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class UserListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("UserListener------1");

        ServletContext application=httpSessionBindingEvent.getSession().getServletContext();
        String key=httpSessionBindingEvent.getName();
        if(key.equals("isLogin")){
            Object loginR = application.getAttribute("loginR");
            Integer loginRnum=(Integer) loginR;
            if(loginR==null){
                loginRnum=1;
            }else {
                loginRnum++;
                System.out.println("新增一位登录");
            }
            application.setAttribute("loginR",loginRnum);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("UserListener------2");
        ServletContext application=httpSessionBindingEvent.getSession().getServletContext();
        String key=httpSessionBindingEvent.getName();
        if(key.equals("isLogin")){
            Integer loginRnum=(Integer) application.getAttribute("loginR");
            loginRnum--;
            System.out.println("减少一位登录人数");
            application.setAttribute("loginR",loginRnum);
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("UserListener------3");
    }
}
