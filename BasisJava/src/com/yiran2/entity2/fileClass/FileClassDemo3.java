package com.yiran2.entity2.fileClass;

import com.yiran2.entity1.javaClass.inheritance.Demo3.SubClass;

import java.io.File;

/**
 * File类的获取方法
 *
 *  File类常见方法
 *  	1:获取文件/文件夹信息方法
 *  		public String getAbsolutePath()  获取绝对路径 还有个File的 也是同样的效果
 *   	    public String getPath()  获取路径(用什么方式创建的对象,就返回什么方式的路径(绝对路径/相对路径))
 *   	    public String getName() 获取文件/文件夹的名称
 *   	    public String getParent()  返回所在文件夹路径(根据创建对象时是否为绝对路径/相对路径)
 * */

public class FileClassDemo3 {
    public static void main(String[] args){
        // 创建文件对象
        File file = new File("staticFile\\Test\\FileTest.txt");
        File file2 = new File("H:\\StudyJava\\BasisJava\\staticFile\\Test\\FileTest.txt");
        File dir = new File("staticFile\\Test");

        // 获取绝对路径
        System.out.println(file.getAbsolutePath());
        System.out.println(file2.getAbsolutePath());
        System.out.println();

        // 获取创建对象时使用的路径
        System.out.println(file.getPath());
        System.out.println(file2.getPath());
        System.out.println();

        // 获取对象的文件/文件夹名称
        System.out.println(file.getName());
        System.out.println(file2.getName());
        System.out.println();

        // 返回创建对象时使用的 所在文件夹路径
        System.out.println(file.getParent());
        System.out.println(file2.getParent());
        System.out.println(dir.getParent());
    }
}
