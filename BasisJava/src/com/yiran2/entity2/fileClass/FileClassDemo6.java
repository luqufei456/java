package com.yiran2.entity2.fileClass;

import java.io.File;

/**
 * File类的listFiles方法
 *
 * 终于到了，可以通过递归+listFiles删除整个文件夹的方法了
 *
 * 	public File[] listFiles()  获取调用方法文件夹下的所有file对象(文件或文件夹)
 *
 * 	返回后，通过遍历，判断子对象是否为文件夹，是的话就进行递归，然后是文件就进行删除，当其文件夹下没有
 * 	file对象时，进行删除，OJBK，这样就完成了删除整个文件夹的操作啦
 *
 * 	当然，不能直接通过返回的file[] 来，而是要创建一个新的file数组，不受该文件夹影响的
 * */

public class FileClassDemo6 {
    public static void main(String[] args){
        // 创建文件对象 可以发现  ./ 代表的是当前项目目录
        File dir = new File("../");
        // ..
        System.out.println(dir.getName());
        // H:\StudyJava\BasisJava\..
        // 可以看到，显示还是项目目录下的..目录，但实际上已经是项目目录的父目录
        System.out.println(dir.getAbsolutePath());

        // 使用另一种构造方法，使相对路径可以达到项目根目录外的一层
        File dir2 = new File(dir, "java测试");

        // 获取该文件夹下的所有file对象
        File[] files = dir2.listFiles();

        // 使用增强for循环遍历
        for (File thisFile : files){
            System.out.println(thisFile.getName());
        }
    }
}
