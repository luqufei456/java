package com.yiran;

public class JavaSeExam {
    public static void main(String[] args){
        JavaSeExam test = new JavaSeExam();
        test.test1();
        test.test2();
        test.test3();
        //test.test4();
        //test.test5();
        test.test6();
        Test10 direction = Test10.EAST; // 枚举法的正确用法
    }

    public void test1(){
        System.out.println(1- 2/5+2*5); // 2/5 = 0
    }

    public void test2(){
        boolean x = true;
        boolean y = false;
        short z = 42;
        if ((z++ == 42) && (y = true)){ // 这里的 y = true只是赋值 结果总是true
            z++;
        }
        if ((x = false) || (++z == 45)){ // 同理， x = false 的结果总是false
            z++;
        }
        System.out.println(z); // z++ 先运算 再+1  ++z 先+1 再运算 搞清楚先后顺序
    }

    public void test3(){
        int x = 500;
        Integer x1 = x;
        Integer x2 = x;
        int x3 = new Integer(500); // 如果是 Integer x3 那么 x2 == x3 为false
        // 这里要搞清楚 在 -128~127之间时，Integer不会new新的对象，直接拿缓存区中的使用
        // 就像String字符串常量池，如果赋值超过这个区域，就不等于了，是2个不同的对象
        // 在该区域中时，都是一个对象
        System.out.print(x1.equals(x)); // 值相同，所以为true
        System.out.print(x1 == x); // 指向同一个内存空间，所以为true
        System.out.print(x2.equals(x1)); // 值相同， true
        System.out.print(x2 == x1); // 虽然指向同一个内存空间，但其为2个对象，所以不全等 false
        System.out.print(x2 == x3); // int x3 是一个值 不是一个对象，值和x2相等 所以为 true
        System.out.print(x2.equals(x3));
    }

    public void test4(){
        int x = 3;
        while (x++ < 4){ //  x先与4比较 再+1 进入循环 -1 再进去 死循环
            --x; // 这里x-- 还是 --x 都一样 因为没有别的运算
        }
        System.out.println("x=" + x);
    }

    public void test5(){
        try {
            //fun(); //fun（）方法当出现数组下标超过界限时，会报什么错
            System.out.print("情况1");
        }
        // 非法索引访问数组时抛出的异常。如果索引为负或大于等于数组大小，则该索引为非法索引。
        catch (ArrayIndexOutOfBoundsException e){
            System.out.print("情况2");
        }
        // 若不是上面的情况2报错 则会报错 Exception 所有异常都能引发该异常。即Exception类是所有异常的根类
        catch (Exception e){
            System.out.print("情况3");
        }
        // finally 语句块内的语句，无论在什么时候，什么情况下都会执行，一般用于写释放资源的语句
        finally {
            System.out.print("finally");
        }
    }

    public void test6(){
        int x = 0;
        int y = 4;
        for (int z = 0;z < 5; z++,x++){
            if (x > 1 & ++y < 10){ // 这里不能用阻断符 不然第一次 y不会+1
                // 这里 判断中 最后一次进入 y++前 y+1 >=10
                // 第一次循环完 y=5 第二次7 第三次9 第四次=10时进不去 第五次11
                y++;
            }
            System.out.println(y);
        }
    }

    public void test7(){
        /*
        下列有关类声明的代码片段，哪一项是正确的？ A
    A.
        package school;
        import  java. sql.*；
        class Student {
        }
    B．
        import java．sql.*；
        package school;
        class  Student {
        }
    C． 
        package school;
        class Student{
        }
        import  java. sql.*;
    D.
        package school;
        import java. sql.*；
        private String name;
        class Student {
        }
            */
    }

    public void test8(){
        /*
        有关new关键字的描述正确的是哪项？ A C
        A.创建对象实例的时候可以不使用new关键字//java反射可以不用new得到类的实例
        B．new所创建的对象不占用内存空间
        C．new会调用类的构造器来创建对象
        D．new所创建的对象一定存在引用变量//匿名对象
        */
    }

    public void test9(){
        /*
        class A{
            private int getNumber(int a){ // 私有的 无法被其他类访问
                return a+1;
            }
        }

        class B extends A{ // B继承A
            public int getNumber(int a,char c){
                return a+2;
            }

            public static void main(String[] args){
                B b = new B();
                System.out.println(b.getNumber(0)); // 报错
            }
        }
        */
    }

    public enum Test10{
        EAST,SOUTH,WEST,NORTH
        /*下列正确使用该枚举类型的语句是哪项？ B
        A. Direction Direction=EAST;
        B. Direction direction=Direction.WEST;
        C. int a=Direction.NORTH;
        D．Direction direction=2；*/
    }

    public void Test11(){
        /*
        如果想要一个类不能被任何类继承的话，需要使用哪个关键字来修饰该类？ D
        A.  abstract
            Abstract class指的是用关键字abstract修饰的类，叫做抽象类，是不允许实例化的类，
            不能直接创建对象，必须要通过子类创建才能使用abstract类的方法。
        B.  new    new一般用于创建实例对象
        C.  static
            如果一个类要被声明为static的，只有一种情况，就是静态内部类。
            如果在外部类声明为static，程序会编译都不会过。
            1.静态内部类跟静态方法一样，只能访问静态的成员变量和方法，不能访问非静态的方法和属性，
            但是普通内部类可以访问任意外部类的成员变量和方法
            2.静态内部类可以声明普通成员变量和方法，而普通内部类不能声明static成员变量和方法。
            3.静态内部类可以单独初始化:
                Inner i = new Outer.Inner();
            普通内部类初始化：
                Outer o = new Outer();
                Inner i = o.new Inner();
        D.  final
            当一个类不可能有子类时可用修饰符 final 把它说明为最终类。
            被定义为 final 的类通常是一些有固定作用、用来完成某种标准功能的类。
    */
    }

    public void Test12(){
        /*
        为了使得System.out.println()输出对象引用的时候得到有意义的信息
        我们应该覆盖Object的哪个方法？  B
        A．equals    用来判断两个对象是否相等
        B．toString    将对象转成字符串
        C．hashCode    获得对象的哈希值,可以用来唯一标识对象
        D．notify    唤醒一个正在等待的线程
    */
    }

    public void Test13(){ // 待补充
        /*
        现有：
        public class Pet{}
        public class Cat extends Pet{}
        执行代码
        Cat c=new Cat()；
        Pet p= (Pet)c；
        下列哪项是正确的？  C
        A. Pet p=(Pet)c运行错误
        B. Pet p=(Pet)c编译错误
        C. Pet p= (Pet)c正常执行
        D．以上都不对
        */
    }

    public void Test14(){
        /*
        下列有关接口的叙述错误的是哪项？
        A.接口中只能包含抽象方法和常量//默认都是public跟abstract修饰
            抽象类由abstract关键字来修饰，接口由interface关键字来修饰。抽象类中除了有抽象方法外，
            也可以有数据成员和非抽象方法；而接口中所有的方法必须都是抽象的，
            接口中也可以定义数据成员，但必须是常量。
        B．一个类可以实现多个接口
            java中 支持多实现 但是不支持多继承
        C．（非抽象）类实现接口时必须实现其中的方法
            一个非接口的类实现另一个类 必须实现其所有方法。
        D．接口不能被继承//可以有子接口
            一个接口可以继承多个接口
            interface C extends A, B {}是可以的.
            一个类可以实现多个接口:
            class D implements A,B,C{}
            但是一个类只能继承一个类,不能继承多个类
            class B extends A{}
            在继承类的同时,也可以继承接口:
            class E extends D implements A,B,C{}
            这也正是选择用接口而不是抽象类的原因
        */
    }

    public void Test15(){ // 后面都是类 接口等的问题，待补充

    }

}
