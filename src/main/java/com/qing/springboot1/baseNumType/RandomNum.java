package com.qing.springboot1.baseNumType;

public class RandomNum {
    public static void main(String[] args) {
        for(int n = 0; n < 30; n++){
            System.out.print(randomNum(10, 50) + "\t");
        }
    }


    public static int randomNum(int min, int max){
        return (int)(min + Math.random() * (max - min + 1));
    }
}
