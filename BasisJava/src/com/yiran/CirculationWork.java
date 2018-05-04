package com.yiran;

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
        work.rhomb(high);
        work.hollowrhomb(high);
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

    public void hollowrhomb(int high){
        if(high%2 == 1){
            int avg = (high/2)+1;
            for (int i = 1; i <= high; i++){ // 控制行
                if (i <= avg){
                    for (int j = high-i-avg;j >= 0;j--){
                        // 当i小于high/2时，
                        // 由于是菱形，所以空格并不是high-i 而是要再减一个avg
                        // 比如higt为7 就相当于包括中心的下部是high为4的三角形
                        System.out.print(" ");
                    }
                    for (int z = 1;z < 2*i;z++){ // 控制星号
                        if (z == 1 || z == 2*i-1){ // 控制第一个和最后一个星号 其余空格
                            System.out.print("*");
                        }
                        else{
                            System.out.print(" ");
                        }
                    }
                }
                else{
                    for (int j = i-avg-1;j >= 0;j--){
                        System.out.print(" ");
                    }
                    for (int z = 0;z < high-2*(i-avg);z++){
                        if (z == 0 || z == high-2*(i-avg)-1){
                            // i-avg=前面应该空的空格 即把下半部分当做一个倒三角形 avg就是最中心的行高
                            // high- 2*(i-avg) 是因为每行差2格
                            System.out.print("*");
                        }
                        else{
                            System.out.print(" ");
                        }
                    }
                }
                System.out.println(); // 这里就能总领换行
            }
        }
        else{
            int avg = high/2;
            for (int i = 1; i <= high; i++){ // 控制行
                if (i < avg){
                    for (int j = high-i-avg;j > 0;j--){
                        // 当i小于high/2时，
                        // 由于是菱形，所以空格并不是high-i 而是要再减一个avg
                        System.out.print(" ");
                    }
                    for (int z = 1;z < 2*i;z++){ // 控制星号
                        if (z == 1 || z == 2*i-1){ // 控制第一个和最后一个星号 其余空格
                            System.out.print("*");
                        }
                        else{
                            System.out.print(" ");
                        }
                    }
                }
                else if (i == avg || i == avg+1){
                    for (int z = 1;z < 2*avg;z++){ // 控制星号
                        if (z == 1 || z == 2*avg-1){ // 控制第一个和最后一个星号 其余空格
                            System.out.print("*");
                        }
                        else{
                            System.out.print(" ");
                        }
                    }
                }
                else{
                    for (int j = i-avg-1;j > 0;j--){
                        System.out.print(" ");
                    }
                    for (int z = 0;z < high-2*(i-avg)+1;z++){
                        if (z == 0 || z == high-2*(i-avg)){
                            // 实际上就是 中心的行宽 - 2倍的 该行的空格 因为前后都空了
                            // 偶数菱形 中心行宽为 high-1  该行的空格为 i-avg-1
                            // high - 1 - 2*(i - avg - 1) == high - 2(i - avg) + 1
                            System.out.print("*");
                        }
                        else{
                            System.out.print(" ");
                        }
                    }
                }
                System.out.println(); // 这里就能总领换行
            }
        }

    }

    public void rhomb(int high){
        for(int i = 1;i<=(high+1)/2;i++){
            // 如果是偶数 则 (8+1)/2 = 4 // 第一个中间
            // 如果是奇数 则 (9+1)/2 = 5 刚好是中间
            for(int j = 0;j<(high+1)/2-i;j++){ // i为中间值时， j = 0 没有空格
                System.out.print(" ");
            }
            for(int m = 1;m<=2*i-1;m++){
                // 中间的长度为 奇数high  或 偶数high-1
                // 该循环中 i最大为 (high+1)/2 则 m 最大= high
                // 偶数时 最多输出 high-1个星号 这里符合
                // 奇数时 最多输出 high个星号 这里符合
                System.out.print("*");
            }
            System.out.println();

        }

        // 是偶数则两个循环一个输出一半
        // 是奇数则第一个循环输出 high/2 +1  第二个循环输出剩下的

        for(int i = high/2;i>0;i--){

            for(int m = 0;m<(high+1)/2 - i;m++){
                System.out.print(" ");
            }

            for(int j = 0;j<i*2-1;j++){

                System.out.print("*");

            }
            System.out.println();
        }
    }

}
