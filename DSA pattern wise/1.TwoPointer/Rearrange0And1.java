// Given an array arr[] consisting of only 0's and 1's. Modify the array in-place to segregate 0s onto the left side and 1s onto the right side of the array.

public class Rearrange0And1 {
    public static int[] rearrange0sAnd1s(int []arr) {
        // 2 pointer approach - TC = O(n), SC = O(1)
        int n = arr.length;
        int left = 0, right = n-1;
        while(left < right) {
            while(left < right && arr[left] == 0 ) { // preserve the 0's present in left side
                left++;
            }
            while(left < right && arr[right] == 1 ) { // preserve the 1's present in right side
                right--;
            }
            if(left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        int ans[] = rearrange0sAnd1s(arr);
        for(int n : ans) {
            System.out.print(n + " ");
        }
    }
}
