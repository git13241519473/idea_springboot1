package com.qing.springboot1.test;

public class DemonTest implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("当前线程名称：" + Thread.currentThread().getName() + " 正在运行。");

        } finally {
            System.out.println("......这里是 finally 块");
        }
    }
}
