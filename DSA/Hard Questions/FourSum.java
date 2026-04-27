// // 4-sum : Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that: 0 <= a, b, c, d < n  
// a, b, c, and d are distinct. (a!=b!=c!=d)
// nums[a] + nums[b] + nums[c] + nums[d] == target
// You may return the answer in any order.

import java.util.*;

public class FourSum {
    public static List<List<Integer>> fourSum(int arr[],int target) {
        // 1. Brute force : TC = O(N*4) approx, SC = O(2 * no. of the unique triplets) as we are using a set data structure and a list to store the triplets.
        // int n = arr.length;
        // Set<List<Integer>> set = new HashSet<>();

        // for(int i=0;i<n;i++) {
        //     for(int j =i+1;j<n;j++) {
        //         for(int k =j+1;k<n;k++) {
        //             for(int l =k+1;l<n;l++) {
        //                 long sum = (long) arr[i] + arr[j] + arr[k] + arr[l];

        //                 if(sum == target) {
        //                     List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
        //                     Collections.sort(temp);
        //                     set.add(temp);
        //                 }
        //             }
        //         }
        //     }
        // }
        // return new ArrayList<>(set);

        // 2. Better sol : TC = O(N*3 x log(no.of elements in set)), SC = O(2 * no. of the quadruplets)+O(N)
        // int n = arr.length;
        // Set<List<Integer>> set = new HashSet<>();

        // for(int i=0;i<n;i++) {
        //     for(int j =i+1;j<n;j++) {
        //         HashSet<Integer> seen = new HashSet<>();
        //         for(int k =j+1;k<n;k++) {
        //             long sum = (long) arr[i] + arr[j] + arr[k];
        //             long fourth = (long) target - sum; // Eg: {1,0,-1,0} -> we got first 3 elements i.e 1,0,-1 to get 4th one => target = 0 -> target - sum = 0 - (1+0+-1) = 0-0 = 0
        //             if(seen.contains((int) fourth)){
        //                 List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k], (int) fourth);
        //                 Collections.sort(temp);
        //                 set.add(temp);
        //             }
        //             seen.add(arr[k]); // Add current third number into set
        //         }
        //     }
        // }
        // return new ArrayList<>(set);

        // 3. Optimal sol : TC = O(N*3), SC = O(no. of quadruplets)
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(arr);
        for(int i=0;i<n;i++) {
            if(i>0 && arr[i] == arr[i-1]) continue; // to skip the duplicates
            for(int j=i+1;j<n;j++) {
                if(j != i+1 && arr[j] == arr[j-1]) continue;
                int k = j+1;
                int l = n-1;
                while(k < l) {
                    long sum = (long) arr[i]+arr[j]+arr[k]+arr[l];

                    if(sum == target) {
                        // List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                        // ans.add(temp);
                        ans.add(Arrays.asList(arr[i], arr[j],arr[k], arr[l]));
                        k++;
                        l--;
                        while(k < l && arr[k] == arr[k-1]) k++;
                        while(k < l && arr[l] == arr[l+1]) l--;
                    }
                    else if (sum < target) k++;
                    else l--;
                }
            }
        }

        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        int target = 0;

        List<List<Integer>> ans = fourSum(arr, target);
        
        for (List<Integer> quad : ans) {
            System.out.println(quad);
        }
    }
}