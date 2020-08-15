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
    //使用Ctrl+ /， 添加行注释，再次使用，去掉行注释
    /*
    使用 Ctrl+Shift+ /， 添加块注释，再次使用，去掉块注释；
  注意：如果已经写好代码块，使用块注释需要先选中要注释的块；
  去除注释的时候，不需要全部选中这块代码，只用光标在注释内容上按Ctrl+Shift+/即可。
    */
    /**
     * 输入/** ,点击“Enter”，自动根据参数和返回值生成注释模板
     * @return String
     */
    @RequestMapping("/boot/hello")
    public @ResponseBody String hello(){
        return "Hello Spring Boot";
    }
}
