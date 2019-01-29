package com.qing.springboot1.DesignModule23.zhuang_shi_qi_M;

public class DemoTest {

    public static void main(String[] args) {
        Qitiandasheng sunwukong = new Sunwukong();
        Fish fish = new Fish(sunwukong);
        fish.move();
        System.out.println("过了一会儿。。。");
        Eagle eagle  = new Eagle(sunwukong);
        eagle.move();
    }
}
