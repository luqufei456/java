package com.yiran2.entity1.javaClass.nestedClass.hiddenInner;

/**
 * 子类Dog类
 * 定义子类，重写父类方法
 * */

public class InnerDog extends InnerAnimal {
    // 重写方法
    @Override
    public void eat(){
        System.out.println("小狗吃骨头");
    }

    @Override
    public void sleep(){
        System.out.println("小狗趴窝睡");
    }
}
