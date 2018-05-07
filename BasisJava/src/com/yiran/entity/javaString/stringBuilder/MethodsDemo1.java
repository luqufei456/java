package com.yiran.entity.javaString.stringBuilder;

/**
 * 使用 + 拼接字符串消耗内存的原因：
 *      String str = "chunjue";
 *      str += "baka";
 *      这时候， 定义str在常量池创建了一个字符串 "baka" 也在常量池定义了一个字符串
 *      最后常量池又创建了一个内存存放 "chunjuebaka" 所以一共用了三段内存
 *      这时候我们可以使用StringBuilder
 *
 * StringBuilder类概述：
 *      StringBuilder：是一个可变的字符串。字符串缓冲区类。
 *
 *      String和StringBuilder的区别：
 *          String的内容是固定的
 *          StringBuilder的内容是可变的
 *
 * StringBuilder类常用方法：
 *  A:构造方法:
 *      StringBuilder()
 *  B:成员方法:
 *      public int capacity():返回当前容量 (理论值)
 *      public int length():返回长度(已经存储的字符个数)
 *      public StringBuilder append(任意类型):添加数据，并返回自身对象
 *      public StringBuilder delete(start,end):删除数据，从什么位置删到什么位置，并返回自身对象
 *      public StringBuilder insert(offset,Object):插入数据，在什么位置插入什么，并返回自身对象
 *      public StringBuilder reverse():反转功能
 * */

public class MethodsDemo1 {
    public static void main(String[] args){
        // 创建对象
        StringBuilder yiran = new StringBuilder();
        System.out.println("yiran："+yiran);
        System.out.println("字符串生成器默认容量："+yiran.capacity()); // 16
        System.out.println("字符串生成器当前长度："+yiran.length()); // 0
        System.out.println();

        // 添加数据 yiran
        yiran.append("yiran"); // 一个字母算一个长度
        System.out.println("yiran："+yiran);
        System.out.println("字符串生成器当前长度："+yiran.length()); // 5
        System.out.println();

        // 添加数据 " " 空格字符
        yiran.append(" "); // 一个空格 算一个长度
        System.out.println("yiran："+yiran);
        System.out.println("字符串生成器当前长度："+yiran.length()); // 6
        System.out.println();

        // 添加数据 "超厉害"
        yiran.append("超厉害"); // 和内存中存储不一样，这里一个汉字也是一个长度 内存中一个汉字要占2个字节 所以char是2个字节的
        System.out.println("yiran："+yiran);
        System.out.println("字符串生成器当前长度："+yiran.length()); // 9
        System.out.println();

        // 因为该字符串生成器都是直接在自身上进行操作，所以内存不会变 但String不同 例如
        String chunjue = "chunjue";
        String chunjue1 = chunjue+" baka";
        System.out.println(chunjue == chunjue1); // false 说明已经不是原来的内存了
        System.out.println();

        // 链式编程
        // 可以看到，当添加后长度超过原先理论容量后，会进行自动扩容
        // 同时，即使扩容了 内存地址一样没有变，说明并没有产生新的字符串生成器
        StringBuilder yiran1 = yiran.append(" gender").append(" is ").append(true+" 手上还有").append(200).append("元");
        System.out.println("看看内存地址是否还相同："+(yiran1 == yiran));
        System.out.println("yiran："+yiran);
        System.out.println("字符串生成器默认容量："+yiran.capacity()); // 34
        System.out.println("字符串生成器当前长度："+yiran.length()); // 33
        System.out.println();

        // reverse() 字符串反转
        yiran.reverse();
        System.out.println("yiran："+yiran);
        System.out.println();

        // 试试 StringBuilder xx = "xxx"; 是否可行 结果不行，报错：不兼容的类型
        // StringBuilder miku = "baka";

    }
}
