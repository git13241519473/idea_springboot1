package com.qing.springboot1.proxyTest;

public class Test {

    public static void main(String[] args) {
        //没有代理时，我是自己去找对象
        DaQing daQing = new DaQing("大庆", "男", 25);
        System.out.println(daQing);
        //daQing.findLove();
        
        //有代理时，
        Meipo meipo = new Meipo();
        try {
            Person instance = meipo.getInstance(daQing);
            instance.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
