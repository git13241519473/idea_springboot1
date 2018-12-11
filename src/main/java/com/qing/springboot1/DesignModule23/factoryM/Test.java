package com.qing.springboot1.DesignModule23.factoryM;

public class Test {

    public static void main(String[] args) {
        Factory bean = FactoryBean.getBean("com.qing.springboot1.DesignModule23.factoryM.Apple");
        if(bean != null){
            bean.eat();
        }
    }

}
