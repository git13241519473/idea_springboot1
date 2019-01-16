package com.qing.springboot1.DesignModule23.qiao_jie_M;

public class DemoTest {
    public static void main(String[] args) {
        Shape shape = new Circular();
        Color coler = new Red();
        shape.setColor(coler);
        System.out.println(shape.draw());
    }
}
