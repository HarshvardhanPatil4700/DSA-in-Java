// 3 sum -> Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int arr[]) {
        // Brute force : TC =O(N3 * log(no. of unique triplets)), Sc=O(2 * no. of the unique triplets)
        // Set<List<Integer>> st = new HashSet<>(); // A set to store unique triplets (unique lists of 3 numbers)

        // int n = arr.length;
        // for(int i=0;i<n;i++) {
        //     for(int j=i+1;j<n;j++) {
        //         for(int k=j+1;k<n;k++) {
        //             if(arr[i] + arr[j] + arr[k] == 0) {
        //                 List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k]);
        //                 Collections.sort(temp); // sort bcoz : [-1,2,-1] and [-1,-1,2] both triplets yeild 0 but we need to store only one of them so sorting makes the list [-1,2,-1] as => [-1,-1,2] and so Set keeps only unique lists
        //                 st.add(temp);
        //             }
        //         }
        //     }
        // }
        // return new ArrayList<>(st); // converts set to List

        // 2. Better sol : Tc = O(n^2 * logM) = O(n^2) Sc = O(n) + O(no.of triplets) * 2
        // Set<List<Integer>> ans = new HashSet<>();
        // int n = arr.length;

        // for(int i=0;i<n;i++) {
        //     Set<Integer> hashset = new HashSet<>();
        //     for(int j=i+1;j<n;j++) {
        //         int third = -(arr[i] + arr[j]);
        //         if(hashset.contains(third)) { // found a triplet
        //             List<Integer> temp = Arrays.asList(arr[i],arr[j],third);
        //             Collections.sort(temp);
        //             ans.add(temp);
        //         } 

        //         hashset.add(arr[j]); // Add current element to set
        //     }
        // }
        // return new ArrayList<>(ans);

        // 3. Optimal Sol : 2-Pointer approach
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            // Two pointers
            int left = i + 1, right = n - 1;

            // Find pairs for current arr[i]
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) {
                    ans.add(Arrays.asList(arr[i], arr[left], arr[right])); // no need to sort ans the main array is sorted 
                    left++;
                    right--;

                    while (left < right && arr[left] == arr[left - 1]) left++; // Skip duplicates for left
                    while (left < right && arr[right] == arr[right + 1]) right--; // Skip duplicates for right
                }
                else if (sum < 0) left++;
                else right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(arr);

        for (List<Integer> triplet : res) {
            for (int num : triplet) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
/*For Optimal Approach :
Time Complexity: O(NlogN)+O(N2), as The pointer i, is running for approximately N times. And both the pointers j and k combined can run for approximately N times including the operation of skipping duplicates. So the total time complexity will be O(N2). 

Space Complexity: O(no. of quadruplets), This space is only used to store the answer. We are not using any extra space to solve this problem. So, from that perspective, space complexity can be written as O(1). */