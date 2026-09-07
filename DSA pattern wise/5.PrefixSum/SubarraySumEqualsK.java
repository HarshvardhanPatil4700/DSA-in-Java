// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
// A subarray is a contiguous non-empty sequence of elements within an array.

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] arr, int k) {
        // 1. brute force - TC = O(n^2), SC = O(1)
        // int cnt = 0;
        // for(int i=0;i<arr.length;i++) {
        //     int sum = 0;
        //     for(int j=i;j<arr.length;j++) {
        //         sum += arr[j];

        //         if(sum == k) {
        //             cnt++;
        //         }
        //     }
        // }
        // return cnt;

        // 2. Prefix sum - 
        int n = arr.length;
        int prefSum = 0;
        int cnt = 0;
        HashMap<Integer,Integer> freq = new HashMap<>(); // to store answer for question : prefixSum → how many times we have seen it
        freq.put(0, 1);// Because there is one empty prefix before the array starts whose sum is 0. Hence, to handle subarrays that start from index 0.

        for(int i = 0; i < n; i++) {
            prefSum += arr[i];
            int remove = prefSum - k;
            cnt += freq.getOrDefault(remove, 0);
            freq.put(prefSum, freq.getOrDefault(prefSum, 0) + 1);
        }
        return cnt;
    }
    public static void main(String[] args) {
        int []arr = {1,2,3};
        System.out.println(subarraySum(arr, 3));
        int []arr1 = {1,2,3};
        System.out.println(subarraySum(arr1, 3));
        int []arr2 = {1,2,3,-3,1,1,1,4,2,-3};
        System.out.println(subarraySum(arr2,3));
    }
}