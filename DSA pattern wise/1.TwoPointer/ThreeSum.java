
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> triplets(int []arr) {
        // 1. Brute force : TC = O(n^3)
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
        // return new ArrayList<>(st);

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

        // 3. 2 pointer sol :
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<n-2;i++) {
            if(i > 0 && arr[i] == arr[i-1]) continue;
            int left = i+1, right = n-1;
            int sum = -1 * arr[i];

            while(left < right) {
                int add = arr[left] + arr[right];
                if(add == sum) {
                    ans.add(Arrays.asList(arr[i], arr[left],arr[right]));
                    left++;
                    right--;
                    while(left < n && arr[left] == arr[left-1]) {
                        left++;
                    }
                    while(right >= 0 && arr[right] == arr[right+1]) {
                        right--;
                    }
                }
                else if(add < sum) {
                    left++;
                }else {
                    right--;
                }
            }
        }
        return ans;
    }

    public static int threeSumClosest(int []nums,int target) {
        
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                // Update answer if this sum is closer
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                if (sum == target) {
                    return sum;        // Exact match
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    } 
    public static void main(String[] args) {
        int nums[] = {-1,0,1,2,-1,4};
        List<List<Integer>> ans = triplets(nums);
        for(List<Integer> list : ans) {
            for(int n : list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }

        int min = threeSumClosest(nums, 1);
        System.out.println(min);
    }
}
