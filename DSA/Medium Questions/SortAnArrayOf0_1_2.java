public class SortAnArrayOf0_1_2 {
    public static int[] sortArrayOf012 (int arr[]){ 
        // 1. Brute force : use any sorting algo -> TC = O(n logn) SC = O(n)
        // int n = arr.length;

        // // Bubble Sort
        // for (int i = 0; i < n - 1; i++) {
        //     for (int j = 0; j < n - i - 1; j++) {
        //         if (arr[j] > arr[j + 1]) {
        //             // swap
        //             int temp = arr[j];
        //             arr[j] = arr[j + 1];
        //             arr[j + 1] = temp;
        //         }
        //     }
        // }
        
        // return arr;

        // 2. Better soln : TC = O(2n)
        // int count0 = 0, count1 = 0, count2 = 0;
        // for(int i=0;i<arr.length;i++) { // to get the counts of 0's, 1's and 2's
        //     if(arr[i] == 0)
        //         count0++;
        //     else if(arr[i] == 1)
        //         count1++;
        //     else
        //         count2++;
        // }
        
        // // Changing the array :
        // for(int i=0;i<count0;i++){
        //     arr[i] = 0;
        // }
        // for(int i=count0;i<count0+count1;i++){
        //     arr[i] = 1;
        // }
        // for(int i=count0+count1;i<arr.length;i++){
        //     arr[i] = 2;
        // }
        
        // return arr;
        
        // TODO : 3. Optimal sol: Dutch National Flag Algorithm - TC = O(n), SC = O(1) 
        int n = arr.length; 
        int low = 0, mid = 0, high = n-1;
        while(mid <= high) { // until all the array is sorted
            if(arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if (arr[mid] == 1) {
                mid++;
            }
            else {
                swap(arr, mid, high);
                high--;
            }
        }
        
        return arr;
    }
    
    public static void swap(int arr[], int i, int j) {
        // int temp = a; This fails as : swap(arr[i], arr[j]) → NO effect. swap(arr, i, j) → works (Reason → Java pass by value)
        // a = b;
        // b = temp;
        
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // 1 and 2 - brutre force and better soln
        // int arr[] = {0,1,2,0,2,1,2,0,1,0,0,1,2,2};
        // int result[] = sortArrayOf012(arr);
        // for(int n : result) {
        //     System.out.print(n + " ");
        // }

        // 3. Optimal soln (Dutch National Flag Algorithm)
        int arr[] = {0,1,2,0,2,1,2,0,1,0,0,1,2,2};
        int result[] = sortArrayOf012(arr);
        for(int n : result) {
            System.out.print(n + " ");
        }
    }
}

/*
The Dutch National Flag Algorithm (DNF) is an efficient sorting algorithm used to sort an array containing only 3 types of elements (usually 0, 1, 2).

Idea (Simple) - It divides the array into 3 parts:
Left → all 0s
Middle → all 1s
Right → all 2s

How it works - We use 3 pointers:
low → where next 0 should go
mid → current element
high → where next 2 should go */
