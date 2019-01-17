package com.qing.springboot1.DesignModule23.wai_guan_M;

public class DemoTest {
    /*
    外观模式：外观模式定义了一个高层的功能，为子系统中的多个模块协同的完成某种功能需求提供简单的对外功能调用方式，
    使得这一子系统更加容易被外部使用。
    目的：让外部减少与子系统内多个模块的交互，松散耦合，从而让外部能够更简单地使用子系统。
     */
    //其实本包中的一个 模板方法模式，也能体现出 外观模式， 不就是说：以前由客户端写的代码，现在我们用一个过滤层代替了，
    //让客户端调用更简单而已。

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.doit();
    }
}
