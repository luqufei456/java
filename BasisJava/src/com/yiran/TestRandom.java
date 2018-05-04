package com.yiran;

import java.util.Random;
import java.util.Scanner;
import java.awt.Robot;

public class TestRandom {
    public static void main(String[] args) throws Exception{
        Random r = new Random();
        Robot  rtime   =   new Robot(); // 要设置出错时抛出异常才能用
        Scanner sc = new Scanner(System.in);
        while (true){
            int i = r.nextInt(10); // 0 - 9  不包括10 类似python的 range()
            System.out.print("请输入一个0-9的数字比较大小：");
            int num = sc.nextInt();
            if (num >= 0 && num <= 9){
                if (num > i){
                    System.out.println("随机数比您输入的数小");
                }
                else if(num < i){
                    System.out.println("随机数比您输入的数大");
                }
                else{
                    System.out.println("恭喜您猜对了~");
                    break;
                }
            }
            else{
                System.out.println("请输入正确范围的数字！");
            }
            rtime.delay(2000); // 延迟2s
        }
    }
}
