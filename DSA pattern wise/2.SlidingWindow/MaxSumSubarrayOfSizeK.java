public class MaxSumSubarrayOfSizeK {
    public static int maxSumSubarray(int arr[],int k) {
        // 1. Brute force : TC = O(n^2), SC = O(1)
        // int n = arr.length;
        // int maxSum = Integer.MIN_VALUE;
        // for(int i=0;i<=n-k;i++) { // generates all the subarray
        //     int currSum = 0;
        //     for(int j=i;j<i+k;j++) { // sum of current window
        //         currSum += arr[j];
        //     }
        //     maxSum = Math.max(currSum, maxSum);
        // }
        // return maxSum;

        // Optimal sol - Sliding Window - TC = O(n), SC = O(1)
        int n = arr.length;
        if(k <= 0 || k > n) return 0; // edge-cases
            
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;

        // sum of first window
        for(int i=0;i<k;i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        // slide the window
        for(int i=k;i<n;i++) {
            windowSum = windowSum + arr[i] - arr[i-k];
            maxSum = Math.max(windowSum, maxSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int nums[] = {2, 1, 5, 1, 3, 2};
        System.out.println(maxSumSubarray(nums, 3));
        
        int numbers[] = {};
        System.out.println(maxSumSubarray(numbers, 2));

        int num[] = {100,200,300,400};
        System.out.println(maxSumSubarray(num, 5));
    }
}