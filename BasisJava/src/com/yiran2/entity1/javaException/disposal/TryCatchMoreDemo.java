package com.yiran2.entity1.javaException.disposal;

/**
 * 多个异常用一个catch处理格式
 *
 * 	1、多个异常分别每个try对应一个catch处理，不建议
 * 	2、多个异常只有一个try一个catch
 * 	3、一个try多个catch的方式
 * */

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class TryCatchMoreDemo {
    public static void main(String[] args){
        /*// 多个异常分别处理
		Scanner sc = new Scanner(System.in);
		String path = sc.next();

		try {
			FileReader fw = new FileReader(path);
		} catch (IOException e) {
			System.out.println("您访问的文件不存在!");
		}

		try {
			System.out.println(10/0);
		} catch (ArithmeticException e) {
			System.out.println("除数不能为0");
		}


		// 多个异常一次try一次catch
		Scanner sc1 = new Scanner(System.in);
		String path1 = sc1.next();

		try {
			FileReader fw = new FileReader(path1);
			System.out.println(10/0);
		}catch(ArithmeticException|IOException ae) {
			System.out.println("您访问的文件不存在!或者除数不能为0");
		}

		System.out.println("后边的代码");*/


        //一个try多个catch的方式
        Scanner sc2 = new Scanner(System.in);
        System.out.println("请输入文件路径：");
        String path2 = sc2.next();
        try{
            FileReader fw = new FileReader(path2);
            System.out.println(10/0);
        }catch(ArithmeticException ae) {
            System.out.println("您的除数不能为0");
        }catch(IOException e) {
            System.out.println("您要访问的文件不存在");
        }
    }
}
