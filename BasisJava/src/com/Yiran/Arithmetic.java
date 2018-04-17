package com.Yiran;
/**
 * 这是一个java程序，进行简单的运算
 * @version 1.0
 * @author yiran
 * @since JDK 10.0
 *
 * 注意事项：
 *  1、文件名以大写字母开始，不要有特殊字符及中文
 *  2、class后的名称要与文件名一致
 *  3、文档注释，单行注释，多行注释
 *  4、标识符--给类，方法，变量起名称
 *
 * 标识符命名规则：
 *  1、使用大小写英文字母
 *  2、数字， "_" ， "$"
 *  3、并且不能以数字开头，也不能为关键字
 *  4、区分大小写
 *
 * 什么是关键字
 *  例如 public class true false这种java内置标识符
 *  对java具有特殊意义的标识符，即为关键字
 * */
public class Arithmetic {
    public static void main(String[] args){
        /*
        * int       指定空间大小 4byte 指定数据类型为整数
        * a         相当于给该片内存空间一个标记名
        * =         赋值符 这里将12的值赋值给a
        * 12        一个常量
        * println   ln的意思是换行 java不像python会print自动换行
        * +         可以是运算符 也可以是连接符
        * */
        int a = 12; // 定义一个变量，再对其赋值， 叫做变量的初始化 也可以只定义，不赋值
        int b = 13; // 变量只有赋值后才能使用   定义+赋值 = 初始化
        int sum = a + b;
        System.out.println("a+b 的结果为：" + sum);
    }
}
