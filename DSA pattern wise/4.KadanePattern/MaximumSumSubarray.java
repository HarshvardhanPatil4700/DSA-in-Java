public class MaximumSumSubarray {
    public static int maxSumSubarr(int[] arr) {
        // 1. brute force - TC = O(n^3), SC = O(1)
        // int n = arr.length;
        // int maxSum = Integer.MIN_VALUE;
        // for(int i=0;i<n;i++) {
        //     for(int j=i;j<n;j++) {
        //         int sum = 0;
        //         for(int k=i;k<=j;k++) {
        //             sum = sum + arr[k];
        //         }
        //         maxSum = Math.max(maxSum, sum);
        //     }
        // }
        // return maxSum;

        // 2. better sol - TC = O(n^2), SC = O(1)
        // int n = arr.length;
        // int maxSum = Integer.MIN_VALUE;
        // for(int i=0;i<n;i++) {
        //     int sum = 0;
        //     for(int j=i;j<n;j++) {
        //         sum = sum + arr[j];                
        //         maxSum = Math.max(maxSum, sum);
        //     }
        // }
        // return maxSum;

        // 3. optimal sol - Kadane's pattern : TC = O(n), SC = O(1)
        int n = arr.length;
        int bestEnding = arr[0];
        int ans = arr[0];

        for(int i=1;i<n;i++) {
            int bestEndingSum = bestEnding + arr[i];
            int self = arr[i];
            bestEnding = Math.max(bestEndingSum, self);
            ans = Math.max(ans, bestEnding);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSumSubarr(arr));

        int []a = {1};
        System.out.println(maxSumSubarr(a));

        int []nums = {5,4,-1,7,8};
        System.out.println(maxSumSubarr(nums));
        
    }
}