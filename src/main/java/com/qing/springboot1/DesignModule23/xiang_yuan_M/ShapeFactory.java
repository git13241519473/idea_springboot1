package com.qing.springboot1.DesignModule23.xiang_yuan_M;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {

    private static Map<String, Shape> shapes = new HashMap<String, Shape>();

    public int getNum(){
        return shapes.size();
    }

    public Shape getShape(String key){
        if(key == null || key.length() < 1){
            return null;
        }
        if(shapes.containsKey(key)){
            return shapes.get(key);
        }
        Circle circle = new Circle(key);
        shapes.put(key, circle);
        return circle;
    }

}
