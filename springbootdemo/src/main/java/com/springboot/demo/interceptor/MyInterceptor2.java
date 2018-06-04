package com.springboot.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @ClassName: MyInterceptor2 
 * @Description: 只有经过DispatcherServlet 的请求，才会走拦截器链，我们自定义的Servlet 请求是不会被拦截的，比如我们自定义的Servlet地址 http://localhost:8080/xs/myservlet 是不会被拦截器拦截的。并且不管是属于哪个Servlet 只要复合过滤器的过滤规则，过滤器都会拦截。
 * @author cjc
 * @date 2018年5月31日 上午9:13:13
 */
public class MyInterceptor2 implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println(">>>Myinterceptor2>>>在请求处理之前进行调用(controller方法调用之前)");
        return true; // 只有返回true才会继续向下执行,返回false取消当前请求.
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println(">>>Myinterceptor2>>>在请求处理之后进行调用,但是在试图渲染之前(controller方法调用之后)");
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println(">>>Myinterceptor2>>>在整个请求结束之后调用,也就是在DispatcherServlet渲染了视图之后执行(主要是用于资源清理工作)");
    }
}
