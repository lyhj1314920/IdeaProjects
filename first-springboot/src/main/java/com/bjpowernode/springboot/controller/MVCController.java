package com.bjpowernode.springboot.controller;

import com.bjpowernode.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.awt.SunHints;

/**
 * @author: tianxin
 * @create: 2020-08-13 23:09
 */
@RestController // = @Controller + @ResponseBody
public class MVCController {
    @RequestMapping(value="/boot/getUser" , method = RequestMethod.GET)
    public Object getUser(){
        User user = new User();
        user.setId(18);
        user.setName("李红娇");
        return user;
    }

    /**
     * @GetMapping 只支持get请求 @GetMapping = @RequestMapping + RequestMethod.GET
     * @return
     */
    @GetMapping("/boot/getUser1")
    public Object getUser1(){
        User user = new User();
        user.setId(18);
        user.setName("李红娇");
        return user;
    }

    /**
     * @PostMapping 只支持post请求 @PostMapping = @RequestMapping + RequestMethod.POST
     * @return
     */
    /*@PostMapping("/boot/getUser2")
    public Object getUser2(){
        User user = new User();
        user.setId(18);
        user.setName("李红娇");
        return user;
    }*/
}
