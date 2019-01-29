package com.qing.springboot1.DesignModule23.shi_pei_qi_M;

public class DemoTest {

    public static void main(String[] args) {
        Adaptor adaptor = new Adaptor();
        test01(adaptor);

        Adaptor2 adaptor2 = new Adaptor2(new Adaptee());
        test01(adaptor2);
    }


    /*
    适配器模式把一个类的接口变换成客户端所期待的另一种接口，从而使原本因接口不匹配而无法在一起工作的两个类能够在一起工作。

    适配器模式的用途:
　　    用电器做例子，笔记本电脑的插头一般都是三相的，即除了阳极、阴极外，还有一个地极。而有些地方的电源插座却只有两极，没有地极。
       电源插座与笔记本电脑的电源插头不匹配使得笔记本电脑无法使用。这时候一个三相到两相的转换器（适配器）就能解决此问题，而这正像是本模式所做的事情。

     */

    public static void test01(Target target){
        target.method01();
        target.method02();
    }

}
