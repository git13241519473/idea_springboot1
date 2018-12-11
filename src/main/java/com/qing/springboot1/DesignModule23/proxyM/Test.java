package com.qing.springboot1.DesignModule23.proxyM;

public class Test {

    public static void main(String[] args) {
        //没有代理时，我是自己去找对象
        DaQing daQing = new DaQing("大庆", "男", 25);
        //System.out.println(daQing);
        //daQing.findLove();
        
        //有代理时，
        //jdk 代理
        /*Meipo meipo = new Meipo();
        try {
            Person instance = meipo.getInstance(daQing);
            instance.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        //cglib 代理
        Meipo2 meipo2 = new Meipo2();
        try {
            Person instance2 = meipo2.getInstance(daQing);
            instance2.findLove();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
