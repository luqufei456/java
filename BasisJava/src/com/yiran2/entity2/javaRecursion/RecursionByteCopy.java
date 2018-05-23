package com.yiran2.entity2.javaRecursion;

import java.io.*;

/**
 * 使用递归方法，复制完整的文件夹
 * */

public class RecursionByteCopy {
    public static void main(String[] args){
        /*String path = "staticFile";
        String newPath = "复制点";
        File file = new File(path);
        File newFile = new File(newPath);

        RecursionByteCopy admin = new RecursionByteCopy();
        admin.copyFile(file, newFile);*/
    }

    // 递归复制文件夹
    public void copyFile(File file1, File file2){
        // 如果file1为文件夹，则创建文件夹
        if (file1.isDirectory()){
            // 这里是使用另一种构造方法，第一个参数为一个file对象，第二个参数为其子目录或文件
            File newDir = new File(file2, file1.getName());
            System.out.println("新文件夹是否被创建："+newDir.mkdir());
            // 得到其下File对象数组
            File[] files = file1.listFiles();
            for (File thisFile : files){
                copyFile(thisFile, newDir);
            }
        }
        // 如果file1为文件
        else if (file1.isFile()){
            // 使用父级目录，在要复制到的目录下创建该文件
            // 这里要不要掉了你要复制的文件名。
            String newFilePath = file2.getAbsolutePath()+"\\"+file1.getName();

            copyData(file1.getAbsolutePath(),newFilePath);
        }
    }

    // 复制文件
    public static void copyData(String filePath, String newPath){
        try {
            // 创建缓冲字节流对象
            FileInputStream fis = new FileInputStream(filePath);
            BufferedInputStream bis = new BufferedInputStream(fis);
            FileOutputStream fos = new FileOutputStream(newPath);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            byte[] bytes = new byte[4096];
            int len;
            while ((len = bis.read(bytes)) != -1){
                bos.write(bytes, 0, len);
            }

            // 先开后关
            bos.close();
            bis.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
