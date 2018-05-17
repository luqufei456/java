package com.yiran2.entity1.javaGenerics.generic;

import java.util.ArrayList;

/**
 * 泛型通配符
 *
 *  泛型通配符?,代表任意的数据类型
 *
 *  定义：(查看ArrayList的构造方法)无法在类中使用
 *
 *  使用：调用方法时可以给予任意类型。
 *  		参照Arraylist的构造方法:	public ArrayList(Collection<? extends E> c)
 *
 *  为了便于?的理解,我们将以上方法重写为：public ArrayList(ArrayList<? extends E> c)
 *
 *  该方法的意思:创建集合对象A时,给于另外一个集合对象B作为参数,则创建好的集合A中包含了集合B中的元素
 *
 *  ? extends E代表只要是E类型的子类即可
 *  ? super E代表只要是E类型的父类即可
 *
 *  两个集合类型相同的话，也可以一个集合当做另一个集合的参数~
 * */

public class GenericDemo {
    public static void main(String[] args){
        // 定义集合String类型b，包含三个元素
        ArrayList<String> listA = new ArrayList<String>();
        listA.add("依然");
        listA.add("粑粑");
        listA.add("蠢觉");

        // 使用集合A来创建B
        ArrayList<Object> listB = new ArrayList<Object>(listA);
        listB.add(112);
        listB.add("有不同类型");

        // 查看集合A与集合B
        System.out.println(listA);
        System.out.println(listB);
    }
}
