package com.yiran2.entity1.javaClass.inheritance.group;

/**
 * Pet宠物类
 *
 * 宠物姓名,宠物颜色,宠物种类三个成员变量
 * */

public class Pet {
    private String name;
    private String color;
    private String kind; // 种类

    public Pet(){}

    public Pet(String name, String color, String kind) {
        this.name = name;
        this.color = color;
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
