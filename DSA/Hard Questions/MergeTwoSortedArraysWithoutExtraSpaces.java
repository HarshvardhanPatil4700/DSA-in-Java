
import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpaces {
    public static int[] merge2SortedArrays(int[] arr1, int []arr2) {
        // 1. Brute force : TC = First loop: at most n + m iterations total.Remaining loops: process leftover elements.Total operations = n + m, SC = O(n+m) for new array i.e arr3 of size n+m
        int n = arr1.length;
        int m = arr2.length;
        int[] arr3 = new int[n+m]; 
        int left = 0;
        int right = 0;
        int index = 0;

        while(left < n && right < m) { // until there are elements in left or right array
            if(arr1[left] < arr2[right]) {
                arr3[index] = arr1[left];
                left++; index++;
            }
            else {
                arr3[index] = arr2[right];
                right++; index++;
            }
        }

        // if left or right elements are exhausted (traversed completely) the there are 2 cases :
        // 1. Case 1 : there are still some elements present in arr1 -
        while(left < n) {
            // arr3[index] = arr1[left];
            // left++; index++;
            arr3[index++] = arr1[left++];
        } 
        // 2. Case 2 : there are still some elements present in arr2 -
        while(right < m) {
            arr3[index++] = arr2[right++];
        } 

        for(int i=0;i<n+m;i++) {
            if(i < n) 
                arr1[i] = arr3[i]; // takes n iteration and moves i from 0 to n
            else 
                arr2[i - n] = arr3[i]; // takes m iterations and mokes i from n to n+m so we declare index as i-n
        }

        return arr3;
    }

    // 2. Optimal approach : TC = O(min(n,m)) because at worst case it will travel until any of array gets exhausted + O(n logm) to sort arr1 + O(m logn) to sort arr2. SC = O(1)
    public static void merge2ArraysOptimalApp(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int left = n-1; // points to last element of arr1
        int right = 0; // points to first ele of arr2
        
        while(left >= 0 && right < m) {
            if(arr1[left] >= arr2[right]) {
                // swap both the elements :
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;

                left--; right++;
            }
            else {
                break; //because the rest of elements are in correct order as both arrays are sorted
            }
        }
        Arrays.sort(arr1);        
        Arrays.sort(arr2); 
    }

    public static void main(String[] args) {
        // int[] nums1 = {1, 3, 5};
        // int[] nums2 = {2, 4, 6};
        // int[] res = merge2SortedArrays(nums1, nums2);
        // for(int i : nums1){
        //     System.out.print(i + " ");
        // }
        // for(int j : nums2){
        //     System.out.print(j + " ");
        // }

        // Optimal approach :
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6};
        System.out.println("Before : ");
        for(int i : nums1){
            System.out.print(i + " ");
        }
        System.out.println();
        for(int j : nums2){
            System.out.print(j + " ");
        }
        System.out.println();

        merge2ArraysOptimalApp(nums1, nums2);
        
        System.out.println("After : ");
        for(int i : nums1){
            System.out.print(i + " ");
        }
        System.out.println();
        for(int j : nums2){
            System.out.print(j + " ");
        }
    }
}
