package com.yiran4.exam;

public class Test4{
    public String printMinNumer(int[] nums){
        String str = "";
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                int a = Integer.valueOf(nums[i] + "" + nums[j]);
                int b = Integer.valueOf(nums[j] + "" + nums[i]);
                if (a > b){
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            str += String.valueOf(nums[i]);
        }
        return str;
    }
}
