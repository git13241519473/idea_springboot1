package com.qing.springboot1.proxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Meipo implements InvocationHandler {

    private Person person;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        System.out.println("来了一个媒婆，帮你找对象");
        System.out.println("看了你的条件要求是：");
        this.person.findLove();
        System.out.println("哈，帮你找到了，玩去吧");
        return null;
    }

    public Person getInstance(Person target) throws Exception {
        this.person = target;
        Class<? extends Person> targetClass = target.getClass();
        //生成代理对象
        Object instance = Proxy.newProxyInstance(targetClass.getClassLoader(), targetClass.getInterfaces(), this);
        return (Person) instance;
    }
}
