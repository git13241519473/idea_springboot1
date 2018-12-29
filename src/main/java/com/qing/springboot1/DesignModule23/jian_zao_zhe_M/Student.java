package com.qing.springboot1.DesignModule23.jian_zao_zhe_M;

public class Student {

    private String xingGe;
    private String sex;

    public Student() {
    }

    public Student(String xingGe, String sex) {
        this.xingGe = xingGe;
        this.sex = sex;
    }

    public String getXingGe() {
        return xingGe;
    }

    public void setXingGe(String xingGe) {
        this.xingGe = xingGe;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "xingGe='" + xingGe + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
