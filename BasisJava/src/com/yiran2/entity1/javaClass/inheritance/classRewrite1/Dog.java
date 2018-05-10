package com.yiran2.entity1.javaClass.inheritance.classRewrite1;

/**
 * 子类狗类
 *
 *    子类狗类:
 *    	增强父类的吃饭方法,于是可以重写该方法
 *
 *    格式:
 *    	定义一个与父类方法声明完全相同的方法,方法体重写
 *
 *    Override注解解释:
 *      子类重写父类的方法时在方法上添加 @Override注解,表示该方法是子类重写父类中的方法
 *      .@Override用于限定该方法必须是重写父类的方法
 *
 *    静态方法覆盖:
 *      定义一个与父类方法名相同的静态方法即可，由于静态方法与类有关，所以并不是重写，而是将父类的静态方法隐藏了
 *      也称之为覆盖
 *
 *    成员变量覆盖：
 *      定义一个与父类声明完全相同的成员变量~
 * */

public class Dog extends Animal {
    String name = "君男";

    @Override
    public void eat(){
        System.out.println("我王境泽，就是饿死、死外面、从这掉下去，也不会吃你们一点东西！  真香~");
    }

    /*@Override
    public void eet(){
        System.out.println("@Override用于限定该方法必须是重写父类的方法");
    }*/

    public static void staticFunction(){
        System.out.println("不听不听，王八念经，我子类就要覆盖你");
    }
}
