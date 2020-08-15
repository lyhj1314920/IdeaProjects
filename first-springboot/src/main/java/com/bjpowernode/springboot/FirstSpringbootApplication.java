package com.bjpowernode.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication SpringBoot应用，注释在某个类上，说明这个类是Spring Boot的主配置类，
 * SpringBoot通过运行这个类的main方法来启动springboot应用
 */
@SpringBootApplication
public class FirstSpringbootApplication {

    public static void main(String[] args) {
        //启动了springboot程序，启动了spring容器，启动了内嵌的tomcat
        SpringApplication.run(FirstSpringbootApplication.class, args);
    }

}
