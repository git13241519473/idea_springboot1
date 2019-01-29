package com.qing.springboot1.DesignModule23.zu_he_M;

public class ImageFile extends AbstractFile {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sayName() {
        System.out.println(getName());
    }
}
