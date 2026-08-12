// You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr).
// Return the maximum absolute sum of any (possibly empty) subarray of nums.
// Note that abs(x) is defined as follows: If x is a negative integer, then abs(x) = -x. If x is a non-negative integer, then abs(x) = x

public class MaxAbsoluteSumOfSubarray {
    public static int maxAbsSumOfSubarr(int []arr) {
        // Kadane's Pattern - TC = O(n), SC = O(1)
        int maxEnd = 0, minEnd = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;

        for(int num : arr) {
            // Maximum subarray sum ending here
            maxEnd = Math.max(0, maxEnd + num);
            // Minimum subarray sum ending here
            minEnd = Math.min(0, minEnd + num);

            maxSum = Math.max(maxSum, maxEnd);
            minSum = Math.min(minSum, minEnd);
        }
        return Math.max(Math.abs(maxSum), Math.abs(minSum));
    }
    public static void main(String[] args) {
        int []arr = {1,-3,2,3,-4};
        System.out.println(maxAbsSumOfSubarr(arr)); // [2,3]

        int nums[] = {2,-5,1,-4,3,-2};
        System.out.println(maxAbsSumOfSubarr(nums)); // [-5, 1, -4] = -8 => abs(-8) = 8
    }
}
