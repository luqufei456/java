package com.yiran.entity.javaString;

/**
 * 分析：
 * 		A:定义两个字符串对象，用于存储已经存在的用户名和密码
 * 		B:键盘录入用户名和密码
 * 		C:拿键盘录入的用户名和密码和已经存在的用户名和密码进行比较
 * 			如果内容相同，提示登录成功
 * 			如果内容不同，提示登录失败，并提示还有几次机会
 * */

import java.util.Scanner;

public class Login {
    public static void main(String[] args){
        // 定义2个字符串对象，用于存储已经存在的用户名和密码
        String username = "yiran";
        String password = "1976967579";

        // 给三次机会，用循环实现
        for (int x = 0;x < 3;x++){
            // 键盘录入用户名和密码
            Scanner sc = new Scanner(System.in);
            System.out.print("username:");
            String name = sc.nextLine(); // 这里是 sc对象的方法获得的 所以地址并不一样
            System.out.print("password:");
            String pwd = sc.nextLine();

            // 这里用 Scanner录入的 并不相当于直接 String name = "xx"; 所以不能用 "=="
            if (username.equals(name) && password.equals(pwd)){
                System.out.println("登录成功");
                break;
            }
            else{
                if (x == 2){ // 这里代表已经输入了三次账号密码
                    System.out.println("用户已被锁定，请发送短信解锁");
                }
                else{
                    System.out.println("用户名或密码错误，你还有"+(2-x)+"次机会");
                }
            }

        }


    }

}
