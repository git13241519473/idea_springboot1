package com.qing.springboot1.DesignModule23.qiao_jie_M;

public class Square extends Shape {
    @Override
    public String draw() {
        return getColor().bePained("正方形");
    }
}
