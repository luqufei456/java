package com.yiran2.entity1.javaClass.polymorphism.test1;

public class Dog extends Animal {
    @Override
    public void sleep() {
        System.out.println("在窝里睡觉，然后被猫挠了一爪子");
    }

    public void keepDoor(){
        System.out.println("在门口看门");
    }
}
