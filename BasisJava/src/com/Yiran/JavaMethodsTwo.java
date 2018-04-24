package com.Yiran;
/**
 * 方法重载：在同一个类中，出现了方法名相同的方法，这就是方法重载。
 * 方法重载特点：
 * 		方法名相同，参数列表不同。与返回值无关。
 * 	    例如    public static int sum(int a, int b,int c)
 * 		参数列表不同：
 * 			参数的个数不同。 括号中的 (int a,int b,int c)
 * 			参数对应的类型不同。 int  float double 这种
 * 注意：
 * 		在调用方法的时候，java虚拟机会通过参数列表的不同来区分同名的方法。
 */

import java.util.Scanner;
import java.util.Arrays;

public class JavaMethodsTwo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入a的值：");
        int a = sc.nextInt();
        System.out.print("请输入b的值：");
        int b = sc.nextInt();
        System.out.print("请输入c的值：");
        int c = sc.nextInt();

        // 求 a b 和
        System.out.println("---------方法重载---------");
        System.out.println("求a+b的和");
        int result = sum(a,b);
        System.out.println("a+b="+result);

        // 求 a b c 和
        System.out.println("求a+b+c的和");
        result = sum(a,b,c);
        System.out.println("a+b+c="+result);

        // 比较是否相等
        // 此处调用了同一个类中的static方法  idea判断方法可以用private修饰
        System.out.println("比较是否相等");
        System.out.println(compare((byte) 10,(byte) 20));
        System.out.println(compare((short) 10,(short) 20));
        System.out.println(compare(10,20));
        System.out.println(compare(10L,20L));

        /* 方法中的参数传递
         * 方法的参数是基本类型的时候：形式参数的改变不影响实际参数。
         *     形式参数：用于接收实际数据的变量
         *     实际参数：实际参与运算的变量*/
        // 基本类型
        System.out.println("------方法中的传递参数------");
        System.out.println("基本类型");
        System.out.println("a:" + a + ",b:" + b);
        change(a, b);
        System.out.println("a:" + a + ",b:" + b); // 通过实验可以得出，方法内改变a b的值 不影响外部a b的值

        // 引用类型
        System.out.println("没有提供改变自身方法的引用类型");
        String text = "yiran~";
        System.out.println("text:"+text);
        strChange(text);
        System.out.println("text:"+text); // 可以发现，引用类型也不是一定会随着方法内的改变而改变

        System.out.println("提供了改变自身方法的引用类型");
        int[] arr = {1,2,3,4,5};
        System.out.println("arr:"+Arrays.toString(arr)); // 将数组输出
        arrayChange(arr);
        System.out.println("arr:"+Arrays.toString(arr)); // 可以发现 这时引用类型随 方法内 改变而改变

        System.out.println("提供了改变自身方法的引用类型,但是不使用，而是使用赋值运算符");
        int[] arr2 = {5,4,3,2,1};
        System.out.println("arr2:"+Arrays.toString(arr2)); // 将数组输出
        arrayChange2(arr2);
        System.out.println("arr2:"+Arrays.toString(arr2)); // 可以发现 并没有随方法改变
        /*
        * 总结：
        *       第三种情况，使用引用类型自身方法，改变的是该引用类型指向的变量本身
        *       第四种情况，相当于两个指向该引用类型的 都叫 arr2 然后方法内让方法里的 arr2
        *   指向了一个 新的内存空间 相当于 现在2个arr2指向的不是同一个引用类型
        * */

    }

    // 求和
    public static int sum(int a, int b){
        return a + b;
    }

    public static int sum(int a, int b,int c){
        return a + b + c;
    }

    // 比较两个数是否相等
    public static boolean compare(byte a,byte b){
        return a == b;
    }
    public static boolean compare(short a,short b){
        return a == b;
    }
    public static boolean compare(int a,int b){
        return a == b;
    }
    public static boolean compare(long a,long b){
        return a == b;
    }

    // 方法中的参数传递  基本类型时
    public static void change(int a,int b){
        System.out.println("a:" + a + ",b:" + b);
        a = b;
        b = a + b;
        System.out.println("a:" + a + ",b:" + b);
    }

    // 引用类型--没有提供改变自身方法的引用类型
    public static void strChange(String text){
        System.out.println("text:" + text);
        text = "baka!";
        System.out.println("text:" + text);
    }

    // 提供了改变自身方法的引用类型
    public static void arrayChange(int[] arr){
        for (int x = 0;x < arr.length;x++){
            if (arr[x] % 2 == 0){
                arr[x] = arr[x]*2;
            }
        }
        System.out.println("arr:"+Arrays.toString(arr));
    }

    // 提供了改变自身方法的引用类型，但是不使用，而是使用赋值运算符。
    public static void arrayChange2(int[] arr2){
        arr2 = new int[] {1,4,3,8,5};
        System.out.println("arr2:"+Arrays.toString(arr2));
    }

}
