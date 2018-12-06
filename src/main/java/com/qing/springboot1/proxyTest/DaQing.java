package com.qing.springboot1.proxyTest;

public class DaQing implements Person {

    private String name;
    private String sex;
    private int age;

    public DaQing() {   //无参构造器
    }

    public DaQing(String name, String sex, int age) {   //有参构造器
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    // 生成 getter、setter 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "DaQing{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void findLove() {
        System.out.println("喜欢类型：肤白貌美大长腿");
        System.out.println("做梦都会笑死啦，哈哈哈");
    }
}
