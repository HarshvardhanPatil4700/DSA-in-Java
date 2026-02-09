import java.util.Scanner;

public class InsertionSort {
    public static void insertionSort(int arr[],int n) {
        for(int i = 0; i <= n-1; i++) {
            int j = i;
            while(j > 0 && arr[j-1] > arr[j]) { // j > 0 bcoz if j = 0 then,it has not arr[j-1] 
                // swap
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;

                j--; // to keep moving left until it reaches the correct position
            }
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
        
        insertionSort(arr, n);

        System.out.print("Sorted array : ");
        for(int x : arr) {
            System.out.print(x + " ");
        }

        // Kth smallest term : first sort the array using sorting algo. and then print(arr[k-1]) to get kth smallest term.
        System.out.print("\nEnter k : ");
        int k = s.nextInt();
        System.out.println("Kth smallest term is : " + arr[k-1]);
        // Kth largest term : first sort the array using sorting algo. in descending order and then print(arr[k-1]) to get kth largest term.
    }
}
