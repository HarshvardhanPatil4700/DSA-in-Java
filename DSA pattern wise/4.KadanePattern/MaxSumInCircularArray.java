// Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
// A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].
// A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

public class MaxSumInCircularArray {
    public static int maxSum(int []arr) {
        int n = arr.length;
        int total = arr[0];
        int minEnding = arr[0], maxEnding = arr[0];
        int maxSum = arr[0], minSum = arr[0];

        for(int i = 1; i < n; i++) {
            total += arr[i];
            maxEnding = Math.max(arr[i], maxEnding + arr[i]);
            maxSum = Math.max(maxSum, maxEnding);

            minEnding = Math.min(arr[i], minEnding + arr[i]);
            minSum = Math.min(minSum, minEnding);            
        }
        if(maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, total - minSum);
    }
    public static void main(String[] args) {
        int []arr = {5,-1,-3,-6,3};
        System.out.println(maxSum(arr));

        int nums[] = {5,-3,5};
        System.out.println(maxSum(nums));

        int []num = {-3,-2,-3};
        System.out.println(maxSum(num));
    }
}
