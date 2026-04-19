import java.util.HashMap;

public class CountSubarrayWithGivenSum {
    public static int countSubarrayOfSum(int a[],int k) {
        // 1. Brute force : TC = approx (O(n*3))
        // int cnt = 0; // stores no. of subarrays
        // for(int i=1;i<a.length;i++) {
        //     for(int j=i;j<a.length;j++) {
        //         int sum = 0;

        //         for(int m=i;m<=j;m++) {
        //             sum += a[m];
        //         }
        //         if(sum == k) {
        //             cnt++;
        //         }
        //     }
        // }

        // return cnt;

        // 2. Better Sol : In brute force, Rather than gathering all subarray by using extra for loop of m we can also sum the nos.after each iteration as : TC = approx O(n*2)
        // int cnt = 0;
        // for(int i=0;i<a.length;i++) {
        //     int sum = 0;
        //     for(int j=i;j<a.length;j++) {
        //         sum = sum + a[j];
        //     }
        //     if(sum == k) {
        //         cnt++;
        //     }
        // }
        // return cnt;

        // 3. Optimal sol : Prefix sum - TC = O(n), SC = O(n)
            // Size of the array
            int n = a.length;

            // Map to store frequency of prefix sums
            HashMap<Integer, Integer> prefixSumCount = new HashMap<>();

            // Initialize prefix sum and count of subarrays
            int prefixSum = 0;
            int count = 0;

            // Base case: prefix sum 0 has occurred once
            prefixSumCount.put(0, 1);

            // Traverse through the array
            for (int i = 0; i < n; i++) {
                // Add current element to prefix sum
                prefixSum += a[i];

                // Calculate the prefix sum that needs to be removed
                int remove = prefixSum - k;

                // If this prefix sum has been seen before,
                // add its count to the result
                if (prefixSumCount.containsKey(remove)) {
                    count += prefixSumCount.get(remove);
                }

                // Update the frequency of the current prefix sum
                prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
            }

            // Return the total count of subarrays
            return count;
        }
     
    public static void main(String[] args) {
        int a[] = {1,2,3,-3,1,1,1,4,2,-3};
        int res = countSubarrayOfSum(a, 3);
        System.out.println(res);
    }
}
/*
In this approach, we are going to use the concept of the prefix sum to solve this problem. Here, the prefix sum of a subarray ending at index i simply means the sum of all the elements of that subarray.

Assume, the prefix sum of a subarray ending at index i is x. In that subarray, we will search for another subarray ending at index i, whose sum equals k. Here, we need to observe that if there exists another subarray ending at index i with sum k, then the prefix sum of the rest of the subarray will be x-k. The below image will clarify the concept:

Now, for a subarray ending at index i with the prefix sum x, if we remove the part with the prefix sum x-k, we will be left with the part whose sum is equal to k. And that is what we want. Now, there may exist multiple subarrays with the prefix sum x-k. So, the number of subarrays with sum k that we can generate from the entire subarray ending at index i, is exactly equal to the number of subarrays with the prefix sum x-k, that we can remove from the entire subarray.

That is why, instead of searching the subarrays with sum k, we will keep the occurrence of the prefix sum of the subarrays using a map data structure. 

In the map, we will store every prefix sum calculated, with its occurrence in a <key, value> pair. Now, at index i, we just need to check the map data structure to get the number of times that the subarrays with the prefix sum x-k occur. Then we will simply add that number to our answer.

We will apply the above process for all possible indices of the given array. The possible values of the index i can be from 0 to n-1(where n = size of the array)
First, we will declare a map to store the prefix sums and their counts.
Then, we will set the value of 0 as 1 on the map.
Then we will run a loop(say i) from index 0 to n-1(n = size of the array).
For each index i, we will do the following:
We will add the current element i.e. arr[i] to the prefix sum.
We will calculate the prefix sum i.e. x-k, for which we need the occurrence.
We will add the occurrence of the prefix sum x-k i.e. mpp[x-k] to our answer.
Then we will store the current prefix sum in the map increasing its occurrence by 1.

(V.IMP)Question: Why do we need to set the value of 0?
Let’s understand this using an example. Assume the given array is [3, -3, 1, 1, 1] and k is 3. Now, for index 0, we get the total prefix sum as 3, and k is also 3. So, the prefix sum of the remove-part should be x-k = 3-3 = 0. Now, if the value is not previously set for the key 0 in the map, we will get the default value 0 for the key 0 and we will add 0 to our answer. This will mean that we have not found any subarray with sum 3 till now. But this should not be the case as index 0 itself is a subarray with sum k i.e. 3.
So, in order to avoid this situation we need to set the value of 0 as 1 on the map beforehand. */