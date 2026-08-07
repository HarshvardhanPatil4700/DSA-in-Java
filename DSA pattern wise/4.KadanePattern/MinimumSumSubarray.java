// Given an array arr[], find the sub-array containing at least one number which has the minimum sum and return its sum.

public class MinimumSumSubarray {
    public static int minSumSubarr(int []arr) {
        // Kadane Pattern - TC = O(n), SC = O(1)
        int n = arr.length;
        int bestEnding = arr[0];
        int minSum = arr[0];

        for(int i=1;i<n;i++) {
            int bestEndingSum = bestEnding + arr[i];
            int self = arr[i];
            bestEnding = Math.min(bestEndingSum, self);
            minSum = Math.min(minSum, bestEnding);
        }
        return minSum;
    }
    public static void main(String[] args) {
        int arr[] = {3,-4, 2,-3,-1, 7,-5};
        System.out.println(minSumSubarr(arr));

        int a[] = {2, 6, 8, 1, 4};
        System.out.println(minSumSubarr(a));

        int num[] = {1};
        System.out.println(minSumSubarr(num));
    }
}
