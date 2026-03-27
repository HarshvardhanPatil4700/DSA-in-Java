public class MaximumSubarraySumKadaneAlgo {
    public static int maxSubarraySum (int a[]) {
        // 1. Brute force - Tc = O(n^3)
        // int maxi = Integer.MIN_VALUE; // not 0 as there can be negative nos. in array 
        // for (int i = 0; i < a.length; i++) {
        //     for (int j = i; j < a.length; j++) { // generate all the subarrays
        //         int sum = 0;

        //         for (int k = i; k <= j; k++) { // inside all the subarray, compute the sum of all its elements
        //             sum += a[k];
        //             maxi = Math.max(sum, maxi);
        //         }
        //     }
        // }
        
        // return maxi;

        // 2. Better sol : TC = O(n^2)
        // int maxi = Integer.MIN_VALUE;
        // for(int i=0;i<a.length;i++) {
        //     int sum = 0;
        //     for(int j=i;j<a.length;j++) {
        //         sum += a[j];
        //         maxi = Math.max(sum, maxi);
        //     }
        // }
        // return maxi;

        // TODO : 3. Optimal sol : Kadane's Algorithm - TC = 
        long maxi = Long.MIN_VALUE;
        long sum = 0;
        for(int i=0;i<a.length;i++) {
            sum = sum + a[i];

            if(sum > maxi) {
                maxi = sum;
            }
            if(sum < 0) {
                sum = 0;
            }
        }

        return maxi;
    }
    public static void main(String[] args) {
        
    }
}
