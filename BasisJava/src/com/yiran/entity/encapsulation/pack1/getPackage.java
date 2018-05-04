package com.yiran.entity.encapsulation.pack1;

/**
 *为什么需要导入包，因为有时我们需要用到别人开发的一些类和方法的时候，就需要引入包，
 * 比如我们需要用到一个List的类，就需要引入java.util包
 *
 * 一个包下可以含有很多个类，除了自定义包，java也给我们提供了很多包，
 * 可以看下jre下的lib --- rt.jar中含有许多包，我们先看一些常用的包
 * java.lang.* 包   自动引入         java.net.*  包		网络开发包
 * java.util.*  包   工具包 			  java.io.*   包		   文件流包
 *
 * java.lang包是Java语言的核心类库，包括了运行Java程序必不可少的系统类，
 * 如基本数据类型、基本数学函数、字符串处理、线程、异常处理类等。每个Java程序运行时，
 * 系统都会自动地引入java.lang包，所以这个包的加载是缺省的。
 *
 * 包的作用：
 *      1、区分相同名字的类
 *      2、当类很多时可以方便我们管理
 *      3、控制访问范围
 *
 * 控制访问范围依靠 public protected private 默认 4种访问级别来实现
 *
 * */

import com.yiran.entity.encapsulation.employee.EmployeeEncapsulation;

public class getPackage {
    public static void main(String[] args){
        // 这里能访问 getSalary方法，是因为public 公开 改为 protected后 同包可以访问 不同包不能访问
        // 默认时 同包可以访问，不同包的子类也不能访问
        EmployeeEncapsulation person = new EmployeeEncapsulation("chunjue",25,25000);
        System.out.println(person.name); // person.age 访问不到
        person.getSalary();
    }
}
