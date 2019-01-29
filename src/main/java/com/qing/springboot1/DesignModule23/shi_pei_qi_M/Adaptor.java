package com.qing.springboot1.DesignModule23.shi_pei_qi_M;

//类适配器模式
public class Adaptor extends Adaptee implements Target {

    @Override
    public void method02() {
        System.out.println("method02...");
    }
}
