// Description : Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

import java.util.HashMap;

public class SubarrSumDivisibleByK { 
    // Optimal sol : PREFIX SUM - TC = O(n), SC = O(n)
    public static int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        int prefSum = 0;
        HashMap<Integer,Integer> freq = new HashMap();
        freq.put(0, 1);

        for(int i=0;i<n;i++) {
            prefSum += nums[i];
            int rem = prefSum % k;
            if(rem < 0) {
                rem = rem + k;
            }
            cnt += freq.getOrDefault(rem, 0);
            freq.put(rem, freq.getOrDefault(rem, 0) + 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;
        System.out.println(subarraysDivByK(nums, k));
        int arr[] = {5};
        System.out.println(subarraysDivByK(arr, 5));
    }
}
