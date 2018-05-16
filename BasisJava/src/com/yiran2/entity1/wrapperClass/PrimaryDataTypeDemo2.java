package com.yiran2.entity1.wrapperClass;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 自动拆箱与装箱机制
 *
 *  自动拆箱:
 * 	当希望使用基本数据类型时,可以给于基本数据类型包装类的对象.此时会自动由引用类型"拆箱"成了基本类型,再使用
 * 	如:
 * 		运算符只能操作基本类型,但是给予两个Integer的对象,其自动拆箱后,进行了计算.
 *
 * 	自动装箱:
 * 		当希望使用基本数据类型包装类的对象时,可以给于基本数据类型的值.此时会自动由基本类型"装箱"成了引用类型的对象,再使用
 * 		如:
 * 			集合中只能存放引用数据类型,但是可以给于基本类型的值,其自动装箱成对象后,再操作
 * */

public class PrimaryDataTypeDemo2 {
    public static void main(String[] args){
        int i = 10;
        int i2 = 20;
        System.out.println(i+i2);

        // 自动拆箱
        // 运算符只能操作基本类型 所以不能操作引用类型Scanner
        // Scanner sc = new Scanner(System.in);
        // Scanner sc2 = new Scanner(System.in);
        // System.out.println(sc + sc2);

        Integer i3 = new Integer(100);
        Integer i4 = new Integer(200);

        System.out.println(i3+i4);

        // 自动装箱
        Integer i5 = 300;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(i5);
        list.add(10); // 这就是自动转成对象 存入list
        list.add(20);
    }
}
