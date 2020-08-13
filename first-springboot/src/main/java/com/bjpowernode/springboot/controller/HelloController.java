package com.bjpowernode.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: tianxin
 * @create: 2020-08-13 23:09
 */
@Controller
public class HelloController {
    @RequestMapping("/boot/hello")
    public @ResponseBody String hello(){
        return "Hello Spring Boot";
    }
}
