package com.qing.springboot1.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    //===============================================================================================================

    /*
    Java持久化查询语言(JPQL)是一种可移植的查询语言，旨在以面向对象表达式语言的表达式，
    将SQL语法和简单查询语义绑定在一起·使用这种语言编写的查询是可移植的，可以被编译成所有主流数据库服务器上的SQL
     */
    //自定义查询使用  JPQL
    @Query(value = "select u from User u where u.age >= ?1 and u.age <= ?2")
    List<User> findByAgeRange(Integer less, Integer greater);

    @Query(value = "select u from User u where u.age >= ?1 and u.age <= ?2")
    List<User> findByAgeRangeSort(Integer less, Integer greater, Sort sort);

    @Query(value = "select u from User u where u.age >= ?1 and u.age <= ?2")
    List<User> findByAgeRangeSortPage(Integer less, Integer greater, Pageable pageable);

    //自定义查询使用，原生 SQL
    @Query(nativeQuery = true, value = "select * from user u where u.age >= ?1 and u.age <= ?2")
    List<User> findByAgeRangeSql(Integer less, Integer greater);

    //如果想用原生的SQL 进行排序，就不能使用 Sort sort
    @Query(nativeQuery = true, value = "select * from user u where u.age >= ?1 and u.age <= ?2 order by u.age asc")
    List<User> findByAgeRangeSqlSort(Integer less, Integer greater);

    //===============================================================================================================
    //使用@param 注解指定方法参数的具体名称

    @Query(nativeQuery = true, value = "select * from user u where u.age >= ?1 and u.age <= ?2 order by u.age asc limit ?3, ?4")
    List<User> findByAgeRangeSqlSortPage(Integer less, Integer greater, Integer pageNum, Integer pageSize);

    @Query(value = "select u from User u where u.address = :address and u.email = :email")
    User findByAddressAndEmail(@Param("address") String address, @Param("email") String email);

    @Modifying
    @Query("update User u set u.age = ?2 where u.username = ?1")
    int updateAgeByUsername(String username, Integer age);
}
