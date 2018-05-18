package com.yiran2.entity2.javaMap;

import java.util.*;

/**
 * Map集合
 *
 * Map:双列集合,每个元素分为键与值两部分,是一个键值得对应关系.我们经常使用键找值
 *
 * 最常用的Map集合是HashMap:键是唯一的且无序
 *
 *  用法:
 *  		创建对象时,要分别制定键的泛型与值的泛型
 *
 *  		Map(HashMap)的使用：创建对象时加入两个泛型。
 *  		Map<k,v>
 *  		key - 此映射所维护的键的类型
 *  		value - 映射值的类型
 *
 *  		常用方法：
 *  			public void put(K key,V value)		//加入元素，则新值会覆盖掉旧值
 *  			public void get(Object key)		//根据键找值
 *  			public Set<K> keySet()			//返回所有键的集合
 *  			public Collection<V> values()  	//返回所有值的集合
 *
 *   Map集合的第一种遍历方式:
 *
 *      Map没有迭代器方法,最常用的遍历方法:先获取所有键的集合,迭代该集合,依次获取每一个键.通过键找值.
 *   迭代嘛，使用迭代器，或者增强for循环，都可以。
 *
 *   Map集合的第二种遍历方式:
 *
 *      Set<Map.Entry<K,V>> entrySet()    方法用于返回某个集合所有的键值对对象。
 *      Entry将键值对对应关系封装成了对象。可以从一个Entry对象中中获取一个键值对的键与值。
 *
 *  	Map.Entry是一个内部接口
 *
 *  	Entry中的方法如下：
 *  		K getKey()		获取键
 *  		V getValue()	获取值
 * */

public class MapDemo1 {
    public static void main(String[] args){
        // 创建Map集合
        HashMap<String, String> yiran = new HashMap<String, String>();

        // 向集合中添加数据
        yiran.put("姓名", "依然");
        yiran.put("年龄", "21");
        yiran.put("身高", "177cm");
        yiran.put("体重", "54kg");

        // 通过键获取值
        String name = yiran.get("姓名");
        System.out.println("我的姓名为："+name);

        // 返回所有键的集合 返回的是一个set类型，并不是hashSet，而是其父类，
        // 也就是不重复的，类似于Python中的集合set
        Set<String> keySet = yiran.keySet();
        System.out.println("key："+keySet);

        // 返回所有键的集合 返回的是一个Collection类型，是List和Set的父类
        Collection<String> valueColl = yiran.values();
        System.out.println("Value:"+valueColl);

        // 直接输出Map
        System.out.println(yiran);

        // 遍历Map方法1.1
        System.out.println("---------------------------------------");
        MapDemo1 admin = new MapDemo1();
        admin.traverse1_1(yiran);

        // 遍历Map方法1.2
        System.out.println("---------------------------------------");
        admin.traverse1_2(yiran);

        // 遍历Map方法2
        System.out.println("---------------------------------------");
        admin.traverse2(yiran);
    }

    // 第一种遍历Map的方法的第一个分支    如果不定义泛型，则默认Object类型，接收所有类型
    // 也可以将形参定义为  Map  是HashMap的父类，可以接收其子类
    public void traverse1_1(HashMap hashMap){
        // 先获得其键的set集合，利用set集合来获得值
        Set keySet = hashMap.keySet();

        // 使用Set的迭代器方法，得到Set的迭代器
        Iterator keyIter = keySet.iterator();

        // 使用迭代 emm 也可以一开始就使用增强for循环
        while (keyIter.hasNext()){
            Object thisKey = keyIter.next();
            Object thisValue = hashMap.get(thisKey);
            System.out.println("Key:Value = "+thisKey+":"+thisValue);
        }
    }

    public void traverse1_2(HashMap hashMap){
        // 先获得其键的set集合，利用set集合来获得值
        Set keySet = hashMap.keySet();

        // 使用增强for循环获得Key值，再得到Value输出
        for (Object thisKey : keySet){
            Object thisValue = hashMap.get(thisKey);
            System.out.println("Key:Value = "+thisKey+":"+thisValue);
        }
    }

    public void traverse2(HashMap hashMap){
        // 获取集合中所有的键值对对象的set集合
        Set<Map.Entry> entrySet = hashMap.entrySet();
        // 输出看看 表面看起来，和直接输出hashMap一样，但是 entrySet中，存储着键值对 对象
        System.out.println(entrySet);

        // 使用增强for循环迭代，依次获取每一个对象
        for (Map.Entry thisEntry : entrySet){
            // 通过键值对对象获取键
            Object thisKey = thisEntry.getKey();
            // 通过键值对对象获取值
            Object thisValue = thisEntry.getValue();
            System.out.println("Key:Value = "+thisKey+":"+thisValue);
        }
    }

}
