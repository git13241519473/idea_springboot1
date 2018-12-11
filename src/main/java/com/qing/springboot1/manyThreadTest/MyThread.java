package com.qing.springboot1.manyThreadTest;

public class MyThread extends Thread{

    @Override
    public void run(){
        System.out.println("启动一个线程：" + Thread.currentThread().getName());
    }

    ThreadLocal<String> threadLocal = new ThreadLocal<>();

}
