package com.yiran2.entity1.javaClass.nestedClass.hiddenInner;

/**
 * 匿名内部类的测试类
 *
 *  匿名内部类
 *
 *  目的:创建某个类(接口)的子类对象
 *  		步骤1:定义带名字的子类
 *  		步骤2:创建对象
 *
 *  匿名内部类是创建某个类型子类对象的快捷方式
 *  我们为了临时定义一个类的子类，并创建这个子类的对象而使用匿名内部类。
 *
 *  将定义子类与创建子类对象两个步骤由一个格式一次完成
 *
 *  匿名内部类格式:
 *  (父类 or 子类) a = new (父类 or 子类) (){
 *  		//重写需要重写的方法
 *  	};
 * */

public class AnonymousInnerClass {
    public static void main(String[] args){
        // 使用有名字的子类(多态)
        InnerAnimal poi = new InnerDog();
        poi.eat();
        poi.sleep();

        // 使用匿名内部类
        InnerAnimal poi1 = new InnerDog(){
            @Override
            public void eat() {
                System.out.println("吃草");
            }


            @Override
            public void sleep() {
                System.out.println("仰着睡");
            }
        };

        poi1.eat();
        poi1.sleep();
    }
}
