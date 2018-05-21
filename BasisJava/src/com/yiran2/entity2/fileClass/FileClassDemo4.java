package com.yiran2.entity2.fileClass;

import com.yiran2.entity1.javaClass.inheritance.Demo3.SubClass;

import java.io.File;

/**
 * File类的创建与删除方法
 *
 *
 *  可以创建/删除该文件(Java删除时，不会使用windows的回收站)
 *
 *  public boolean delete()  删除文件
 *  public boolean createNewFile() throws IOException  创建文件
 *  		在创建文件时,如果文件所在的文件夹不存在,则报错系统找不到指定的路径.创建文件时,必须确保文件夹已经存在
 *
 *  public boolean mkdir()  使用mkdir方法创建文件夹时,必须保证其所在文件夹已经存在,否则创建失败(不会报错)
 *  public boolean mkdirs() 一次性创建多级目录
 *
 *  public boolean delete()  删除文件夹不能为非空(有东西),否则删除失败
 * */

public class FileClassDemo4 {
    public static void main(String[] args){
        File file = new File("staticFile\\Test\\FileTest.txt");
        // 删除文件
        System.out.println(file.getPath()+"的删除结果为："+file.delete());

        // 创建文件
        try {
            System.out.println(file.getPath()+"的创建结果为："+file.createNewFile());
        } catch (Exception e){
            System.out.println("在创建文件时,如果文件所在的文件夹不存在," +
                    "则报错系统找不到指定的路径.创建文件时,必须确保文件夹已经存在");
        }finally {
            System.out.println();
        }

        // 创建文件夹
        /** 必须保证其所在文件夹已经存在,否则创建失败(不会报错) */
        File dir = new File("staticFile\\TestA\\TestB");
        System.out.println(dir.mkdir());
        // 一次性创建多级目录
        System.out.println(dir.mkdirs());

        // 删除文件夹,先获得该对象对应的文件夹名，可以看到，虽然创建的是多级目录
        // 但是该对象对应的文件名为最底层的文件夹 即为TestB
        System.out.println(dir.getName()); // TestB
        System.out.println(dir.delete());

        // 删除文件夹不能为非空(有东西),否则删除失败
        // 该例中，Test下有文件FileTest.txt，所以无法删除，返回flase
        File dir2 = new File("staticFile\\Test");
        System.out.println(dir2.delete());
        // 请求虚拟机在终止时删除
        //dir2.deleteOnExit();

    }
}
