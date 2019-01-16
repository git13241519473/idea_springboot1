package com.qing.springboot1.manyThreadTest.joinTest;

public class YeildDemo {

    public static void main(String[] args) {

        Thread myThread = new Thread(){
            public void run(){
                System.out.println("Hello word in new Thread");
            }
        };
        myThread.start();
        Thread.yield();
        System.out.println("Hello word in main Thread");
        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
