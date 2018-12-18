package com.qing.springboot1.manyThreadTest.countDownLatchTest;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class UseCountDownLatch {

    private static volatile int threadCount = 7;

    private static CountDownLatch countDownLatch = new CountDownLatch(threadCount);

    public static void main(String[] args) {

        for(int i = 1; i <= threadCount; i++){
            int index = i;
            new Thread(() -> {
                System.out.println("开始寻找第" + index + "颗龙珠....................");
                try {
                    Thread.sleep(new Random().nextInt(10000));
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("第" + index + "颗龙珠已收集到！");
                countDownLatch.countDown();
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("集齐七个龙珠，开始召唤神龙。");
    }

}
