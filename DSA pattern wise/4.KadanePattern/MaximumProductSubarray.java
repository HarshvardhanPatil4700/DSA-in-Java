public class MaximumProductSubarray {
    public static int maxProdSubarr(int []arr) {
        // Kadane pattern -  TC = O(n), SC = O(1)
        int n = arr.length;
        int minBestEnding = arr[0];
        int maxBestEnding = arr[0];
        int maxProd = arr[0];

        for(int i = 1; i < n; i++) {
            int self = arr[i];
            int a = minBestEnding * arr[i]; // if arr[i] is negative number
            int b = maxBestEnding * arr[i]; // if arr[i] is positive number

            maxBestEnding = Math.max(self, Math.max(a, b)); // compares a and b first and then compares self and max of a and b
            minBestEnding = Math.min(self, Math.min(a, b));
            maxProd = Math.max(maxProd, Math.max(maxBestEnding, minBestEnding));            
        }
        return maxProd;
    }
    public static void main(String[] args) {
        int arr[] = {2,3,-2,4};
        System.out.println(maxProdSubarr(arr));

        int nums[] = {-2,0,-1};
        System.out.println(maxProdSubarr(nums));

        int a[] = {1};
        System.out.println(maxProdSubarr(a));
    }
}