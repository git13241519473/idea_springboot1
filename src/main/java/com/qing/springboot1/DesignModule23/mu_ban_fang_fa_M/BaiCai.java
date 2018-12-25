package com.qing.springboot1.DesignModule23.mu_ban_fang_fa_M;

public class BaiCai extends ZuoFan {
    @Override
    protected void pourVegetable() {
        System.out.println("把白菜倒入锅里");
    }

    @Override
    protected void pourSauce() {
        System.out.println("加盐");
    }
}
