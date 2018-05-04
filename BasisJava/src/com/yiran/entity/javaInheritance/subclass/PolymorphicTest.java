package com.yiran.entity.javaInheritance.subclass;

/**
 * 多态成员访问的特点：
 *
 *  成员变量
 *      编译看左边(父类),运行看左边(父类)
 *    但是子类使用父类构造方法以后，值都是一样的，所以自己定义不在构造方法中的变量 更容易理解
 *  成员方法
 *      编译看左边(父类)，运行看右边(子类)。动态绑定
 *    编译看左边意思就是，父类没有该名字的方法 就无法编译 报错 但是运行是运行的子类的同名方法
 *  静态方法
 *      编译看左边(父类)，运行看左边(父类)。
 *      (静态和类相关，算不上重写，只能算覆盖。所以，访问还是左边的)
 *
 *  只有非静态的成员方法,编译看左边,运行看右边
 * */

import com.yiran.entity.javaInheritance.superclass.PersonClass;
import com.yiran.entity.javaInheritance.superclass.Student;

public class PolymorphicTest {
    public static void main(String[] args){
        /*testShow(new Student()); // 以Student对象调用testShow方法
        testShow(new Employee()); // 以Employee对象调用testShow方法*/

        PersonClass per = new Student("yiran",true,21,0.5); // 向上转型

        System.out.println("per 调用 show showtime ena 其中ena为静态方法 输出成员变量like");
        per.showtime(); // 调用的是Student的showtime()
        per.show();
        per.ena();
        System.out.println(per.like);
        // name gender age salary都用的是父类的有参构造方法，所以这里per.name 等和 yiran.name等一样
        // 所以这里使用没有在构造方法中的like来比较 父类和子类都分别定义了不同的like

        // System.out.println(per.play); 无法访问子类特有的成员变量与成员方法
        // per.playgame("DNF");
        System.out.println();

        System.out.println("yiran 调用 show showtime ena 其中ena为静态方法 输出成员变量like");
        Student yiran = (Student)per; // 向下转型
        yiran.showtime();
        yiran.show();
        yiran.ena();
        System.out.println(yiran.play);
        yiran.playgame("DNF");
        System.out.println(yiran.like);

    }

    /*public static void testShow(PersonClass person){ // 这里使用父类的对象 所以2个子类都能当参数传递
        // person.showtime();

        // 类型判断
        if (person instanceof Student){
            Student yiran = (Student)person;
            yiran.showtime();
        }
        else if (person instanceof Employee){
            Employee chunjue = (Employee)person;
            chunjue.showtime();
        }

    }*/

}
