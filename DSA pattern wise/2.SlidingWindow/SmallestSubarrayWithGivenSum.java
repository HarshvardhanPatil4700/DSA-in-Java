// Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

public class SmallestSubarrayWithGivenSum {
    public static int minSubArrayLen(int arr[], int target) {
        // 1. Brute force : TC = O(n^2), SC = O(1)
        // int n = arr.length;
        // int minLen = Integer.MAX_VALUE;
        // for(int i=0;i<n;i++) {
        //     int sum = 0;
        //     for(int j=i;j<n;j++) {
        //         sum += arr[j];
        //         if(sum >= target) {                    
        //             minLen = Math.min(minLen, j-i+1);
        //             break; // once you've found the shortest valid subarray starting at index i, there's no point checking longer ones.
        //         }
        //     }
        // }
        // return (minLen == Integer.MAX_VALUE) ? 0 : minLen; // If target is not meet, return 0

        // 2. Optimal sol - Sliding window (Dynamic) - TC = O(n), SC = O(1)
        int n = arr.length;
        int minLen = Integer.MAX_VALUE;
        int left = 0; 
        int sum = 0;

        for(int right = 0; right < n; right++) {
            sum += arr[right];

            // Check if sum is >= target and shrink window such that condition is meet in lowest subarray
            while(sum >= target) {
                // int currLen = right - left + 1;
                // minLen = Math.min(minLen, currLen);
                minLen = Math.min(minLen, right-left+1);
                sum = sum - arr[left];
                left++;
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
    public static void main(String[] args) {
        int nums[] = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(nums, 7));

        int n[] = {1,4,4};
        System.out.println(minSubArrayLen(n, 4));

        int numbers[] = {1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen(numbers, 11));
    }
}
