package com.springboot.demo.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MyStartupRunner2 implements CommandLineRunner{

    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>启动加载数据中。。。 2222222 <<<<<<<<<<<<<<");
    }

}
