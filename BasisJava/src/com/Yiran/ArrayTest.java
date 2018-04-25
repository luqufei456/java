package com.Yiran;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args){
        ArrayTest arrTest = new ArrayTest();
        /*arrTest.Test1();
        // arrTest.exceptionTest2(); 报错后不会接着运行 所以数组越界异常无法显示，可以注释空指针再尝试
        arrTest.memoryTest3();
        arrTest.memoryTest4();
        arrTest.memoryTest5();
        arrTest.traversalTest6();
        arrTest.arrayMax7();
        arrTest.twoArray8();
        arrTest.traversalTwoArray9();
        arrTest.twoArrayTranspose10();*/
    }

    public void Test1(){
        int [] arr1 = new int[3];
        arr1[0] = 1;
        arr1[1] = 2;
        arr1[2] = 3;
        /* 动态初始化
         * 左边：
         * 		int:说明数组中的元素的数据类型是int类型
         * 		[]:说明这是一个数组
         * 		arr:是数组的名称
         * 右边：
         * 		new:为数组分配内存空间
         * 		int:说明数组中的元素的数据类型是int类型
         * 		[]:说明这是一个数组
         * 		3:数组的长度，其实就是数组中的元素个数
         */

        //int [] arr2 = new int[]{1,2,3}; // 静态初始化格式
        int [] arr2 = {1,2,3}; // 简化后

        System.out.println(arr1); // arr1的内存地址
        System.out.println(arr2.toString()); // 转化为字符串输出，这里也同样是输出内存地址

        System.out.println(arr1[1]); // 格式：数组名[编号] -- 数组名[索引]
        System.out.println(arr2[2]); // 数组的元素访问 即为索引 从0开始
    }

    public void exceptionTest2(){
        /*
        * 两个常见小问题:
        *    A:java.lang.ArrayIndexOutOfBoundsException
        *        数组越界异常
        *        产生的原因：就是你访问了不存在的索引元素。
        *    B:java.lang.NullPointerException
        *        空指针异常
        *        产生的原因：数组已经不指向堆内存的数据了，你还使用数组名去访问元素
        * */
        int[] arr1 = null;
        int[] arr2 = {1,2,3};
        System.out.println(arr1[0]); // 数组不指向堆内存数据 空指针异常
        System.out.println(arr2[3]); // 由于索引从0开始 所以该数组最大索引为2 这里 数组越界异常
    }

    public void memoryTest3(){
        /*
        * 通过这个例子，我们可以看到，数组中的数有一个初始值 0
        * */
        // 定义一个数组
        int[] arr = new int[3];

        // 输出数组名及元素
        System.out.println(arr); // [I@64c64813
        System.out.println(arr[0]); // 0
        System.out.println(arr[1]); // 0
        System.out.println(arr[2]); // 0

        // 给数组中的元素赋值
        arr[0] = 100;
        arr[2] = 200;

        // 再次输出数组名及元素
        System.out.println(arr); // [I@64c64813
        System.out.println(arr[0]); // 100
        System.out.println(arr[1]); // 0
        System.out.println(arr[2]); // 200
    }

    public void memoryTest4(){
        // 定义2个数组
        int[] arr1 = new int[2];
        int[] arr2 = new int[3];

        // 分别输出数组名及元素
        System.out.println(arr1); // [I@3ecf72fd
        System.out.println(arr1[0]); // 0
        System.out.println(arr1[1]); // 0

        System.out.println(arr2); // [I@483bf400
        System.out.println(arr2[0]); // 0
        System.out.println(arr2[1]); // 0
        System.out.println(arr2[2]); // 0

        // 然后分别给数组中的元素赋值
        arr1[1] = 100;

        arr2[0] = 200;
        arr2[2] = 300;

        // 再次输出数组名及元素
        System.out.println(arr1); // [I@3ecf72fd
        System.out.println(arr1[0]); // 0
        System.out.println(arr1[1]); // 100

        System.out.println(arr2); // [I@483bf400
        System.out.println(arr2[0]); // 200
        System.out.println(arr2[1]); // 0
        System.out.println(arr2[2]); // 300
    }

    public void memoryTest5(){
        // 先定义一个数组，赋值、输出
        int[] arr1 = {100,200,300}; // 动态初始化太麻烦了，直接静态初始化
        System.out.println(arr1); // [I@21a06946
        System.out.println(arr1[0]); // 100
        System.out.println(arr1[1]); // 200
        System.out.println(arr1[2]); // 300

        // 然后定义第二个数组，将第一个数组的内存地址赋值给第二个数组
        int[] arr2 = arr1;
        // 给第二个数组赋值
        arr2[0] = 111;
        arr2[1] = 222;
        arr2[2] = 333;

        // 再次输出两个数组内存地址及其元素值
        System.out.println(arr1); // [I@21a06946
        System.out.println(arr1[0]); // 111
        System.out.println(arr1[1]); // 222
        System.out.println(arr1[2]); // 333

        System.out.println(arr2); // [I@21a06946
        System.out.println(arr2[0]); // 111
        System.out.println(arr2[1]); // 222
        System.out.println(arr2[2]); // 333
    }

    public void traversalTest6(){
        // 定义数组
        int[] arr = {11,22,33,44,55};
        // 原始做法
        /*System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
        System.out.println(arr[4]);
        System.out.println("--------------------");*/

        // for循环改进 --- 遍历
        // 为了解决我们去数数组中元素个数的问题，数组就提供了一个属性：length
        // 用于获取数组的长度
        // 格式：数组名.length
        for (int x = 0;x < arr.length;x++){
            System.out.print("当前是第" + x + "个数组元素:");
            System.out.println(arr[x]);
        }
        System.out.println("--------------------");
    }

    public void arrayMax7(){
        // 定义数组
        int[] arr = {12,34,63,5,142};

        // 定义参照物
        int max = arr[0];

        // 遍历数组，获取除了 arr[0]以外的其他元素，进行比较
        for (int x = 1;x < arr.length;x++){
            if (arr[x] > max){
                max = arr[x];
            }
        }
        System.out.println("数组的最大值为：" + max); // 142
    }

    public void twoArray8(){
        /**
         * 二维数组：就是元素为一维数组的数组。
         *
         * 定义格式：
         * 		A:数据类型[][] 数组名;
         * 		B:数据类型 数组名[][];	不推荐
         * 		C:数据类型[] 数组名[];	不推荐
         *
         * 如何初始化呢?
         * 		A:动态初始化
         * 			数据类型[][] 数组名 = new 数据类型[m][n];
         * 			m表示这个二维数组有多少个一维数组
         * 			n表示每一个一维数组的元素有多少个
         * 		B:静态初始化
         * 	      数据类型[][] 数组名 = new 数据类型[][]{{元素...},{元素...},
         *                                                   {元素...},...};
         * 			简化格式：
         * 			数据类型[][] 数组名 = {{元素...},{元素...},{元素...},...};
         */
        // 数据类型[][] 数组名 = {{元素...},{元素...},{元素...},...}
        int [][] arrs = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println(arrs); // [[I@34ce8af7
        System.out.println(arrs.length); // 二维数组中的一维数组的个数  3
        System.out.println(arrs[0]); // [I@b684286
        System.out.println(arrs[0].length); // 二维数组中 第一个 一维数组的元素的个数  3
        System.out.println(arrs[1]); // [I@880ec60
        System.out.println(arrs[2]); // [I@3f3afe78

        //我如何获取到一个二维数组的元素呢?
        System.out.println(arrs[0][0]); // 第1个 一维数组的 第1个 元素  1
        System.out.println(arrs[1][1]); // 第2个 一维数组的 第2个 元素  5
        System.out.println(arrs[2][0]); // 第3个 一维数组的 第1个 元素  7
    }

    public void traversalTwoArray9(){
        // 定义二维数组 静态定义
        int [][] arrs = {{1,2,3},{4,5,6},{7,8,9}};
        // 动态定义
        int [][] arrs2 = new int[5][3];
        // 可以发现 第一个5定义二维数组中有多少一维数组
        // 第二个3定义一维数组中有多少元素
        System.out.println(arrs2.length); // 5
        System.out.println(arrs2[0].length); // 3
        System.out.println(arrs2[2].length); // 3
        System.out.println(arrs2[4].length); // 3
        /**
         * 从上一个例子我们可以看出 arrs[x][y]
         * x 即为二维数组中的 第 x+1 个一维数组
         * y 即为该一维数组中 第 y+1 个元素
         * 那么我们便可以用for循环嵌套，外层循环遍历一维数组，内层循环遍历该一维数组中的元素
         * */
        for (int x = 0;x < arrs.length;x++){
            for (int y = 0;y < arrs[x].length;y++){
                System.out.print(arrs[x][y] + " "); // 这里不换行 将每个一维数组的元素一行输出
            }
            System.out.println(); // 每个一维数组遍历完后换行
        }
    }

    public void twoArrayTranspose10(){
        /*
        * 1   2   3
        * 4   5   6
        * 7   8   9
        * 10  11  12
        *
        * 转成   就是行变成列 列变成行
        *
        * 1   4   7   10
        * 2   5   8   11
        * 3   6   9   12
        * */
        int arrs1[][] = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        int arrs2[][] = new int[3][4];

        for (int i = 0;i < arrs1.length;i++){
            for (int j = 0;j <arrs1[i].length;j++){
                arrs2[j][i] = arrs1[i][j];
            }
        }
        printTwoArray11(arrs1);
        printTwoArray11(arrs2);
    }

    public static void printTwoArray11(int [][] arrs){
        System.out.print("[");
        for (int i = 0;i < arrs.length;i++){
            if (i != arrs.length-1){
                System.out.print(Arrays.toString(arrs[i])+" ,");
            }
            else{
                System.out.print(Arrays.toString(arrs[i])+"]");
            }
        }
        System.out.println("");
    }


}
