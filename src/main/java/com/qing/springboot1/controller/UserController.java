package com.qing.springboot1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("hello")
    public String sayHello(String name) {
        if(!(name != null && !"".equals(name))){
            name = "";
        }
        return "hello! " + name;
    }

}
