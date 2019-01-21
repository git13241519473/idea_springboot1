package com.qing.springboot1.controller;

import com.qing.springboot1.utils.redisTest.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("hello")
    public String sayHello(String name) {
        if(!(name != null && !"".equals(name))){
            name = "";
        }
        return "hello! " + name;
    }

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        boolean aSet = redisUtil.set("a", "123", 10);
        long aLong = redisUtil.getExpire("a");
        return aLong + "";
    }

    @RequestMapping("test")
    public ModelAndView test(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("myTitle", "欢迎使用 thymeleaf");
        mav.setViewName("test");
        return mav;
    }
}
