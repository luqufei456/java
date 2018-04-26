package com.Yiran;

import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args){
        ArraySort arrTest = new ArraySort();
        int[] arr = {54,26,93,17,77,31,44,55,20};
        //System.out.println(Arrays.toString(arrTest.bubbleSort(arr)));
        //System.out.println(Arrays.toString(arrTest.selectSort(arr)));
        //System.out.println(Arrays.toString(arrTest.insertSort(arr)));
        //quickSort(arr,0,8);
        //System.out.println(Arrays.toString(arr));
        //System.out.println(Arrays.toString(mergeSort1(arr,0,arr.length-1)));
    }

    // 冒泡排序
    public int[] bubbleSort(int[] arr){
        /**
         * 冒泡排序算法的运作如下：（从后往前）
         * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
         * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
         * 针对所有的元素重复以上的步骤，除了最后一个。
         * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
         * */
        for (int i = 0;i < arr.length-2;i++){ // n个元素 只有n-1个需要与后一个元素比较 最后一个元素不需要比较
            // i 控制循环次数
            int count = 0;
            for (int j = 0;j < arr.length-1-i;j++){ // 把大的元素放到后面 相当于后面一部分是一个有序数组
                if (arr[j] > arr[j+1]){
                    int replace = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = replace;
                    count += 1;
                }
            }
            if (count == 0){
                return arr;
            }
        }
        return arr;
    }

    // 选择排序
    public int[] selectSort(int[] arr){
        /**
         * 选择排序（Selection sort）是一种简单直观的排序算法。
         * 它的工作原理是每一次从待排序的数据元素中选出最小（或最大）的一个元素，
         * 存放在序列的起始位置，直到全部待排序的数据元素排完。
         * 选择排序是不稳定的排序方法（比如序列[5， 5， 3]
         * 第一次就将第一个[5]与[3]交换，导致第一个5挪动到第二个5后面）。
         * */
        int x = 0;
        for (int i = 0;i <arr.length-1;i++){ // 一共有n个 那么就要比较n-1次留下的一个就是最大的不用比较 下标为0
            int minIndex = i; // 定义用于比较的元素为最小值的下标  不能定义值，否则不是在改变数组 而是改变该变量
            for (int j = 1 + i;j < arr.length;j++){ // 定义第i个为最小 就要用第i+1个来和第i个比较
                if (arr[j] < arr[minIndex] ){
                    int replace = arr[minIndex];
                    arr[minIndex] = arr[j];
                    arr[j] = replace;
                }
            }
        }
        return arr;
    }

    // 插入排序
    public int[] insertSort(int[] arr){
        /**
         * 有一个已经有序的数据序列，要求在这个已经排好的数据序列中插入一个数，
         * 但要求插入后此数据序列仍然有序，这个时候就要用到一种新的排序方法——插入排序法,
         * 插入排序的基本操作就是将一个数据插入到已经排好序的有序数据中，
         * 从而得到一个新的、个数加一的有序数据，算法适用于少量数据的排序，时间复杂度为O(n^2)。
         * 是稳定的排序方法。插入算法把要排序的数组分成两部分：第一部分包含了这个数组的所有元素，
         * 但将最后一个元素除外（让数组多一个空间才有插入的位置），
         * 而第二部分就只包含这一个元素（即待插入元素）。在第一部分排序完成后，
         * 再将这个最后元素插入到已排好序的第一部分中。
         * 插入排序的基本思想是：每步将一个待排序的记录，
         * 按其关键码值的大小插入前面已经排序的文件中适当位置上，直到全部插入完为止。
         *
         * 插入排序和选择排序的区别在于 同样是将一个列表分为两部分
         * 插入排序从后面的部分抽取一个与前面比较大小并排序
         * 而选择排序是在后面排序完了放到前面
         * */
        for (int i = 1;i < arr.length;i++){
            int j = i; // 这个地方不能直接用 i 因为之后有对 j 的修改 如果影响了 i值 循环会出问题
            // 内层循环代表的是 执行从右边的无序序列中取第一个即i位置然后和左边的有序序列进行比较的过程
            while (j > 0){ // 当i-1=0时，说明已经与前部比较完了
                if (arr[j] < arr[j-1]){
                    int replace = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = replace;
                    j -= 1;
                }
                else{ // 因为前部是有序的，如果比前部大或者相等，代表数组有序
                    break; // 这个地方为什么不能用return  因为要跳出的是while循环 而不是for循环
                }
            }
        }
        return arr;
    }

    public int[] shellSort(int[] arr){
        /**
         希尔排序(Shell's Sort)是插入排序的一种又称“缩小增量排序”（Diminshing Increment Sort），
         是直接插入排序算法的一种更高效的改进版本。
         希尔排序是非稳定排序算法。
         比如有一个列表 54 26 93 17 77 31 44 55 20  取排序步长gap=4
                      54          77
                         26          31
                            93          44
                               17          55
                                              20
         然后将分成的多个组进行比较排序 最后得到一个新列表
         20 26 44 17 54 31 93 55 77  取排序步长gap=2
         20    44    54    93    77
         26    17    31    55
         然后将分成的多个组进行比较排序 最后得到一个新列表
         20 17 44 26 54 31 77 55 93  取排序步长gap=1 相当于进行插入排序
         最后得到一个排序完的列表

         * */
        int gap = arr.length/2; // 步长
        while (gap >= 1){ // 因为步长为1时要进行一轮插入排序
            for (int j = gap;j < arr.length;j++){ // 用后面的与前面的做比较 需要用到最后一个
                int i = j;
                while (i-gap >= 0){ // 不能直接用i 否则会索引越界 i-gap=0时相当于第一个元素比较
                    if (arr[i] < arr[i-gap]){
                        int replace = arr[i];
                        arr[i] = arr[i-gap];
                        arr[i-gap] = replace;
                        i -= gap; // 减去步长
                    }
                    else{
                        break;
                    }
                }
            }
            gap =  gap/2; // 步长减半
        }
        return arr;
    }

    public static void quickSort(int[] arr,int first,int last){
        /**
         快排原理：
         在要排的数（比如数组A）中选择一个中心值key（比如A[0]），
         通过一趟排序将数组A分成两部分，其中以key为中心，key右边都比key大，key左边的都key小，
         然后对这两部分分别重复这个过程，直到整个有序。

         整个快排的过程就简化为了一趟排序的过程，然后递归调用就行了。
         一趟排序的方法：
         1，定义i=0，j=A.lenght-1，i为第一个数的下标，j为最后一个数下标
         2，从数组的最后一个数Aj从右往左找，找到第一小于key的数，记为Aj；
         3，从数组的第一个数Ai 从左往右找，找到第一个大于key的数，记为Ai；
         4，交换Ai 和Aj
         5，重复这个过程，直到 i=j
         6，调整key的位置，把A[i] 和key交换
         假设要排的数组为：A[8] ={ 5 2 8 9 2 3 4 9 }
         选择 key = 5， 开始时 i=0，j=7
         index       0    1    2    3    4    5    6    7

         开始：     5    2    8    9    2    3    4    9
                   i                                  j
         第一次找   5    2    8    9    2    3    4    9
                             i                   j
         交换：     5    2    4    9    2    3    8    9
                             i                   j
         第二次找   5    2    4    9    2    3    8    9
                                  i         j
         交换：     5    2    4    3    2    9    8    9
                                  i         j
         第三次找   5    2    4    3    2    9    8    9
                                       ij
         调整key：  2    5    4    3    5    9    8    9
                                       ij
         * */
        if (first >= last){ // 起始坐标大于等于终止坐标时，代表不需要排序 终止
            return;
        }
        int midValue = arr[first]; // 定义一个中间值，这个值放在当2个下标相遇时的中间
        int low = first; // 定义起始下标
        int high = last; // 定义末尾下标
        while (low < high){
            while (low < high && arr[high] >= midValue){ // low < high 防止在循环中错过
                high--; // 下标向左移一位
            }
            //arr[low] = arr[high]; //
            while (low < high && arr[low] < midValue){
                low++; // 下标向右移一位
            }
            int replace1 = arr[low]; // 交换两下标所指的值 这时候 arr[low] >= midValue  arr[high] < midValue
            arr[low] = arr[high]; // 最后 low = high时 不影响
            arr[high] = replace1;
        }
        int replace2 = arr[low]; // 将中间值与 arr[low]交换 因为此时 midValue 成为了真的中间值
        arr[low] = midValue; // 至于 此时的 arr[low] 在左边不一定是最小的 无关紧要
        arr[first] = replace2; // 要点是 midValue 左边的元素都比它小  右边的都比它大  递归来达到排序的效果

        // 递归调用 将原数组分为两段 不计已经排好的中间值
        quickSort(arr,first,low - 1);
        quickSort(arr,low + 1,last);
    }

    public static int[] mergeSort1(int[] arr, int low, int high){
        /**
         分而治之(divide - conquer);每个递归过程涉及三个步骤
         第一, 分解: 把待排序的 n 个元素的序列分解成两个子序列, 每个子序列包括 n/2 个元素.
         第二, 治理: 对每个子序列分别调用归并排序MergeSort, 进行递归操作
         第三, 合并: 合并两个排好序的子序列,生成排序结果.

         数组    6 5 3 1 8 7 2 4

         第一步  6 5 3 1    8 7 2 4 分成2组
         第二步  6 5    3 1    8 7    2 4 分成4组
         第三步  6   5   3   1   8   7   2   4 分成单个元素
         第四步  5 6    1 3    7 8    2 4 合成4组#弄两个下标left right然后小的在前 大的在后 分别指向要合并的2组
         第四步  1 3 5 6    2 4 7 8
         第五步  1 2 3 4 5 6 7 8
         * */
        int mid = (low+high)/2; // 定义中间索引
        if (low < high){ // low>=high时不需要拆分
            mergeSort1(arr,low,mid); // 这里的下标会取到 所以下面的+1
            mergeSort1(arr,mid+1,high);

            // 左右归并
            mergeSort2(arr,low,mid,high);
        }
        return arr;

    }

    public static void mergeSort2(int[] arr,int low, int mid, int high){
        int[] temp = new int[high-low+1]; // 定义一个新数组 长度为 low - high 中元素的个数
        int i = low; // 这里就是下标1
        int j = mid + 1; // 这里就是下标2  分别对应2个要合并的数组的第一位元素
        int k = 0;
        // 将较小的数先移到新数组中
        while (i<=mid && j<=high){
            if (arr[i] < arr[j]){
                temp[k++] = arr[i++];
            }
            else {
                temp[k++] = arr[j++];
            }
        }
        // 将左边剩余的数移入数组  元素放进新数组后 下标才会右移，所以 如果 i<=mid 不成立 说明左边的都移完了
        while (i<=mid){
            temp[k++] = arr[i++];
        }
        // 将右边剩余的数移入数组  这两个while循环只会运行一个 否则方法中的第一个while循环出不来
        while (j<=high){
            temp[k++] = arr[j++];
        }
        for (int x=0;x<temp.length;x++){
            arr[x+low] = temp[x];
        }
    }

}
