package com.qing.springboot1.DesignModule23.zhuang_shi_qi_M;

public abstract class Change implements Qitiandasheng {

    private Qitiandasheng qitiandasheng;

    public Change(Qitiandasheng qitiandasheng){
        this.qitiandasheng = qitiandasheng;
    }

    public void move(){
        qitiandasheng.move();
    }
}
