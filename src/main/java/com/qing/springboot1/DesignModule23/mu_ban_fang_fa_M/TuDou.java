package com.qing.springboot1.DesignModule23.mu_ban_fang_fa_M;

public class TuDou extends ZuoFan {
    @Override
    protected void pourVegetable() {
        System.out.println("放入土豆");
    }

    @Override
    protected void pourSauce() {
        System.out.println("加鸡精");
    }
}
