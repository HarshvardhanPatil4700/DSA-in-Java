
public class LongestSubarrayWithSumK {
    public static int longestSubarray(int a[], long k) {
        // 1. Brute force : TC = O(n^3)
        // int len = 0;

        // for (int i = 0; i < a.length; i++) {
        //     for (int j = i; j < a.length; j++) { // generate all the subarrays
        //         int sum = 0;

        //         for (int k = i; k <= j; k++) { // inside all the subarray, compute the sum of all its elements
        //             sum += a[k];
        //         }

        //         if (sum == s) { 
        //             len = Math.max(len, j - i + 1);
        //         }
        //     }
        // }
        
        // return len;

        // 2. Better sol : Hashing - TC = O(n logn) for ordered map and O(n^2) for unordered map. SC = O(n). even works for negative elements
        // HashMap<Long, Integer> preSumMap = new HashMap<>();
        
        // long sum = 0;
        // int maxLen = 0;

        // for (int i = 0; i < a.length; i++) {
        //     sum += a[i];

        //     // case 1: if sum itself equals k
        //     if (sum == k) {
        //         maxLen = Math.max(maxLen, i + 1);
        //     }

        //     // case 2: check if (sum - k) exists
        //     long rem = sum - k;
        //     if (preSumMap.containsKey(rem)) {
        //         int len = i - preSumMap.get(rem);
        //         maxLen = Math.max(maxLen, len);
        //     }

        //     // store prefix sum (only first occurrence)
        //     if (!preSumMap.containsKey(sum)) {
        //         preSumMap.put(sum, i);
        //     }
        // }

        // return maxLen;

        // 3. Optimal Soln : works only for positives and zeroes elements (not for negatives). TC=O(N+N) = O(2N) = O(N),SC = O(1)
        int left = 0, right = 0;
        long sum = a[0];
        int maxLen = 0;
        int n = a.length;
        while(right < n) { // the right pointer is within given array (O(n))
            while(sum > k && left <= right) { // when sum exceeds the req sum then subtract from left side and inc left pointer (this step occurs only for few iterations)
                sum -= a[left];
                left++;
            }
            if(sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
            if (right < n) {
                sum += a[right];
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        // 1. Brute force 
        // int a[] = {1,2,4,5,2,3,4,1,2,3,1,1,6};  
        // System.out.println(longestSubarray(a, 5)); // [3,1,1] => length = 3

        // 2. Better sol : 
        // int[] arr = {1, 2, 3, 1, 1, 1, 1, 4, 2, 3};
        // long k = 3;
        // System.out.println(longestSubarray(arr, k));

        // 3. Optimal sol :
        int[] arr = {1, 0, 2, 3, 1, 1, 1, 1, 4, 2, 3, 0};
        long k = 3;
        System.out.println(longestSubarray(arr, k));
    }
}

/* Total no. of subarrays that can be formed = (n * (n+1)) / 2   ....where n = total no. of ele in arr
 */