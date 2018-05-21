package com.yiran2.entity2.fileClass;

import java.io.File;

/**
 * File类中的构造方法
 *
 *  File类的方法:
 *  	构造方法:
 *  		1:直接给于路径(绝对路径,相对路径)，一般都这么写
 *
 *  		2:路径分为父亲(该文件或文件夹所在的文件夹)与孩子(该文件或文件夹自己的名字)
 *
 *  public File(String parent, String child)：parent指的是父级目录，child指的是子级目录
 *  public File(File parent, String child) ：parent为File类型，为了使用File类中的方法
 * */

public class FileClassDemo2 {
    public static void main(String[] args){
        // 一般常用构造方法创建文件对象
        File file1 = new File("staticFile\\Test\\FileTest.txt");

        // 一般常用构造方法创建文件夹对象
        File file2 = new File("staticFile\\Test");

        // 通过父亲与孩子的构造方法创建FileTest.txt对应的文件对象
        File file3 = new File("staticFile\\Test","FileTest.txt");

        // 通过父亲与孩子的构造方法创建staticFile文件夹下Test文件夹对应的对象
        File file4 = new File("staticFile","Test");
        // 获取该对象所对应的文件/文件夹 名
        System.out.println(file4.getName()); // Test
        System.out.println(file3.getName()); // FileTest.txt
        System.out.println(file2.getName()); // Test
        System.out.println(file1.getName()); // FileTest.txt
    }
}
