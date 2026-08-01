// Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
// Example 1:
// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// Output: 6
// Explanation: [1,1,1,0,0,1,1,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

public class LongestSubarrayWithOnesAfterReplacement {
    public static int longestSubstringWithOnes(int []arr,int k) {
        int n =arr.length;
        int low = 0;
        int zeroCnt = 0;
        int maxLen = Integer.MIN_VALUE;
        
        for(int high=0;high<n;high++) {
            if(arr[high] == 0)
                zeroCnt++;

            while(zeroCnt > k) {
                if(arr[low]  == 0) {
                    zeroCnt--;
                }
                low++;
            }
            int currLen = high- low + 1; // Updated length of window after shrink
            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestSubstringWithOnes(nums, 2)); // 11100011110 -> 11101111110 => 6

        int num[] = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestSubstringWithOnes(num, 3));
    }
}
