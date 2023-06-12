package com.rdxy.listener;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class NumberListener implements HttpSessionListener {


    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext application=httpSessionEvent.getSession().getServletContext();
        Integer number=(Integer)application.getAttribute("number");
        if(null==number){
            number=0;
        }
        number++;
        application.setAttribute("number",number);

        System.out.println("新增一位在线用户！");


    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext application =httpSessionEvent.getSession().getServletContext();
        Integer number=(Integer)application.getAttribute("number");//要转换为数字时 要默认用（Integer）强转
        number--;
        application.setAttribute("number",number);
        System.out.println("一位用户离线");

    }
}

