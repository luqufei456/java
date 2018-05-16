package com.yiran2.entity1.javaIterator.avgAgeAndException;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 迭代过程中修改产生的并发异常
 *
 *  使用集合存储多个Person对象,当遇到16岁的人时,就添加一个90岁的人
 *
 *  该例中可能会产生并发修改异常:迭代器所认为的集合状态与集合真正的状态不统一了!就会出现该异常.
 *
 *  运行上述代码发生了错误java.util.ConcurrentModificationException这是什么原因呢？
 *  在迭代过程中，使用了集合的方法对元素进行操作。导致迭代器并不知道集合中的变化，容易引发数据的不确定性。
 *  解决并发修改异常,重新获取迭代器
 * */

public class ConcurrentModificationExceptionDemo {
    public static void main(String[] args){
        // 创建Person类的集合对象
        ArrayList<Person> perList = new ArrayList<Person>();

        // 像集合中添加元素
        Person yiran = new Person("依然",21);
        Person chunjue = new Person("蠢觉",25);
        Person miku = new Person("miku",23);
        Person miaojiang = new Person("喵酱",16);
        Person zhangzhe = new Person("长者",90);

        perList.add(yiran);
        perList.add(chunjue);
        perList.add(miku);
        perList.add(miaojiang);

        // 调用集合的iterator方法，返回迭代器对象
        Iterator<Person> perIterator = perList.iterator();

        //混合使用hasNext与next方法,循环获取元素
        while(perIterator.hasNext()) {
            //如果有元素,就获取元素
            Person thisP = perIterator.next();
            thisP.show();
            //判断年龄是否为16岁
            if(thisP.getAge() == 16) {
                //如果存在16岁的人,就加入90岁的长者
                perList.add(zhangzhe);
                break; // 当集合加入一个元素后，就不要再使用迭代器操作元素了
            }
        }
        System.out.println("-------------------------------------");
        // 更新迭代器 打印结果
        perIterator = perList.iterator();
        while (perIterator.hasNext()){
            Person thisP = perIterator.next();
            thisP.show();
        }
    }

}
