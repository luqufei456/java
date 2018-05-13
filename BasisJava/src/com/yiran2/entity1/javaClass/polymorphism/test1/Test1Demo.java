package com.yiran2.entity1.javaClass.polymorphism.test1;

/**
 * 子类多态的测试类
 *
 * 多态的前提必须有子父类关系,或者实现接口关系
 *
 * 举例:
 * 	父类:动物类
 * 		共性的吃饭,睡觉方法
 *  子类:
 *  	猪类:共性功能
 *  		拱地功能
 *  	狗类:共性功能
 *  		看门功能
 *  	人类:共性功能
 *  		学习,工作...功能
 *
 *  多态:
 *  	父类(接口)引用变量可以指向子类对象,展现出父类(接口)的功能
 *  	子类引用变量可以指向子类对象,展现出子类的功能
 *  	子类对象可以表现出多种形态,这多种形态叫做多态
 *
 *  多态代码格式:
 *  父类类型变量名 = new 子类类型();
 *  变量名.方法名();
 *
 *  当出现多态后,其调用的方法是类重写后的方法
 *
 *
 * *  多态的使用场景:
 *  	为变量赋值时使用多态,达到父类应用指向子类对象的赋值
 *  	直接为变量赋值
 *  	调用方法时,为方法参数赋值
 *  	方法返回值,可以定义父类类型,但是返回子类对象.当该方法被调用时,用父类类型接收.
 *
 *  多态的好处:
 *  	大大提高了程序的扩展性
 *  	提高了程序的复用性
 *
 *
 *  多态后的类型转换问题:
 * 		向上转型:多态本身是子类类型向父类类型向上转型
 * 		向下转型(使用强制类型转换):
 * 			父类类型  f = new 子类类型();
 * 			子类类型   z = (子类类型)f;
 *
 *
 * 	instanceof关键字:用来判断对象是否属于某种数据类型
 *
 * 某个对象instanceof某个数据类型
 * (note:对象与类型必须拥有子父类关系才可以判断,无关系的两个类型不能判断!)
 * */

public class Test1Demo {
    public static void main(String[] args){
        // 创建子类对象，让其展现出不同的状态

        // 不产生多态
        Person junnan = new Person();
        junnan.eat();
        junnan.sleep();
        junnan.study();
        junnan.work();
        System.out.println();

        // 使用多态中的向上转型 只表现出父类(等号左边的数据类型)的功能
        Animal junnan1 = new Person();
        junnan1.eat();
        junnan1.sleep();
        // 使用向上转型之后无法使用子类特有方法
        // junnan1.work();
        System.out.println();


        //调用feed方法  方法传参使用多态形式
        //使用多态的形式,创建子类对象,赋值给父类引用
        //Animal a2=new Person();
        //feed(a2);

        //Person p2=new Person();
        //feed(p2)

        feed(new Person());
        System.out.println();


        //多态的类型转换
        // 使用强制转换，将父类类型转为子类类型
        Person junnan2 = (Person) junnan1;
        junnan2.eat();
        junnan2.sleep();
        junnan2.study();
        junnan2.work();
        System.out.println();

        /*// 在强制类型转换时,必须是什么对象,转为什么类型.
        // 如果使用错,使用了其他类型,则编译时不报错,运行时会报错,
        // 显示类型转换异常:java.lang.ClassCastException
        Animal dog = new Dog();
        // 然而可以看到，编译器还是给了提示的
        Person dog1 = (Person) dog;
        dog1.eat();
        dog1.sleep();
        dog1.study();
        dog1.work();*/
    }

    // animal可以接收Animal的任意子类对象
    public static void feed(Animal animal){
        // 调用该动物的吃饭方法
        System.out.println("feed方法内的动物吃饭的方法被调用");
        animal.eat();
    }

    public static void method(Animal animal){
        // 先吃饭
        animal.eat();
        // 如果是狗，就看门，如果是人，就工作
        if (animal instanceof Dog){
            // 强转为狗，然后调用狗的方法
            ((Dog) animal).keepDoor();
        }
        else if (animal instanceof Person){
            // 强转为人，然后学习工作
            ((Person) animal).study();
            ((Person) animal).work();
        }
    }
}
