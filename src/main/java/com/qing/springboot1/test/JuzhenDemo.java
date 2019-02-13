package com.qing.springboot1.test;

public class JuzhenDemo {
    public static void main(String[] args) {
        //进行矩阵的运算，就是想象成二位数组进行运算
        int[][] aArray = new int[][]{{1, 0, 3, -1}, {2, 1, 0, 2}};
        int[][] bArray = new int[][]{{4, 1, 0}, {-1, 1, 3}, {2, 0, 1}, {1, 3, 4}};
        int[][] cArray = new int[][]{{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        int[][] result = abArrayCheng(aArray, cArray);
        if(result != null){
            for(int i = 0; i < result.length; i++){
                for(int j = 0; j < result[0].length; j++){
                    System.out.print("\t"+result[i][j]);
                }
                System.out.println();
            }
        }else{
            System.out.println("无法进行矩阵乘法运算");
        }
    }


    public static int[][] abArrayCheng(int[][] aArray, int[][] bArray){
        //判断是否可以进行乘法运算
        if(aArray != null && bArray != null){
            int an = aArray.length, am = aArray[0].length;
            int bn = bArray.length, bm = bArray[0].length;
            if(am == bn){
                int[][] cArray = new int[an][bm];
                for(int i = 0; i < an; i++){
                    for(int j = 0; j < bm; j++){
                        cArray[i][j] = 0;
                        for(int k = 0; k < am; k++){
                            cArray[i][j] += aArray[i][k] * bArray[k][j];
                        }
                    }
                }
                return cArray;
            }
        }
        return null;
    }

}
