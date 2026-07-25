// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

public class MoveZeroes {
    public static int[] moveZero(int []arr) {
        // Two pointer approach - TC = O(n), SC = O(1)
        int n = arr.length;
        int left = 0;

        for(int right = 0;right < n; right++) {
            if(arr[right]!=0) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int []arr ={0,1,0,3,12};
        int []ans = moveZero(arr);
        for(int n : ans) {
            System.out.print(n + " ");
        }
    }
}
