// There are 2 types of questions asked in this type -
// 1. return the numbers present in array - Two pointer works for both sorted and unsorted case
// 2. return the indexes of array - Two pointer works only if the array is sorted.If not, then we cannot use 2 pointer approach

import java.util.Arrays;

public class TwoSum {
    // 1. Brute force : TC = O(n^2) 
    // for(int i=0;i<a.length;i++) {
    //     for(int j=i+1;j<a.length;j++) {;
    //         if(a[i] + a[j] == target) {
    //             // return "Yes"; // VARIETY 1
    //             return new int[]{i,j}; // VARIETY 2
    //         }
    //     }
    // }
    // // return "No";
    // return new int[]{-1,-1}; // no such elements found in array

    // 2. Better sol : Hashing - TC = O(n) + O(n) = O(2n) = O(n), SC = O(n) {OPTIMAL APPROACH FOR VARIETY 2}
    // HashMap<Integer,Integer> hash = new HashMap<>();

    // // store all elements - O(n)
    // for(int i=0;i<a.length;i++) {
    //     hash.put(a[i],i); 
    // }

    // // check for complement - O(n)
    // for (int i = 0; i < a.length; i++) {
    //     int complement = target - a[i];

    //     if (hash.containsKey(complement) && hash.get(complement) != i) { // checks if the elements exists in hash and also checks that you are not using same index twice
    //         // return "YES";
    //         return new int[]{i, hash.get(complement)};
    //     }
    // }

    // // return "NO";
    // return new int[]{-1, -1}; 

    // 3. Optimal Approach - 2 pointer approach - TC = O(n logn) for sorting + O(n) for traversing
    // Type 1 - return numbers
    public static int[] twoSum(int arr[],int target) {
        int n = arr.length;
        
        Arrays.sort(arr); // sort the array 

        int i = 0, j = n-1;
        while(i < j) {
            int sum = arr[i] + arr[j];

            if(sum == target) {
                return new int[]{arr[i],arr[j]}; // arr[i] + arr[j] = target
            }
            else if(sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{-1,-1}; // Not found
    }

    // Type 2 - return indexes
    public static int[] twoSumIndexes(int arr[],int target) {
        int n = arr.length;

        int i = 0, j = n-1;
        while(i < j) {
            int sum = arr[i] + arr[j];

            if(sum == target) {
                return new int[]{i,j}; // arr[i] + arr[j] = target
            }
            else if(sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int a[] = {1,3,2,4,5,3,2,1,1,7};
        int target = 10;
        int result[] = twoSum(a, target);
        System.out.println(Arrays.toString(result));
        int res[] = twoSumIndexes(a, target);
        System.out.println(Arrays.toString(res));
    }
}