
import static java.lang.Integer.max;

public class MaximumProductSubarray {
    public static int maxProduct(int[] arr) {
        // 1. Brute force : Generate all subarrays -TC = O(n^3), SC = O(1)
        // int max_product = Integer.MIN_VALUE;
        // for(int i=0;i<arr.length;i++) {
        //     for(int j=i;j<arr.length;j++) {
        //         int product = 1;
        //         for(int k=i;k<=j;k++) {
        //             product = product * arr[k];
        //         }
        //         max_product = Math.max(max_product, product); 
        //     }
        // }
        // return max_product;

        // 2. Better sol - TC = O(n^2), SC = O(1)
        // int max_product = Integer.MIN_VALUE;
        // for(int i=0;i<arr.length;i++) {
        //     int product = 1;
        //     for(int j=i;j<arr.length;j++) {
        //         product = product * arr[j];    
        //         max_product = Math.max(max_product, product); 
        //     }
        // }
        // return max_product;

        // 3. Optimal approach 1 - TC = O(n), SC = O(1)
        // It includes 3 observations : 1) All positives 2) Even negatives and rest are positive 3) Odd negatives and rest are positive 4) it has zeroes
        int prefix = 1, suffix = 1;
        int n = arr.length;
        int maximum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            // if prefix or suffix becomes 0 then reinitialize it and continue for remaining elements
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;

            prefix = prefix * arr[i];
            suffix = suffix * arr[n-i-1];

            maximum = Math.max(maximum, max(prefix,suffix));
        } 

        return maximum;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        int maxProd = maxProduct(nums);
        System.out.println(maxProd); 
    }
}
