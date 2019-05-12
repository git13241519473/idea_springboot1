package com.qing.springboot1.baseNumType;

import io.swagger.models.auth.In;

import java.lang.reflect.Field;

public class ExchangeInteger {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer a = 1; //自动装箱操作
        Integer b = 2;
        System.out.println("before: a = "+a + " , b = "+b);
        swap(a, b);
        System.out.println("after : a = "+a + " , b = "+b);

       /* Long a = 128L;
        Long b = 128L;
        System.out.println(a == b); //false
        System.out.println(a.toString().equals(b.toString())); //true
        System.out.println(a.intValue() == b.intValue()); //true
        System.out.println(a.equals(b)); //true*/

    }

    private static void swap(Integer a, Integer b) throws NoSuchFieldException, IllegalAccessException {
        int temp = a;  // 所以最后修改为：统一使用 int 类型的值，做
        Field valueFiled = Integer.class.getDeclaredField("value");
        valueFiled.setAccessible(true);
        valueFiled.setInt(a, b);
        valueFiled.setInt(b, temp);
    }
}
