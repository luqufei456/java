package com.yiran.entity.javaStatic;

/**
 * 静态方法：
 *      同静态变量一样，所有实例都可以访问到的方法叫静态方法，
 * 如何定义一个静态方法：
 *      访问修饰符  static  返回类型  方法名（）{ 方法体 }
 *      静态方法在访问本类的成员时，只允许访问静态成员（即静态成员变量和静态方法），
 *      而不允许访问实例成员变量和实例方法；实例方法则无此限制。
 * 如何访问静态方法
 *      类名.静态方法名(有权限限制)    或者    对象名.静态方法名
 *
 * 静态方法和属性和成员方法和属性对比总结：
 *      1、最大的区别在于内存。静态方法在程序开始时生成内存,实例方法在程序运行中生成内存，
 * 所以静态方法可以直接调用,实例方法要先成生实例,通过实例调用方法，静态速度很快，但是多了会占内存。
 *      2、静态成员属于类所有，非静态成员属于类的实例/对象所有。
 *      3、每创建一个类的实例，都会在内存中为非静态成员新分配一块存储；
 *      4、静态成员属于类所有，为各个类的实例所公用，无论类创建了多少实例，类的静态成员在内存中只占同一块区域
 * */

public class StaticMethods {
    String name;
    int age;
    static int stuCount;

    public StaticMethods(String name, int age){
        this.name = name;
        this.age = age;
        stuCount++;
    }

    public static void setStuCount(int stuCount){
        // setStu("xx",21);
        // name = "xxx";
        // 可以看到 静态方法无法访问非静态成员
        StaticMethods.stuCount = stuCount;
    }

    public void setStu(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void show(){
        System.out.println(name+"今年"+age+"岁");
    }

}

class Methods{
    public static void main(String[] args){
        StaticMethods stu = new StaticMethods("yiran",21);
        // 自己定义了构造方法之后，就不会默认设置无参构造方法了
        stu.setStuCount(5); // 使用对象访问静态方法 不建议
        StaticMethods.setStuCount(4); // 使用类访问静态方法

        // StaticMethods.setStu("yiran",21);
        // 需要实例化才能使用对象调用 静态是调用时就加载进内存了 非静态要new 一个对象才会加载进内存
        stu.setStu("chunjue",25);
        stu.show();
    }
}