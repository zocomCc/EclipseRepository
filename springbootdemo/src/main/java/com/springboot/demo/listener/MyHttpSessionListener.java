package com.springboot.demo.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 
 * @ClassName: MyHttpSessionListener 
 * @Description: 监听Session的创建与销毁
 * @author cjc
 * @date 2018年5月30日 下午3:29:25
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener{

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session 创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session 销毁");
    }

}
