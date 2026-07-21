

public class SquareOfSortedArray {
    public static int[] squareOfArr(int []arr) {
        // 1. Brute force - TC = O(n)+O(nlogn) = O(n logn), SC = O(n)
        // int n = arr.length;
        // int []ans = new int[n];
        // for(int i=0;i<n;i++){
        //     ans[i] = arr[i] * arr[i];
        // }
        // Arrays.sort(ans);

        // return ans;

        // 2. Optimal approach - Two pointer approach : TC = O(n), SC = O(n)
        int n = arr.length;
        int ans[] = new int[n];

        int left =0,right =n-1;
        int ind = n-1;

        while(left <= right) {
            if(Math.abs(arr[left]) > Math.abs(arr[right])) {
                ans[ind] = arr[left] * arr[left];
                left++;
            }
            else {
                ans[ind] = arr[right] * arr[right];
                right--;
            }
            ind--;
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {-4,-1,2,3,7,9};
        int ans [] = squareOfArr(nums);
        for(int n : ans) {
            System.out.print(n + " ");
        }
    }
}