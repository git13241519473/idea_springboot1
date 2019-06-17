package com.qing.springboot1.baseNumType;

public class StringAdd {
    public static void main(String[] args) {
        System.out.println("haha");
        System.out.println(f3());
        System.out.println("123");
    }

    public static String f3(){
        String str = "abc";
        try {
            return str;
        }finally {
            str = "123";
            return str;
        }

    }

    public void f1(){
        String result = "";
        for(int i = 0; i < 10; i++){
            result += "A";
        }
        System.out.println(result);
    }

    public void f2(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++){
            sb.append(sb);
        }
        System.out.println(sb.toString());
    }
}
