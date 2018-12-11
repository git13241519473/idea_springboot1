package com.qing.springboot1.DesignModule23.singletonM;

/**
 * 单例模式
 * 饿汉式
 */
public class Singleton1 {

    //私有化构造器
    private Singleton1(){

    }

    //定义静态常量
    private static final Singleton1 INSTANCE = new Singleton1();

    public static Singleton1 getInstance(){
        return INSTANCE;
    }
}
