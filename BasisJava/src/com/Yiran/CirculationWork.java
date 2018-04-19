package com.Yiran;

import java.util.Scanner;

public class CirculationWork {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要求三角形的高：");
        int high = sc.nextInt();

        CirculationWork work = new CirculationWork();
        work.rightAngle(high);
        work.equilateral(high);
        work.hollowEquilateral(high);
    }
    public void rightAngle(int high){

        for (int i = 1;i <= high;i++){ // 控制行
            for (int j = 0;j < i;j++){ // 控制星号
                System.out.print("*");
            }
            System.out.println(); //换行
        }
    }

    public void equilateral(int high){
        for (int i = 1; i <= high; i++){ //控制行
            for (int j = high-i;j >= 0;j--){ // 控制空格
                System.out.print(" ");
            }
            for (int z = 1;z < 2*i;z++){ // 控制星号 2*i 因为每行多2个星号
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void hollowEquilateral(int high){
        for (int i = 1; i <= high; i++){ // 控制行
            for (int j = high-i;j >= 0;j--){ // 控制空格
                System.out.print(" ");
            }
            for (int z = 1;z < 2*i;z++){ // 控制星号
                if (i != high){
                    if (z == 1 || z == 2*i-1){ // 控制第一个和最后一个星号 其余空格
                        System.out.print("*");
                    }
                    else{
                        System.out.print(" ");
                    }
                }
                else{
                    System.out.print("*"); // 控制最后一行全星号
                }
            }
            System.out.println();
        }
    }

}
