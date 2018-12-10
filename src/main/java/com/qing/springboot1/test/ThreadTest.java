package com.qing.springboot1.test;

import java.util.concurrent.Callable;

public class ThreadTest implements Callable<String> {

    @Override
    public String call() throws Exception {
        //Thread.sleep(10000);
        return "callable result";
    }
}
