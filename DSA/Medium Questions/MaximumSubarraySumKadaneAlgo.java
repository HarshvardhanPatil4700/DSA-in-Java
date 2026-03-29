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
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        int start = 0, ansStart = -1, ansEnd = -1;

        for (int i = 0; i < a.length; i++) { // iterate through array
            // If sum is 0 it means start of new subarray
            if (currSum == 0) {
                start = i;
            }

            currSum += a[i];

            // if subarray sum is greater than maxSum then set currSum as maxSum
            if (currSum > maxSum) {
                maxSum = currSum;
                ansStart = start;
                ansEnd = i;
            }

            // If sum of any subarray is negative then ignore that subarray and set its sum as 0 
            if (currSum < 0) {
                currSum = 0;
            }

            // OR : {USE THIS WHEN ONLY THE SUM IS NEEDED AND THE START AND END INDEX OF SUBARRAY IS NOT NEEDED}
            // currSum += a[i];
            // maxSum = currSum > maxSum ? currSum : maxSum;
            // currSum = currSum < 0 ? 0 : currSum;
        }

        // Printing the subarray which has maximum sum :
        System.out.print("Subarray from index " + ansStart + " to " + ansEnd + " = ");
        for(int i=ansStart;i<=ansEnd;i++) {
            System.out.print(a[i] + ", ");
        }

        return maxSum;
    }
    
    public static void main(String[] args) {
        int a[] = {3,-4,5,4,-1,7,-8};
        System.out.println(maxSubarraySum(a));
    }
}

/*
Note : in this problem there are 2 varieties of problem :
1. Return the maxSum 
2. Return the subarray along with its maxSum
 */