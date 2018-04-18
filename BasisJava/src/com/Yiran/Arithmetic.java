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

        // 算术运算符 + - * / % ++ --
        int a = 12; // 定义一个变量，再对其赋值， 叫做变量的初始化 也可以只定义，不赋值
        int b = 5; // 变量只有赋值后才能使用   定义+赋值 = 初始化
        int sum = a + b;

        int c = a/b;  // 11
        double d = a/b; // 11.0  两个整数类型运算，不会将自己转换为double类型 所以得到结果为11

        int e = a%b; // 余数 结果为2

        int f = a++; // 先参与运算，再对自己+1 相当于 int f = a; a = a + 1;
        int g = ++a; // 先对自己+1，再参与运算 相当于 a = a + 1; int g = a;

        int h =10;
        h += a;  // 不能在初始化时直接用 +=  -= 等。 意思是  h = h + a

        boolean i = a == b; // a == b 为false 其值赋给i
        // 若为 i = a != b;  则i的值为true

        boolean j = a>b & a==b; // 两个表达式同时成立才返回true   逻辑与
        // boolean j = a>b | a==b;  有一个表达式成立就返回true  逻辑或
        boolean k = !(a<b);  // 条件不成立时返回true  逻辑非
        boolean l = a>b ^ a==b; // 一个为真 一个为假返回true  都为真 都为假时返回false  逻辑异或

        int z = a>b?a:b; // a>b成立 a赋值给z  否则b赋值给z

        System.out.println("a+b= " + sum);  // 这里的 + 是连接符，并不是运算符

        // a += b; 和 a = a + b; 的区别
        short aa = 1;
        aa += 2;
        System.out.println(getType(aa));  //  short类型
        // aa = aa + 2;  报错 因为这里 2默认为 int类型
        // 需要明确的是“+=”这个运算符在Java中是一个运算符，而不是两个，
        // 程序在执行“+=”时，会自动向高精度进行数据类型转换。所以上面的程序在执行时编译器没有报错。


        Integer xx = 11;
        // 在对象包装中包装了一个基本类型 int 的值，Integer 类型的对象包含一个 int 类型的字段。
        String bb = "22";
        System.out.println(xx.getClass().toString()); // getClass()是反射 后缀可以查看出其类型
        System.out.println(bb.getClass().toString()); // 没有toString() 返回一个class ,sout不能打印class

    }


    // 查看变量类型的一种方法： 自己定义静态方法 不过最好使用 name.getClass().toString();
    public static String getType(Object o){
        return o.getClass().toString();
    }
    public static String getType(int o){
        return "int";
    }
    public static String getType(byte o){
        return "byte";
    }
    public static String getType(char o){
        return "char";
    }
    public static String getType(double o){
        return "double";
    }
    public static String getType(float o){
        return "float";
    }
    public static String getType(long o){
        return "long";
    }
    public static String getType(boolean o){
        return "boolean";
    }
    public static String getType(short o){
        return "short";
    }
    public static String getType(String o){
        return "String";
    }
}