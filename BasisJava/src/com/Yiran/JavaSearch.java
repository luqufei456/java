package com.Yiran;

public class JavaSearch {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8};
        JavaSearch test = new JavaSearch();
        //String text = test.binarySearch(arr,9,0,arr.length-1);
        //System.out.println(text);
    }

    public String binarySearch(int[] arr, int item, int first, int last){
        /**
         二分查找又称折半查找，优点是比较次数少，查找速度快，平均性能好，
         占用系统内存较少；其缺点是要求待查表为有序表，且插入删除困难。
         因此，折半查找方法适用于不经常变动而查找频繁的有序列表。首先，
         假设表中元素是按升序排列，将表中间位置记录的关键字与查找关键字比较，
         如果两者相等，则查找成功；否则利用中间位置记录将表分成前、后两个子表，
         如果中间位置记录的关键字大于查找关键字，则进一步查找前一子表，
         否则进一步查找后一子表。重复以上过程，直到找到满足条件的记录，使查找成功，
         或直到子表不存在为止，此时查找不成功。
         * */
        if (last-first+1 >= 1){ // 相当于将数组分为几部分 为什么+1  因为 索引9-8=1 但是其中有2个元素
            int mid = (first+last)/2;
            if (arr[mid] == item){
                return "找到了，下标为" + mid;
            }
            else if (item < arr[mid]){
                return binarySearch(arr,item,mid,last);
            }
            else{
                return binarySearch(arr,item,first,mid-1);
            }
        }
        return "并没有找到";
    }

}
