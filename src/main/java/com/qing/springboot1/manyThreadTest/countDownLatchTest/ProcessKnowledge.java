package com.qing.springboot1.manyThreadTest.countDownLatchTest;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class ProcessKnowledge {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        //开始加工
        new Thread(() -> {
            System.out.println("开始加工知识");
            try {
                Thread.sleep(new Random().nextInt(10000));
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("加工知识完成");
            countDownLatch.countDown();
        }).start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("修改加工记录表的状态");
    }
}
