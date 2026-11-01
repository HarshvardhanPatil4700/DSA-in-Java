import java.util.*;
public class LongestSubarrayWithSum0 {
    public static int longestSubarrWithSum0(int arr[]) {
        // 1. Brute force : Generate all subarrays and check for maxLength -> TC =O(n*3), SC = O(1)
        // int n = arr.length;
        // int maxLen = 0;
        // for(int i=0;i<n;i++) {
        //     for(int j=i+1;j<n;j++) {
        //         int sum = 0;
        //         for(int k = i;k<=j;k++) {
        //             sum += arr[k];

        //             if(sum == 0) {
        //                 maxLen = Math.max(maxLen, j-i+1);
        //             }
        //         }
        //     }
        // }
        // return maxLen;

        // 2. Better Sol : Prefix sum -> Tc = O(N * log N) {N for traversing the array and log N for hashMap}, Sc = O(N)
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>(); //  map prefix sum -> first index seen (stores prefix sum and index of array)
        int maxLen = 0;
        int sum = 0;

        for(int i=0;i<n;i++) {
            sum += arr[i];

            if(sum == 0) {
                maxLen = i+1;
            } else {
                if(map.get(sum) != null) { // it means the sum we got is present as prefix sum in map
                    maxLen = Math.max(maxLen, i - map.get(sum));
                }else {
                    map.put(sum, i);
                }
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {9, -3, 3, -1, 6, -5}; // o/p = [-3,3,-1,6,5] => maxLen = 5
        int ans = longestSubarrWithSum0(arr);
        System.out.println(ans);
    }
}
