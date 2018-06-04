package com.springboot.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor1 implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println(">>>Myinterceptor1>>>在请求处理之前进行调用(controller方法调用之前)");
        return true; // 只有返回true才会继续向下执行,返回false取消当前请求.
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println(">>>Myinterceptor1>>>在请求处理之后进行调用,但是在试图渲染之前(controller方法调用之后)");
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println(">>>Myinterceptor1>>>在整个请求结束之后调用,也就是在DispatcherServlet渲染了视图之后执行(主要是用于资源清理工作)");
    }
}
