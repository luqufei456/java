package com.yiran.javaSEwork;

import java.util.Arrays;

public class ArrayWork {
    public static void main(String[] args){
        System.out.println("--------斐波那契--------");
        rabbit(20);
        System.out.println("--------元素求和--------");
        int[] arr1 = {171,72,19,16,118,51,210,7,18};
        arraySum(arr1);
        System.out.println("--------裁判评分--------");
        int[] arr2 = {10,80,89,100,85,92};
        score(arr2);
        System.out.println("--------数组反转--------");
        int[] arr3 = {1,2,3,4,5};
        arrayReverse(arr3);
        System.out.println("--------查找下标--------");
        int[] arr4 = {2,2,41,53,21,53};
        arraySearch(arr4,53);
        System.out.println("--------数据加密--------");
        pwdEncryption(4567);
    }

    public static void rabbit(int a){
        /**
         * 1 1 2 3 5  说白了就是斐波拉契数列
         * 要求 求20个月的
         * */
        int[] arr = new int[a];
        if (a <= 2){
            for (int x =0;x < arr.length;x++){
                arr[x] = 1;
            }
        }
        else{
            arr[0] = 1;
            arr[1] = 1;
            for (int x = 2;x < arr.length;x++){
                arr[x] = arr[x-2] + arr[x-1];
            }
        }
        System.out.println("要求的斐波那契最后一位数为：" + arr[a-1]);
    }

    public static void arraySum(int[] arr){
        /**
         * 要求：求和的元素的个位和十位不能包含7,并且只能为偶数。
         * */
        int sum = 0;
        for (int x = 0;x < arr.length;x++){
            //    个位不包含7             十位不包含7             为偶数
            if ((arr[x]%10 != 7) && (arr[x]/10%10 != 7) && (arr[x]%2 == 0)){
                sum += arr[x];
            }
        }
        System.out.println("该数组中符合的元素和为" + sum);
    }

    public static void score(int[] arr){
        /**
         * 去掉最大值和最小值，然后求和
         * */
        int max = arr[0]; // 定义该数组中的第一个为最大和最小，用于和其他做比较
        int min = arr[0]; // 不能自己定义一个数 因为自己定义的数有可能不在数组的最大与最小之间的范围中
        int sum = 0;
        for (int x = 0;x < arr.length;x++){
            /*if (max < arr[x]){
                max = arr[x];
            }*/
            max = max<arr[x]?arr[x]:max;
            min = min>arr[x]?arr[x]:min;
        }
        /*for (int x = 0;x < arr.length;x++){
            if (min > arr[x]){
                min = arr[x];
            }
        }*/
        for (int x = 0;x < arr.length;x++){
            sum += arr[x];
        }
        int score = (sum-max-min)/(arr.length-2);
        System.out.println("该选手的评分为：" + score);
    }

    public static void arrayReverse(int[] arr){
        /**
         * 数组反转
         * */
        int[] arrReverse = new int[arr.length];
        for (int x = arr.length-1;x >= 0;x--){
            arrReverse[arr.length-1-x] = arr[x];
        }
        for (int i = 0;i <arrReverse.length;i++){
            arr[i] = arrReverse[i];
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void arraySearch(int[] arr,int x){
        /**
         * 数组查找第一个元素的下标
         * */
        int index = 0;
        for (int i = 0; i<arr.length;i++){
            if (arr[i] == x){
                index = i;
                break;
            }
            else if(i == arr.length-1 && index == 0){
                System.out.println("没找到");
                return;
            }
        }
        System.out.println("找到了，第一次出现的下标为：" + index);
    }

    public static void pwdEncryption(int pwd){
        String str = String.valueOf(pwd);
        if (str.length() != 4){
            System.out.println("请输入有效数字");
        }
        else{
            /*int thousand = pwd/1000; // 千位
            int hundred = pwd/100%10; // 百位
            int ten = pwd/10%10; // 十位
            int bits = pwd%10; // 个位*/
            int[] arr = new int[str.length()];
            for (int i=str.length()-1;i >= 0;i--){
                char ch = str.charAt(i);
                int x = ch - '0'; // 将 '1' 转换成 1
                arr[i] = (x+5)%10;
            }
            System.out.println(Arrays.toString(arr));
            for (int j = 0;j <= (arr.length-1)/2;j++){
                int replace = arr[j];
                arr[j] = arr[arr.length-1-j];
                arr[arr.length-1-j] = replace;
            }
            System.out.println(Arrays.toString(arr));
        }
    }

}
