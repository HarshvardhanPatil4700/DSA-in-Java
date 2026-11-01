// Selection Sort
// Steps :
// 1.Divide array into sorted and unsorted parts
// 2.Repeatedly find the minimum element from the unsorted part
// 3.Swap it with the first unsorted position

// TC : O(n^2) for best,avg,worst case

import java.util.Scanner;

public class SelectionSort {
    
    public static void selectionSort(int arr[], int n) {
        for(int i = 0; i <= n-2; i++) {
            int min = i;
            for(int j = i+1; j <= n-1; j++) { // we already assume as min = i, So, no need to compare again with i hence we used i+1
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    } 

    public static void selectionSortDesc(int arr[], int n) {
        for(int i = 0; i <= n-2; i++) {
            int max = i;
            for(int j = i+1; j <= n-1; j++) { // we already assume as min = i, So, no need to compare again with i hence we used i+1
                if(arr[j] > arr[max]) {
                    max = j;
                }
            }
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
        }
    } 
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter length of array : ");
        int n = s.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of array : ");
        for(int i=0;i< n;i++) {
            arr[i] = s.nextInt();
        }
        
        selectionSort(arr, n);
        System.out.print("Sorted array : ");
        for(int x : arr) {
            System.out.print(x + " ");
        }
        
        selectionSortDesc(arr, n);
        System.out.print("\nSorted array : ");
        for(int x : arr) {
            System.out.print(x + " ");
        }

    }
}
// loop runs till n-2 because when second last element is placed correctly, the last element is automatically sorted, So no need to run for i = n-1 (no comparisons left)