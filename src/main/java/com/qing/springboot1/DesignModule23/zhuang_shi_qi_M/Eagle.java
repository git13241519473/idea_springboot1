package com.qing.springboot1.DesignModule23.zhuang_shi_qi_M;

public class Eagle extends Change {
    public Eagle(Qitiandasheng qitiandasheng) {
        super(qitiandasheng);
    }

    public void move(){
        super.move();
        System.out.println("变成老鹰在天空飞");
    }
}
