// Problem statement - Given the sorted rotated array nums of unique elements, return the minimum element of this array.

public class MinimumInRotatedSortedArray {
    public static int minInRotatedSortedArr(int[] arr) {
        // 1. Brute force - TC = O(n)
        // int mini = Integer.MAX_VALUE;
        // int n = arr.length;
        // for(int i=0;i<n;i++) {
        //     mini = Math.min(mini, arr[i]);
        // }
        // return mini;

        // 2. Binary search - TC = O(log n)
        int n = arr.length;
        int low = 0, high = n-1;
        int ans = Integer.MAX_VALUE;

        while(low <= high) {
            int mid = (low + high) / 2;

            // OPTIMIZATION : if search space (i.e half) is already sorted thenalways the arr[low] will be smallest (minimum) value in that search space, So there is no need to perform binary searcg just directly compare arr[low] with ans as -
            if(arr[low] <= arr[high]) {
                ans = Math.min(ans, arr[low]);
                break;
            }

            // Identify which half is sorted, compare the lowest values of half with ans and then eliminate that half
            if(arr[low] <= arr[mid]) {
                ans = Math.min(ans, arr[low]); // If left half is sorted, compare the arr[low] with ans to get minimum (as the low has minimum value of all elements in left half)
                low = mid + 1; // eliminate the left half
            }
            else {
                ans = Math.min(ans,arr[mid]); // If right half is sorted, compare the arr[mid] with ans to get minimum (as the mid has minimum value of all elements in right half)
                high = mid-1; // eliminate the right half
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2,3};
        System.out.println(minInRotatedSortedArr(nums));
    }
}
