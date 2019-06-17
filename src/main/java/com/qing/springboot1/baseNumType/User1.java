package com.qing.springboot1.baseNumType;

import com.sun.xml.internal.bind.v2.util.ByteArrayOutputStreamEx;

import java.io.*;

public class User1 implements Serializable {
    private static final long serialVersionUID = -3783687202158360151L;
    private String name;
    private transient Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //深克隆
    public User1 deepClone() throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStreamEx();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (User1)ois.readObject();
    }
}
