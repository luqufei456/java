package com.Yiran;

import java.util.Scanner;

public class LogicControl {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); // 键盘录入
        /*int i = sc.nextInt(); // nextLine(); 返回一个字符串
        System.out.println(i);*/
        System.out.print("请输入第一个字符串:"); // 输入aa bb cc 最后得到为 aa bb cc
        String i = sc.nextLine();
        System.out.print("请输入第二个字符串:"); // 输入aa bb cc 最后得到为 aa
        String x = sc.next();

        System.out.println(i); // next()遇到空格会停下 而nextLine()遇到换行才会停下
        System.out.println(x);

        /*
         类名 + 定义名 = new 类名();  得到一个对象 然后可以使用方法
         要在主函数中才能使用这种方法
         static 的方法为静态方法，可以通过类名直接调用，也可以通过实例对象调用，推荐使用类名调用
         一般方法只能用实例对象调用
         */
        LogicControl lc = new LogicControl();
        lc.theIf();
        lc.theSwitch();
        lc.theWhile();
        lc.theFor();
        lc.the99Table();
    }

    public void theIf(){
        int ifA = 10;
        int ifB = 20;
        if (ifA > ifB){
           System.out.println("ifA比ifB大，A = " + ifA);
        }
        else{
            System.out.println("ifB比ifA大,B = " + ifB);
        }
    }

    public void theSwitch(){
        int switchA = 3;
        switch (switchA){
            case 1:
                System.out.println("switchA的值为1");
                break;
            case 2:
                System.out.println("switchA的值为2");
                break;
            case 3:
                System.out.println("switchA的值为3");
                break;
        }
    }

    public void theWhile(){
        int whileA = 1;
        while (whileA < 10){
            whileA++;
        }
        System.out.println("whileA的值为" + whileA);
    }

    public void theFor(){
        for (int forA = 1; forA < 10; forA++){
            if (forA == 9){
                System.out.println("现在forA的值为" + forA);
            }
        }
    }

    public void the99Table(){
        int i = 1; // 外层控制行数
        while (i <= 9){
            int j = 1; //内层控制每行几列 每次都重新定义 所以 每行的j都是从1开始加
            while (j <= i){
                if (j == 2 && (i == 3 || i == 4)){
                    System.out.print(j + "*" + i + " = " + j*i + "   ");
                }
                else{
                    System.out.print(j + "*" + i + " = " + j*i + "  ");
                }
                j++;
            }
            System.out.println(); // 换行
            i++;
        }
    }


}