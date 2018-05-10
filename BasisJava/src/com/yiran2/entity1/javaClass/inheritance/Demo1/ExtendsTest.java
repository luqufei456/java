package com.yiran2.entity1.javaClass.inheritance.Demo1;

/**
 * 继承关系的测试类
 *
 *  当有了子父类关系后,子类拥有了父类的成员,可以直接访问父类的非私有成员
 * 可以通过父类的成员方法访问父类的私有属性，但是父类的私有方法无法访问
 *
 *  继承通过这样的方式,提高了代码的复用性,让类与类之间产生了关系
 *  有些人认为：继承关系必须符合is a的关系,即我是你的一种，但是通常会遇到很多情况需要在子类中扩展属性与方法，
 * 这就是 is like a 关系，即像是一种
 *
 * 继承的格式:
 * 		public class 子类   extends  父类 {
 *
 * 		}
 *
 * 注意:
 * 		所有的类(除Object类)都有父类,所有的类都直接或间接是Object的子类
 * */

public class ExtendsTest {
    public static void main(String[] args){
        // 创建子类对象
        Coder yiran = new Coder();
        // 使用子类可以直接访问父类的非私有成员变量
        yiran.name = "依然";
        yiran.age = 21;
        System.out.println(yiran.name+"的年龄为"+yiran.age);
        // 使用子类可以访问父类的非私有方法
        yiran.eat();
        yiran.sleep();
        yiran.touch();
        // 使用子类可以访问子类自身的成员方法
        yiran.code();
    }
}
