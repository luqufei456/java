package com.Yiran;

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

}
