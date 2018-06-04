package com.springboot.demo;

import javax.servlet.http.HttpServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.springboot.demo.servlet.MyServlet;

@SpringBootApplication
@ServletComponentScan
public class SpringbootdemoApplication {

    /**
     * 
     * <p>Title: servletRegistrationBean</p>
     * @author cjc
     * @date 2018年5月30日 下午2:51:56
     * @return ServletRegistrationBean<HttpServlet>
     * <p>Description: 使用代码注册Servlet（不需要@ServletComponentScan注解）</p>
     * @return
     */
    @Bean
    public ServletRegistrationBean<HttpServlet> servletRegistrationBean() {
        return new ServletRegistrationBean<HttpServlet>(new MyServlet(), "/xs/*");// ServletName默认值为首字母小写，即myServlet
    }
    
	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}
}
