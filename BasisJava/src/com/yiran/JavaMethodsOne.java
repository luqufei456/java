package com.yiran;

import java.util.Scanner;

public class JavaMethodsOne {
    /**
     * 修饰符：目前记住 public static(静态方法)
     在类中使用static修饰的静态方法会随着类的定义而被分配和装载入内存中
     * 返回值类型：用于限定返回值的数据类型
     * 方法名：一个名字，为了方便我们调用方法
     * 参数类型：用于接收调用方法时传入的数据的类型
     * 参数名：用于接收调用方法时传入的数据的变量
     * 方法体：完成功能的代码
     * return：结束方法，把返回值带给调用者
     * java用三个关键字在类的内部设定边界：public、private、protected。
     这些“访问指定词“（access specifier）决定了紧跟其后被定义的东西可以被谁使用。
     public表示紧随其后的元素对任何人都是可用的（相当于全局变量，但是其他包也能用），
     而private这个关键字表示除类型创建者和类型的内部方法之外任何人都不能访问的元素（相当于私有属性）。
     如果尝试访问private成员，就会在编译时得到错误信息。protected关键字与private作用相当于，
     差别仅在于继承的类可以访问protected成员（相当于局部变量），但是不能访问private成员。
     */

    public static void main(String[] args){
        // 求和
        // 单独调用
        // sum(10,20);

        // 输出调用
        // System.out.println(sum(10,20));

        // 赋值调用
        int s = sum(10,20);
        // s+=100
        System.out.println("s="+s);

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入a：");
        int x = sc.nextInt();
        System.out.print("请输入b：");
        int y = sc.nextInt();
        System.out.print("请输入c：");
        int z = sc.nextInt();

        // 求最大值1
        int max1 = getMax1(x,y);
        System.out.println("两值的最大值为：" + max1);

        // 求是否相等
        boolean flag = compare(x,y);

        // 求最大值2
        int max2 = getMax2(x,y,z);
        System.out.println("三者的最大值为：" + max2);

        // void修饰方法的调用：只可以单独调用 不可以 输出调用 或 赋值调用
        printHelloWorld();
        // System.out.println(printHelloWorld();); // 报错
        // String str = printHelloWorld(); // 报错

        // 输出1-n的值
        printNumber(5);

        // 输出100-1000水仙花值
        printFlower();
    }

    public static int sum(int a,int b){ // 这里 static 表示不需要实例对象就可以直接调用
        // int c = a + b;
        // return c
        return a + b;
    }

    public static int getMax1(int a, int b){
        return a>b?a:b; // a > b 返回a 否则返回 b
    }

    public static boolean compare(int a,int b){
        return a == b; // 这里 如果成立自然返回 true 不成立自然返回 false
    }

    public static int getMax2(int a,int b,int c){
        int abMax = a>b?a:b;
        return abMax>c?abMax:c;
    }

    public static void printHelloWorld(){
        for (int x = 0;x < 10;x++){
            System.out.println("Hello World");
        }
    }

    public static void printNumber(int n){
        for (int x = 1;x <= n;x++){
            System.out.println(x);
        }
    }

    public static void printFlower(){
        for (int x = 100;x < 1000;x++){
            int single = x%10; // 各位 除以10取余数
            int ten = (x%100)/10; // 各位 除100取余 得到十位数 除以10得到十位值
            int hundreds = x/100; // 百位
            if ((single*single*single + ten*ten*ten + hundreds*hundreds*hundreds) == x){
                System.out.println(x);
            }
        }
    }

}
