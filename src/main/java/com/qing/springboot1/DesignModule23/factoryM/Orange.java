package com.qing.springboot1.DesignModule23.factoryM;

public class Orange implements Factory {
    @Override
    public void eat() {
        System.out.println("吃橘子");
    }
}
