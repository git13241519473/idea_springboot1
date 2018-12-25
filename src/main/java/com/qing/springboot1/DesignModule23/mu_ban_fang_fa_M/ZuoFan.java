package com.qing.springboot1.DesignModule23.mu_ban_fang_fa_M;

public abstract class ZuoFan {

    //模板方法模式：就是定义一个模板结构，将具体内容延迟到子类去实现。
    public final void cookie(){
        //第一步：倒油
        this.pourOil();

        //第二步：热油
        this.HeatOil();

        //第三步：倒蔬菜
        this.pourVegetable();

        //第四步：倒调味料
        this.pourSauce();

        //第五步：翻炒
        this.fry();
    }

    protected void pourOil(){
        System.out.println("倒油");
    }

    protected void HeatOil(){
        System.out.println("热油");
    }

    protected abstract void pourVegetable();

    protected abstract void pourSauce();

    protected void fry(){
        System.out.println("翻炒");
    }

}

