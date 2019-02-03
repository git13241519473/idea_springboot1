package com.qing.springboot1.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    // 根据username查找
    List<User> findByUsername(String username);
    List<User> findByUsernameContaining(String username);
    List<User> findByUsernameLike(String username);
    List<User> findByUsernameStartingWith(String username);
    List<User> findByUsernameEndingWith(String username);


    // 根据年龄查找
    List<User> findByAgeGreaterThan(Integer age, Sort sort);
    List<User> findByAgeLessThanEqual(Integer age);
    List<User> findByAgeBetween(Integer less, Integer greater, Sort sort);
}
