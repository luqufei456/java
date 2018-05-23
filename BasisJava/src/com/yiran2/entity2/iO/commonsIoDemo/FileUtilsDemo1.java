package com.yiran2.entity2.iO.commonsIoDemo;

import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * FileUtils工具类的使用
 *
 * 	多级文件夹复制:
 * 		可以使用第三方commons-io提供的FileUtils类的方法
 * 			copyDirectoryToDirectory(File srcDir,File destDir);文件夹复制
 *
 * 	第三方Jar包的使用步骤:
 * 		创建lib文件夹
 * 		将commons-io.jar拷贝到lib文件夹
 *		右键点击commons-io.jar，Build Path→Add to Build Path

 * */

public class FileUtilsDemo1 {
    public static void main(String[] args){
        File staticFileDir = new File("staticFile");
        // dir2可以不存在，会自动创建，将完整的dir1放到dir2中
        File staticFileDir2 = new File("staticFile[副本]");
        try {
            FileUtils.copyDirectoryToDirectory(staticFileDir,staticFileDir2);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
