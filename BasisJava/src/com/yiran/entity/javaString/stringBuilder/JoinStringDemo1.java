package com.yiran.entity.javaString.stringBuilder;

/**
 * 需求：利用StringBuilder 将数组拼接为字符串
 *
 * 举例：
 * 		int[] arr = {1,2,3};
 * 结果：
 * 		[1, 2, 3]
 * */

public class JoinStringDemo1 {
    public static void main(String[] args){
        // 定义数组
        int[] arr = {1,2,3,4};

        // 调用静态方法
        String arrStr = arryToString(arr);
        System.out.println(arrStr);

    }

    // 定义静态方法拼接数组元素为字符串
    public static String arryToString(int[] arr){
        StringBuilder arrStr = new StringBuilder();
        for (int x = 0;x < arr.length;x++){
            if (x == 0){
                arrStr.append("["+arr[x]+", ");
            }
            else if (x == arr.length-1){
                arrStr.append(arr[x]+"]");
            }
            else{
                arrStr.append(arr[x]+", ");
            }
        }
        return arrStr.toString();
    }

}
