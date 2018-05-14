package com.yiran2.entity1.javaClass.polymorphism.test2;

/**
 * 多态中的属性
 *
 *  子类中重写了属性的获取方法后，使用的为子类的属性
 *  直接使用 Good.name 使用的为父类的属性
 *  因为左边的为 Good g  是一个父类的类型，而不是子类的类型
 *  而方法是因为被重写了，所以会调用子类的，属性则没有重写覆盖的说法
 *
 *  当Good g = new Better(); 时 会调用子类和父类的构造方法，然后父类的构造方法在对象内存中修饰出一块
 *  叫super的内存存放父类方法和属性，另一块子类的构造方法修饰出子类自己的方法和属性
 *
 *  因为g的类型为Good，所以使用属性时会调用super中的属性，为什么会使用子类的同名方法呢？因为父类的方法被
 *  重写，覆盖了，这也是为什么调用父类中不存在的方法时会报错的原因，因为super中并没有该方法。
 *
 *  方法被重写后，在方法中返回属性，访问的则是子类的属性，相当于调用子类的方法，子类的方法自然访问子类属性
 *
 *  子类中拥有2个name属性，
 * */

public class Good {
    String name = "good";

    public String getName() {
        System.out.println("Good.getName");
        return name;
    }

}

class Better extends Good {
    String name= "better";

    public static void main(String[] args) {
        Good g =new Better();
        System.out.println(g.getName());
        // 直接输出属性name
        System.out.println("Good.name");
        System.out.println(g.name);
    }

    public String getName() {
        System.out.println("Better.getName");
        return name;
    }
}