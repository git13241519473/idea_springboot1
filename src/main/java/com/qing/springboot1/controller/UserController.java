//package com.qing.springboot1.controller;
//
//import com.qing.springboot1.dao.User;
//import com.qing.springboot1.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    //基础用法
//    @RequestMapping("findAllUsers")
//    @ResponseBody
//    public Iterable<User> findAllUsers(){
//        return userService.findAllUsers();
//    }
//
//    @RequestMapping("addUser")
//    public void addUser(String username, String password){
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//        userService.addUser(user);
//    }
//
//    @RequestMapping("findById")
//    @ResponseBody
//    public User findById(Integer id){
//        return userService.findById(id);
//    }
//
//    @RequestMapping("deleteById")
//    public void deleteById(Integer id){
//        userService.deleteById(id);
//    }
//
//    @RequestMapping("findByPage")
//    @ResponseBody
//    public Page<User> findByPage(@RequestParam(required = false, defaultValue = "1") Integer pageNum, @RequestParam(required = false, defaultValue = "10") Integer pageSize){
//        Page<User> page = userService.findByPage(pageNum, pageSize);
//        return page;
//    }
//
//    //自定义查询方法
//    @RequestMapping("findByUsername")
//    @ResponseBody
//    public List<User> findByUsername(String username){
//        return userService.findByUsername(username);
//    }
//
//    @RequestMapping("findByAge")
//    @ResponseBody
//    public List<User> findByAge(Integer age){
//        return userService.findByAge(age);
//    }
//
//    //使用注解查询方法
//    @RequestMapping("findByAgeRange")
//    @ResponseBody
//    public List<User> findByAgeRange(Integer less, Integer greater){
//        return userService.findByAgeRange(less, greater);
//    }
//
//    @RequestMapping("updateAgeByUsername")
//    @ResponseBody
//    public int updateAgeByUsername(String username, Integer age){
//        int result = userService.updateAgeByUsername(username, age);
//        return result;
//    }
//
//}
