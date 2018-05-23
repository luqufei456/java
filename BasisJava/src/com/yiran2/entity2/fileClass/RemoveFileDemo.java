package com.yiran2.entity2.fileClass;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class RemoveFileDemo {
    public static void main(String[] args){
        try {
            // removeFile("staticFile\\A");

            // 如果传入的是一个空文件夹，调用listFiles方法，会得到一个空数组
            // 这个空数组的长度则为0
            // File file = new File("staticFile\\A\\B\\D");
            // System.out.println(file.listFiles().length);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // 删除整个文件夹，内部包含文件的也一并删除
    public static void removeFile(String path) throws IOException {
        File file = new File(path);
        // 得到其文件内对象数组，如果为空，自然也能删
        // 这里不像迭代器，对file的操作不会影响File[]数组
        File[] files = file.listFiles();
        System.out.println(Arrays.toString(files));

        // 遍历对象数组
        for (File thisFile : files){
            // 如果为文件，则直接删除
            if (thisFile.isFile()){
                thisFile.delete();
            }
            // 如果为不为空的文件夹，则递归调用，将其内部删干净
            // 递归完之后，代表内部为空，则可以删除自己
            else if (thisFile.listFiles().length != 0){
                removeFile(thisFile.getPath());
                System.out.println(thisFile.getName());
                thisFile.delete();
            }
            // 如果为空文件夹，则删除自己，如果没有这一步
            // 会出现文件夹B内部有空文件夹C，B无法被删除
            // 所以这里很重要
            else if(thisFile.listFiles().length == 0){
                System.out.println(thisFile.getName());
                thisFile.delete();
            }
        }

        // 最后删除file文件夹本身，此时内部已经为空
        file.delete();
    }
}
