package com.Yiran;

import java.util.Scanner;

public class LogicControl {
    public static void main(String[] args){
        System.out.print("输入一个数字:");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println(i);
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

}