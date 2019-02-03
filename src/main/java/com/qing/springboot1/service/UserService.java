package com.qing.springboot1.service;

import com.qing.springboot1.dao.User;
import com.qing.springboot1.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return userRepository.findAll(Sort.by(Sort.Order.asc("id")));
    }

    /**
     * @description 添加对象
     * @author lzq
     * @date 2019/2/2 22:50
     * @param
     * @return
     */
    public void addUser(User user) {
        userRepository.save(user);
    }

    /**
     * @description 根据主键查询实例
     * @author lzq
     * @date 2019/2/3 14:55
     * @param id 主键
     * @return User 实例
     */
    public User findById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    /**
     * @description 根据主键删除实例
     * @author lzq
     * @date 2019/2/3 15:02
     * @param id
     * @return
     */
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    /**
     * @description 分页查询
     * @author lzq
     * @date 2019/2/3 15:33
     * @param pageNum，pageSize
     * @return
     */
    public Page<User> findByPage(Integer pageNum, Integer pageSize) {
        return userRepository.findAll(PageRequest.of(pageNum-1, pageSize, Sort.by(Sort.Order.asc("id"))));
    }

    /**
     * @description 根据username 查询user集合
     * @author lzq
     * @date 2019/2/3 23:07
     * @param username
     * @return List<User>
     */
    public List<User> findByUsername(String username){
        return userRepository.findByUsernameLike(username);
    }

    /**
     * @description 根据username 查询user集合
     * @author lzq
     * @date 2019/2/3 23:07
     * @param age
     * @return List<User>
     */
    public List<User> findByAge(Integer age){
        //return userRepository.findByAgeGreaterThan(age, Sort.by(Sort.Order.asc("age")));
        return userRepository.findByAgeBetween(20, 30, Sort.by(Sort.Order.asc("age")));
    }
}
