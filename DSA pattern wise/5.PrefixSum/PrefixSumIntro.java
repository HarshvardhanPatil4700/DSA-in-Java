// Prefix Sum is a technique where we maintain the cumulative result of elements from the beginning of the array up to the current index. Core idea -> prefix[i] = prefix[i - 1] + arr[i]
// Suffix Sum is the reverse of prefix sum. It stores the cumulative result of elements from the current index to the end of the array. Core idea -> suffix[i] = arr[i] + suffix[i + 1]

import java.util.Arrays;

public class PrefixSumIntro {
    public static int[] prefixSum(int[] arr) {
        int n = arr.length;
        int prefix[] = new int[n];
        for(int i=1;i<n;i++) {
            prefix[i] = prefix[i-1] + arr[i-1];
        }
        return prefix;
    }

    // We calculate the suffix sum from right to left because each suffix sum depends on the next element's suffix sum.
    // For example: suffix[i] = arr[i] + suffix[i+1], so we must calculate suffix[i+1] first.
    public static int[] suffixSum(int[] arr) {
        int n = arr.length;
        int suffix[] = new int[n];
        suffix[n-1] = 0;
        for(int i=n-2;i>=0;i--) {
            suffix[i] = arr[i+1] + suffix[i+1];
        }
        return suffix;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int[] prefSum = prefixSum(arr);
        System.out.println(Arrays.toString(prefSum));
        int[] suffSum = suffixSum(arr);
        System.out.println(Arrays.toString(suffSum));
    }
}
