package com.qing.springboot1.DesignModule23.xiang_yuan_M;

public class Circle implements Shape {

    private String color;

    public Circle(String color){
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("画了一个"+ getColor() +"的圆形。");
    }
}
