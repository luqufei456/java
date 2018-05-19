package com.yiran2.entity2.javaCollections;

import com.yiran2.entity1.javaIterator.avgAgeAndException.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * A：sort方法的作用：
 *     对集合中元素排序
 * B：sort方法签名
 *     public static <T> void sort(List<T> list)
 *
 * 有顺序(有序)：第一个元素是多少,第二个元素是多少,第几个元素对应的是第几,顺序不变.
 * 排序：不管是第几个放的,只要到集合中(以Integer集合为例),就按照一定的顺序重新排列了.
 *
 * 这里用到了人类，懒得重新写了，直接使用其他包定义好的
 * */

public class SortDemo1 {
    public static void main(String[] args){
        // 准备集合及元素
        Collection<Integer> intList = new ArrayList<Integer>();
        Collections.addAll(intList, 30, 10, 50, 20, 40);
        System.out.println("intList排序前："+intList);

        // 进行排序, 可以发现，排序功能的参数也是List类型 所以需要强转
        // 数字是按自然顺序，从大到小排序
        Collections.sort((List<Integer>)intList);
        System.out.println("intList排序后："+intList);


        // 如果放字符串(字符串的顺序是字母排序.) a b c
        System.out.println();
        Collection<String> strList = new ArrayList<String>();
        // 如果字符串为汉字的话，不好排序，字母字符串的话，应该是按首字母 进行字母排序
        Collections.addAll(strList, "yiran", "chunjue", "poi", "miku");
        System.out.println("strList排序前："+strList);

        // 进行排序
        Collections.sort((List<String>)strList);
        System.out.println("strList排序后："+strList);

        // 准备自定义Person对象集合，添加元素， 由于自定义类型没有比较顺序，所以需要自己实现排序规则
        Collection<Person> perList = new ArrayList<Person>();
        Collections.addAll(perList, new Person("依然",21), new Person("蠢觉",25), new Person("喵酱",22));

         /**
          * 排序要对集合中的对象的某属性进行排序有两种方式。
          *     a. 一种是要排序对象类实现comparable接口的compareTo方法；然后把对象放入list；
          * 然后调用Collections.sort(list);
          *     b. 一种是不对要排序对象类做任何改动，创建Comparator接口的实现类C；然后 把对象放入list；
          * 然后调用Collections.sort(list, C);
          * */
        // Collections.sort((List<Person>) perList);
    }
}
