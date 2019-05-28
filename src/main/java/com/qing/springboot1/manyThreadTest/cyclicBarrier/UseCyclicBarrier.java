package com.qing.springboot1.manyThreadTest.cyclicBarrier;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UseCyclicBarrier {

    private static volatile int threadCount = 7;

    private static ExecutorService executors = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        //第一个屏障点，召集7个法师，一同去寻找龙珠
        CyclicBarrier cyclicBarrier1 = new CyclicBarrier(threadCount, new Runnable() {
            @Override
            public void run() {
                System.out.println("召集齐了法师，开始寻找龙珠");
                //findLongZhu();
            }
        });
        for(int i = 1; i <= threadCount; i++){
            int index = i;
            executors.execute( new Thread(() -> {
                try {
                    Thread.sleep(new Random().nextInt(5000));
                    System.out.println("召唤到第" + index + "个法师");
                    cyclicBarrier1.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }));
        }
    }

    //第二个屏障点，寻找龙珠
    public static void findLongZhu(){
        CyclicBarrier cyclicBarrier2 = new CyclicBarrier(threadCount, new Runnable() {
            @Override
            public void run() {
                System.out.println("集齐7颗龙珠。");
            }
        });

        for(int i = 1; i <= threadCount; i++){
            int index = i;
            new Thread(() -> {
                try {
                    Thread.sleep(new Random().nextInt(5000));
                    System.out.println("收集到到第" + index + "个龙珠");
                    cyclicBarrier2.await();
                    System.out.println("上交国家第" + index + "个龙珠");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    /*
    CyclicBarrier和CountDownLatch的区别
        （1）CountDownLatch的计数器只能使用一次。而CyclicBarrier的计数器可以使用reset() 方法重置。
            所以CyclicBarrier能处理更为复杂的业务场景，比如如果计算发生错误，可以重置计数器，并让线程们重新执行一次。

        （2）CyclicBarrier还提供其他有用的方法，比如getNumberWaiting方法可以获得CyclicBarrier阻塞的线程数量。
            isBroken方法用来知道阻塞的线程是否被中断。比如以下代码执行完之后会返回true。

        （3）CountDownLatch会阻塞主线程，CyclicBarrier不会阻塞主线程，只会阻塞子线程。
     */
}
