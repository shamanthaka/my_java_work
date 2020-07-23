package com.shamanthaka.mine;

public class MyArrayEg {

    public static void main(String[] args) {
        int[] nums = new int[10];

        int count = 100;

        for(int i = 0; i < nums.length; i++){
            nums[i] = count + i;
        }

        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}
