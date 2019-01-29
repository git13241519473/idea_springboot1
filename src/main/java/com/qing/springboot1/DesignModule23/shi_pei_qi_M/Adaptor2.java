package com.qing.springboot1.DesignModule23.shi_pei_qi_M;

//对象适配器模式
//这个包装类包装了一个Adaptee的实例，从而此包装类能够把Adaptee的API与Target类的API衔接起来。Adaptor2与Adaptee是委派关系
public class Adaptor2 implements Target {

    private Adaptee adaptee;

    public Adaptor2(Adaptee adaptee){
        this.adaptee = adaptee;
    }


    @Override
    public void method01() {
        adaptee.method01();
    }

    @Override
    public void method02() {
        //自己的实现
        System.out.println("method...02-----");
    }
}
