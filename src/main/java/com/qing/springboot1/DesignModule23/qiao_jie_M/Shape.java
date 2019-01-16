package com.qing.springboot1.DesignModule23.qiao_jie_M;

public abstract class Shape {

    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract String draw();
}
