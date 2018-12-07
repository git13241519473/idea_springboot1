package com.qing.springboot1.singletonTest;

/**
 * 单例模式
 * 2、懒汉式
 */
public class Singleton2 {

    //私有化构造器
    private Singleton2(){

    }

    //定义一个静态变量
    private static Singleton2 instance;

    public static Singleton2 getInstance(){
        if(instance == null){
            synchronized (Singleton2.class){
                if(instance == null){
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }

}
