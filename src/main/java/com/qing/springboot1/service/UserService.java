package com.qing.springboot1.service;

import com.qing.springboot1.dao.User;
import com.qing.springboot1.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    /**
     * @description 获取所有用户
     * @author lzq
     * @date 2019/2/2 22:50
     * @param
     * @return Iterable<User>
     */
    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    /**
     * @description 方法说明
     * @author lzq
     * @date 2019/2/2 22:50
     * @param
     * @return
     */
    public void addUser(User user) {
        userRepository.save(user);
    }
}
