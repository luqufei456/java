package com.yiran2.entity2.fileClass;

import java.io.File;

/**
 * File文件类
 *
 * 	File:
 * 		文件可以持久化地存储数据
 * 		File的一个对象就代表一个文件或文件夹(自己简单地定义,方便记忆的说法)
 * 		文档上说明File类代表文件或文件夹路径,但是我们可以通过路径找到对应的文件或文件夹.
 * 		可以认为File类就代表文件或文件夹(通过路径找到)
 *
 * 	构造方法:
 * 		public File(String pathname)  通过路径找到对应的文件或文件夹
 *
 *
 * 	相对路径与绝对路径
 * 	    绝对路径：从盘符开始到文件的完整路径
 * 	    相对路径：从某个参照路径开始到指定文件所经过的路径
 * 	    在IDEA中,所有的文件如果想使用相对路径,则其参照路径均为项目根目录
 *
 * 	 在java当中对于路径的分隔符可以使用/或者\\,是通用的
 *
 * 	 获取java项目的根目录
 * 	    相对路径的获得
 * 	        说明:相对路径(即不写明时候到底相对谁)均可通过以下方式获得（不论是一般的java项目还是web项目）
 * 	        String relativelyPath=System.getProperty("user.dir");
 *
 * 	length()方法，获取文件的大小，返回的大小为字节大小，不能用于获取文件夹的大小
 * */

public class FileClassDemo1 {
    public static void main(String[] args){
        // 先获得项目根目录
        String relativelyPath = System.getProperty("user.dir");
        System.out.println(relativelyPath);

        // 查找文件 绝对路径
        File file1 = new File("H:\\StudyJava\\BasisJava\\staticFile\\FileTest.txt");
        // 相对路径
        File file1_1 = new File("staticFile");


        // 查找文件夹  绝对路径
        File file2 = new File("H:\\StudyJava\\BasisJava\\staticFile");
        // 相对路径
        File file2_1 = new File("staticFile\\FileTest.txt");
        // 获取文件大小，判断文件是否为FileTest.txt
        System.out.println(file1.length()); // 23
        System.out.println(file2_1.length()); // 23

        // 尝试可否获取文件夹大小
        System.out.println(file1_1.length()); // 0
        System.out.println(file2.length()); // 0

    }
}
