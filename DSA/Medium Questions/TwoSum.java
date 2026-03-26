// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// There are 2 varities : 1) return YES/NO. 2) return [i,j]. (where arr[i]+arr[j] = target)

import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] a, int target) {
        // 1. Brute force : TC = O(n^2) 
        // for(int i=0;i<a.length;i++) {
        //     for(int j=i+1;j<a.length;j++) {;
        //         if(a[i] + a[j] == target) {
        //             // return "Yes";
        //             return new int[]{i,j};
        //         }
        //     }
        // }
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
        
        // TODO : 3. Optimal sol (2 pointer greedy approach) - TC = O(n) + O(n logn), SC = O(1) {ONLY WORK FOR VARIETY 2}
        int left = 0, right = a.length - 1;
        Arrays.sort(a); // sort the array
        while(left < right) {
            int sum = a[left] + a[right];
            if (sum == target) {
                // return "Yes";
                return new int[]{left, right};
            }
            else if(sum < target)
                left++;
            else
                right--;
        }
        
        // return "No";
        return new int[]{-1,-1};        
    }
    public static void main(String[] args) {
        // 1. Brute force :      
        // int a[] = {1,2,3,4,5,6,7,8};
        // int target = 9;
        // // System.out.println(twoSum(a, target)); // FIXME : does not give Output (gives id of array)
        // int result[] = twoSum(a, target);
        // System.out.println(Arrays.toString(result)); // or -> syso(result[0] + " " + result[1]);

        // 2. Better sol : 
        // int a[] = {1,3,2,4,5,3,2,1,1,7};
        // int target = 10;
        // int result[] = twoSum(a, target);
        // System.out.println(Arrays.toString(result));

        // TODO : 3. Optimal sol - TC =  
        int a[] = {1,3,2,4,5,3,2,1,1,7};
        int target = 10;
        int result[] = twoSum(a, target);
        System.out.println(Arrays.toString(result));

    }
}

// TODO : the better soln is Optimal approach for variety 2 i.e return [i,j]