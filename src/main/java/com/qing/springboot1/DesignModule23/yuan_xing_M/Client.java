package com.qing.springboot1.DesignModule23.yuan_xing_M;

public class Client {

    public static void main(String[] args) {
        User user = new User();
        user.setName("张三");
        user.setAge(25);
        user.setSex("男");

        User user1 = user.clone();
        user1.setName("李四");
        System.out.println(user);
        System.out.println(user1);

        People people = new People("张三", "男", 25);
        People people1 = null;
        try {
            people1 = people.myClone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        people1.setAge(26);
        people1.setName("李四");
        System.out.println(people);
        System.out.println(people1);

    }

}
