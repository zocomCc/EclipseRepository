package com.springboot.demo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 
 * @ClassName: MyServletContextListener 
 * @Description: 使用@WebListener注解，实现ServletContextListener接口
 * @author cjc
 * @date 2018年5月30日 下午3:27:12
 */
@WebListener
public class MyServletContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext初始化");
        System.out.println(sce.getServletContext().getServerInfo());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext销毁");
    }

}
