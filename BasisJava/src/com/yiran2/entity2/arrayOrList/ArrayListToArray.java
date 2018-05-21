package com.yiran2.entity2.arrayOrList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * ArrayList中的toArray()方法
 * */

public class ArrayListToArray {
    public static void main(String[] args){
        Collection<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 1, 2, 3, 4, 5);
        System.out.println("list："+list);

        // 调用toArray方法，将集合转为Object数组 ，该方法返回的就是Object类型的，
        // 所以不能直接写其他类型
        Object[] objArr = list.toArray();
        System.out.println("Array："+Arrays.toString(objArr));

        // 想使用Integer类型的特有方法，需要强转
        Integer i = (Integer) objArr[0];
        System.out.println("Integer："+i);
        // 将Integer元素转为Int 然后用字符串拼接，相当于将其转为字符串
        System.out.println("int："+i.intValue());

        // 调用方法，将集合转为带类型的数组
        /**
         *    如果参数数组足够放下集合中所有元素,就放入参数数组中,返回参数数组
         *
         *    如果参数数组无法放下集合中所有元素,则参数数组只起到确定类型作用,
         * 方法逻辑会自动创建新数组存储集合内容,并返回.
         * */
        Integer[] intArr = new Integer[3]; // 可以发现，并不像int[] 默认为0 而是默认为null
        Integer[] returnArr = list.toArray(intArr);
        System.out.println("查看intArr是否装载了："+Arrays.toString(intArr));
        System.out.println("查看returnArr是否装载了："+Arrays.toString(returnArr));

        // 测试一个可以装下的Integer数组,此时返回的就是参数数组，所以returnArr2与intArr2相同
        // 最后一个位置都空着在
        Integer[] intArr2 = new Integer[6];
        Integer[] returnArr2 = list.toArray(intArr2);
        System.out.println("查看intArr2是否装载了："+Arrays.toString(intArr2));
        System.out.println("查看returnArr2是否装载了："+Arrays.toString(returnArr2));

        // 使用这种泛型方法后，不需要强转，即可直接使用Integer的特有方法
        Integer i2 = returnArr[0];
        System.out.println("不需要强转，即可获得int："+i2.intValue());
    }
}
