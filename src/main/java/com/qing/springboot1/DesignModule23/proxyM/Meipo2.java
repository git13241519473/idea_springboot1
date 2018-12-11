package com.qing.springboot1.DesignModule23.proxyM;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib 动态代理模式
 */
public class Meipo2 implements MethodInterceptor {

    private Person person;

    //得到实际对象的代理对象
    public Person getInstance(Person target) throws Exception{
        this.person = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.person.getClass());
        enhancer.setCallback(this);
        return (Person)enhancer.create();
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("来了一个媒婆，帮你找对象");
        System.out.println("看了你的条件要求是：");
        methodProxy.invokeSuper(object, args);
        System.out.println("哈，帮你找到了，玩去吧");
        return null;
    }
}
