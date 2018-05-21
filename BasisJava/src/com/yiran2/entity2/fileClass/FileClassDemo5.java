package com.yiran2.entity2.fileClass;

import java.io.File;

/**
 * File类的判断方法
 *
 * 判断该File对象是否存在或者判断该File对象代表一个文件还是代表一个文件夹
 * 	    public boolean exists()  文件或者文件夹是否存在
 *  	public boolean isDirectory()  判断文件对象是否为文件夹
 *  	public boolean isFile()  判断文件对象是否为文件
 * */

public class FileClassDemo5 {
    public static void main(String[] args){
        // 分别定义一个存在的文件夹和文件，一个不存在的文件夹和文件
        File file = new File("staticFile\\Test\\FileTest.txt");
        File file2 = new File("staticFile\\Test\\FileTest2.txt");
        File dir = new File("staticFile\\Test");
        File dir2 = new File("staticFile\\Test2");

        // 文件或文件夹是否存在
        System.out.println("file对象是否存在："+file.exists());
        System.out.println("file2对象是否存在："+file2.exists());
        System.out.println("dir对象是否存在："+dir.exists());
        System.out.println("dir2对象是否存在："+dir2.exists());
        System.out.println();

        // 判断文件对象是否为文件/文件夹
        System.out.println("file对象是否为文件"+file.isFile());
        System.out.println("file对象是否为文件夹"+file.isDirectory());
        System.out.println("dir对象是否为文件"+dir.isFile());
        System.out.println("dir对象是否为文件夹"+dir.isDirectory());

        // 如果是不存在的文件或文件夹对象时，判断其是否为文件或文件夹，一律报false
        System.out.println("一律报错："+file2.isDirectory());
        System.out.println("一律报错："+file2.isFile());
    }
}
