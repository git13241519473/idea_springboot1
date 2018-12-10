package com.qing.springboot1.test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyTest {
    /*public static void main(String[] args) {
        User[] users = new User[]{
                new User("zhangsan", 20),
                new User("lisi", 21),
                new User("wangwu", 22)
        };
        //Arrays.asList(Object[] T),返回的 List 是Arrays类里面的一个内部类（final 修饰的）
        *//*private final E[] a;
        ArrayList(E[] array) {
            a = Objects.requireNonNull(array);
        }*//*
        List<User> list = Arrays.asList(users);
        for(int i = 0; i < list.size(); i++){
            User user = list.get(i);
            user.setName(user.getName() + "haha");
        }
        for (User user: list) {
            System.out.println(user);
        }

        list.add(new User("xiaoliuzi", 24)); //报错
    }*/

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        FutureTask<String> futureTask = new FutureTask<>(threadTest);
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            System.out.println(futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
