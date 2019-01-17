package com.qing.springboot1.DesignModule23.jian_zao_zhe_M;

public class Test {
    public static void main(String[] args) {
        Director director = new Director();
        Student student = director.createStudent(new AstudentImpl());
        System.out.println(student);
    }
}
