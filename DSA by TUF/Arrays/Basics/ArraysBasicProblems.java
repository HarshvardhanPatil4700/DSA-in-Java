import java.util.ArrayList;
import java.util.Arrays;

public class ArraysBasicProblems {
    // 1. Sum of array elements:
    public static int sumOfElements(int[] arr) {
        int sum = 0;
        // for(int i=0;i<arr.length;i++) {
        //     sum+=arr[i];
        // }
        for(int nums : arr) {
            sum += nums;
        }
        return sum;
    }

    // 2. Count of odd and even numbers in array:
    public static void countOfOddEvenEles(int[] arr) {
        int evenCnt = 0, oddCnt = 0;
        ArrayList<Integer> evenEles = new ArrayList<>();
        ArrayList<Integer> oddEles = new ArrayList<>();
        int i=0,j=0;
        for(int num : arr) {
            if(num % 2 == 0) {
                evenEles.add(num);
                evenCnt++;
            } 
            else {
                oddEles.add(num);
                oddCnt++;
            }
        }
        // return new int[]{evenCnt, oddCnt};
        System.out.println("Even elements: " + evenEles);
        System.out.println("Odd elements: " + oddEles);
        System.out.println("Even Count: " + evenCnt + ", Odd Count: " + oddCnt);
    }

    // 3. Check if Array is Sorted - 1:
    public static boolean isSorted(int[] arr) {
        for(int i=1;i<arr.length;i++) {
            if(arr[i] < arr[i-1]) {
                return false;
            }
        }
        return true;
    }

    // 4. Reverse an Array:
    public static void reverseArray(int[] arr) {
        // Brute force: TC = O(n), SC = O(1)
        // int n = arr.length;
        // int[] temp = new int[n];

        // int j = 0;

        // // Store elements in reverse order
        // for (int i = n - 1; i >= 0; i--) {
        //     temp[j++] = arr[i];
        // }

        // // Copy reversed elements back
        // for (int i = 0; i < n; i++) {
        //     arr[i] = temp[i];
        // }

        // optimal sol: Two pointers : TC: O(n)), SC: O(1) — in-place reversal.
        System.out.println("Before: " + Arrays.toString(arr));
        int left = 0, right = arr.length-1;
        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
        System.out.println("After: " + Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        System.out.println(sumOfElements(nums));
        countOfOddEvenEles(nums);
        System.out.println(isSorted(nums));
        reverseArray(nums);
    }
}
