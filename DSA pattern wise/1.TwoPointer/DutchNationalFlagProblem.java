// Given an array of n elements where each element is either 0, 1 or 2, the goal is to sort the array such that all 0s come first, followed by 1s and then all 2s without sorting.

public class DutchNationalFlagProblem {
    public static int[] dnfp(int []arr) {
        // 1. brute force : buuble sort - TC = O(n logn) SC = O(n))
        // int n = arr.length;
        // for(int i=0;i<n-1;i++) {
        //     for(int j=0;j<n-2;j++) {
        //         if(arr[j] > arr[j-1]){
        //             int temp = arr[j];
        //             arr[j] = arr[j+1];
        //             arr[j+1] = temp;
        //         }
        //     }
        // }
        // return arr;

        // 2. Better soln : TC = O(n)
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

        // 3. Optimal sol - Two pointer approach (Single pass aproach) - TC = O(n), SC = O(1)
        int n = arr.length;
        int low = 0, mid = 0, high = n-1;
        while(mid <= high) {
            if(arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if(arr[mid] == 1) {
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
        int[] arr = {2,0,2,1,1,0};
        int res[] = dnfp(arr);
        for(int n : res) {
            System.out.print(n + " ");
        }
    }
}