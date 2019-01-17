package com.qing.springboot1.DesignModule23.jian_zao_zhe_M;

public class AstudentImpl implements IStudent {
    Student student = new Student();

    @Override
    public void showXingGe() {
        student.setXingGe("开朗");
    }

    @Override
    public void showSex() {
        student.setSex("男");
    }

    @Override
    public Student getStudent(){
        return student;
    }
}
