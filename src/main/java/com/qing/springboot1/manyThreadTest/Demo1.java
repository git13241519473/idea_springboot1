package com.qing.springboot1.manyThreadTest;

import java.util.concurrent.TimeUnit;

public class Demo1 {
    /*public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("当前现线程是：" + Thread.currentThread() + "当前时间戳是："+ System.currentTimeMillis());
            }
        });

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.start();
        System.out.println("main线程结束");
    }*/

    /*public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("另一个线程开始执行");
                try {
                    TimeUnit.DAYS.sleep(1L);
                    System.out.println("睡眠结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("finally 块被执行");
                }
            }
        });
        thread.start();

        if (!thread.isInterrupted()){
            thread.interrupt();
        }
        System.out.println("主线程结束");
    }*/


    /*public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        //这样写，其实是使用了代理模式（而且还是静态代理）
        Thread t1 = new Thread(myThread);
        t1.start();

        Thread t2 = new Thread(myThread);
        t2.start();
    }*/


    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i++){
                    System.out.println("thread 1: " + i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i++){
                    System.out.println("thread 2: " + i);
                }
            }
        });

        t1.setPriority(8); //注意优先级是概率而非先后顺序（优先级高可能会执行时间长，但也不一定）

        t1.start();
        t2.start();
    }
}
