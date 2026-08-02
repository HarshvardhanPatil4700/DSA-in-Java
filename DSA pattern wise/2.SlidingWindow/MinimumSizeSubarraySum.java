// Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] arr) {
        int n = arr.length;
        int low = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        for(int high = 0; high < n; high++) {
            sum += arr[high];
            
            while(sum >= target) {
                minLen = Math.min(minLen, high-low+1);
                // continue to find more smaller subarray if any
                sum -= arr[low];
                low++;
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }

    public static void main(String[] args) {
        int nums[] = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));

        int n[] = {1,4,4};
        System.out.println(minSubArrayLen(4, n));

        int numbers[] = {1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen(11, numbers));
    }
}
