package com.qing.springboot1.DesignModule23.zhuang_shi_qi_M;

public class Fish extends Change {
    public Fish(Qitiandasheng qitiandasheng) {
        super(qitiandasheng);
    }

    public void move(){
        super.move();
        System.out.println("变成鱼儿在水里游哦。。。");
    }
}
