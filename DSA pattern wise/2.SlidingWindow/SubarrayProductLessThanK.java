// Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

public class SubarrayProductLessThanK {
    public static int numSubarrayProductLessThanK(int[] arr, int k) {
        int n = arr.length;
        int ans = 0;
        int left = 0;
        int prod = 1;

        for (int right = 0; right < n; right++) {

            prod *= arr[right];

            while (prod >= k && left <= right) {
                prod /= arr[left];
                left++;
            }

            ans = ans + (right - left + 1);
        }

        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {10,5,2,6};
        System.out.println(numSubarrayProductLessThanK(arr, 100));
    }
}