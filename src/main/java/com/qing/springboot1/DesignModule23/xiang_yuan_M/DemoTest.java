package com.qing.springboot1.DesignModule23.xiang_yuan_M;

public class DemoTest {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape("红色");
        shape.draw();

        Shape shape2 = shapeFactory.getShape("橙色");
        shape2.draw();

        Shape shape3 = shapeFactory.getShape("黄色");
        shape3.draw();

        Shape shape4 = shapeFactory.getShape("绿色");
        shape4.draw();

        Shape shape5 = shapeFactory.getShape("红色");
        shape5.draw();

        System.out.println("现在有"+ shapeFactory.getNum() +"个图片");

    }
    
}
