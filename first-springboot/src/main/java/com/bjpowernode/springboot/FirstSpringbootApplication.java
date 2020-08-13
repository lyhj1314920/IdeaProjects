package com.bjpowernode.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstSpringbootApplication {

    public static void main(String[] args) {
        //启动了springboot程序，启动了spring容器，启动了内嵌的tomcat
        SpringApplication.run(FirstSpringbootApplication.class, args);
    }

}
