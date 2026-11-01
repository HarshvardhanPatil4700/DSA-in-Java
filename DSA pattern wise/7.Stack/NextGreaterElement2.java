// Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
// The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

import java.util.Arrays;

public class NextGreaterElement2 {
    public static int[] nextGreaterElements(int[] nums) {
    //     // 1. Brute force to find previous greater element:
    //     int prevGreater;
    //     for(int i=0;i<nums.length;i++) {
    //         prevGreater = -1;
    //         for(int j=0;j<i-1;j++) {
    //             if(nums[j] > nums[i]) {
    //                 prevGreater = nums[j];
    //                 break;
    //             }
    //         }
    //     }
    //     return prevGreater;

        // 2. Brute force to find Next Greater: TC = 
        // int[] nextGreater = new int[nums.length];
        // for(int i=0;i<nums.length;i++) {
        //     nextGreater[i] = -1;
        //     for(int j=i+1;j<nums.length;j++) {
        //         if(nums[j] > nums[i]) {
        //             nextGreater[i] = nums[j];
        //             break;
        //         }
        //     }
        // }
        // return nextGreater;

        
        
    }
    public static void main(String[] args) {
        int[] nums = {6,0,8,1,3};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}
