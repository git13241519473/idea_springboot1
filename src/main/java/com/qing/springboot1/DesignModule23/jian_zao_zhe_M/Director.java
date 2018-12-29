package com.qing.springboot1.DesignModule23.jian_zao_zhe_M;

public class Director {

    public Student createStudent(IStudent student){
        student.showXingGe();
        student.showSex();
        return student.getStudent();
    }

}
