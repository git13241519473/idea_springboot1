package com.qing.springboot1.DesignModule23.dan_li_M;

/**
 * 单例模式
 * 静态内部类
 */
public class Singleton3 {

    //私有化构造器
    private Singleton3(){

    }

    //通过静态内部类获取单例对象
    private static class StaticSingletonClass{
        private static final Singleton3 INSTANCE = new Singleton3();
    }

    public static Singleton3 getInstance(){
        return StaticSingletonClass.INSTANCE;
    }
}
