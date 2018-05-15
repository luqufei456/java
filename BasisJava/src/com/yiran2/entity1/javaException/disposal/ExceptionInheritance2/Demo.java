package com.yiran2.entity1.javaException.disposal.ExceptionInheritance2;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * catch多个异常时的注意事项
 *
 *   	在捕获异常时,可以使用父类异常的引用指向子类异常的对象.是多态的应用.
 *  	当多异常处理时，捕获处理，前边的类不能是后边类的父类 这里的类指的是异常的类
 * */

public class Demo {
    public static void main(String[] args){
        // 一个try多个catch的方式
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查看的文件路径：");
        String path = sc.next();
        try {
            FileReader fr = new FileReader(path);
            System.out.println(10/0);
        } catch (IOException ie){  // Exception
            System.out.println("您访问的文件不存在");
        } catch (Exception e){  // IOException  这么写会报错 因为Exception是所有异常的父类
            System.out.println("反正你有地方错了");
        }

        // 一个try单个catch的方式,异常之间不能存在父子关系
        /*try {
            FileReader fr = new FileReader(path);
            System.out.println(10/0);
        } catch (IOException | Exception e){ // 这样存在父子关系，所以有问题
            System.out.println("报错咯");
        }*/

    }
}
