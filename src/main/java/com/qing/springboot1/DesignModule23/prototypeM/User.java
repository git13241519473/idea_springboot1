package com.qing.springboot1.DesignModule23.prototypeM;

import org.springframework.beans.BeanUtils;

public class User {
    private String name;
    private String sex;
    private int age;

    //第一种克隆方法，通过 BeanUtils.copyProperties();
    public User clone(){
        User user = new User();
        BeanUtils.copyProperties(this, user);
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {
    }

    public User(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
