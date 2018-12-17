package com.qing.springboot1.manyThreadTest.fockjoinTest;

import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class MyTaskTest {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MyTask myTask = new MyTask(new File("D:\\"));
        forkJoinPool.invoke(myTask);
        System.out.println(myTask.join());
    }

}
