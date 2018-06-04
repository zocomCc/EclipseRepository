package com.springboot.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springboot.demo.interceptor.MyInterceptor1;
import com.springboot.demo.interceptor.MyInterceptor2;

@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**");
        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
    
    /**
     * 其中默认配置的 /** 映射到 /static （或/public、/resources、/META-INF/resources） 
     * 其中默认配置的 /webjars/** 映射到 classpath:/META-INF/resources/webjars/ 
     * PS：上面的 static、public、resources 等目录都在 classpath: 下面（如 src/main/resources/static）
     * 优先级顺序为：META/resources > resources > static > public 
     * 自定义以增加 /myres/* 映射到 classpath:/myres/* 
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 访问myres根目录下的5.jpg 的URL为 http://localhost:8080/5.jpg (/** 会覆盖系统默认的配置)
        // 其中 addResourceLocations 的参数是动参,可以这样写 addResourceLocations(“classpath:/img1/”, “classpath:/img2/”, “classpath:/img3/”);
        // registry.addResourceHandler("/**").addResourceLocations("classpath:/myres/").addResourceLocations("classpath:/static/");
        // 可以直接使用addResourceLocations 指定磁盘绝对路径，同样可以配置多个位置，注意路径写法需要加上file:
        // registry.addResourceHandler("/myimgs/**").addResourceLocations("file:H:/myimgs/");
        registry.addResourceHandler("/myres/**").addResourceLocations("classpath:/myres/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
