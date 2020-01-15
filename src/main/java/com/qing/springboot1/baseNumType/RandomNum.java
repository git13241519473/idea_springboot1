package com.qing.springboot1.baseNumType;

public class RandomNum {
    public static void main(String[] args) {
        for(int n = 0; n < 100; n++){
            System.out.print(randomNum(10, 50) + "\t");
        }
    }

    //取值范围：[min, max]
    public static int randomNum(int min, int max){
        return (int)(min + Math.random() * (max - min + 1));
    }
}
