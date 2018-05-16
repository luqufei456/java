package com.yiran.entity.javaString.setNewString;

/**
 * 并不是修改文件名，只是将一段字符串中的某段修改
 * 用于string练习
 * */

public class SetNewFileName {
    public static void main(String[] args){
        System.out.println(setFileName("haha"));
    }

    public static String setFileName(String fileName){
        String path = "d:\\source\\images\\myphoto\\冬天小河.jpg";
        String[] pathArr = path.split("\\\\");

        /*ArrayList<String> pathList = arrToList(pathArr);*/

        String name = pathArr[pathArr.length-1];
        String[] fileArr = name.split("\\."); // 使用 \ 转义 但是 \在java中也需要转义 所以 \\

        String newName = fileName+"."+fileArr[1];

        pathArr[pathArr.length-1] = newName;

        String newPath = arrToString(pathArr,"\\");

        return newPath;
    }

    // 这个没啥用，用成集合了，最后发现没啥意义
    /*public static ArrayList<String> arrToList(String[] strArr){
        ArrayList<String> pathList = new ArrayList<String>();
        // 这里 length-1是因为不需要最后的文件名
        for (int i = 0;i < strArr.length-1;i++){
            pathList.add(strArr[i]);
        }
        return pathList;
    }*/

    public static String arrToString(String[] strArr, String separator){
        StringBuffer sb = new StringBuffer();
        for (int i = 0;i < strArr.length;i++){
            if (i == strArr.length-1){
                sb.append(strArr[i]);
            }
            else{
                sb.append(strArr[i]+separator);
            }
        }
        return sb.toString();
    }

    // 第二种方法
    public static String setNewName(String path, String newName){
        String[] pathArr = path.split("\\\\");
        String original = pathArr[pathArr.length-1].split("\\.")[0];
        return path.replace(original,newName);
    }
}
