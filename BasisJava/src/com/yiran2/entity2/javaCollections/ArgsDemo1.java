package com.yiran2.entity2.javaCollections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * 方法的可变参数
 *
 *   可变参数:
 *  	参数数量可变
 *
 *  Collections:
 *  	public static <T>boolean addAll(Collection c<? super T>, T... elements) 将指定的元素添加到集合
 *
 *  数据类型...代表可变参数.即可以传入任何多个该类型的数据
 *  可变参数不能放在前边,只能放在最后
 *  可变参数的方法与数组的方法不能重载,因为可变参数实质上就是数组
 * */

public class ArgsDemo1 {
    public static void main(String[] args){
        // 使用Collections方法时，一般使用多态，用父类指向子类的对象。
        Collection<String> cList = new ArrayList<String>();

        // 像cList集合中添加不定属性的元素
        Collections.addAll(cList, "依然", "诚哥", "太太");

        // 输出集合
        System.out.println(cList);

        // 可变参数，本质上就是数组
        System.out.println();
        int sum  = add(10,20,30);
        System.out.println("使用可变参数的sum："+sum);

        int[] intArr = {1,2,3,4,5};

        // 也可以使用该方法
        System.out.println();
        sum = add(intArr);
        System.out.println("使用数组的sum："+sum);
    }

    // 看看 int... ints     和 int[] intArr 这两种参数是否能构成重载
    // 结论是不能，这两种参数类型实质上是相同的
    public static int add(int... ints){
        // 用来记录所有数的和
        int sum = 0;
        // 遍历参数a代表的数组
        for (int thisInt : ints){
            // 依次将遍历出的元素加给sum
            sum += thisInt;
        }
        return sum;
    }

    /*public static int add(int[] intArr){

    }*/
}
