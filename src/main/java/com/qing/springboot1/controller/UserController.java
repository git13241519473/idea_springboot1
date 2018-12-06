package com.qing.springboot1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @RequestMapping("hello")
    public String sayHello(String name) {
        if(!(name != null && !"".equals(name))){
            name = "";
        }
        return "hello! " + name;
    }

    @RequestMapping("hello2")
    public String sayHello2(String name) {
        if(!(name != null && !"".equals(name))){
            name = "";
        }
        return "hello2 ! " + name;
    }

    @RequestMapping("test")
    public ModelAndView test(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("myTitle", "欢迎使用 thymeleaf");
        mav.setViewName("test");
        return mav;
    }
}
