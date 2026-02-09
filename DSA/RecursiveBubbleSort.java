import java.util.Scanner;

public class RecursiveBubbleSort {

    public static void bubbleSort(int[] arr, int n) {

      
        if (n == 1) {  // base case: array of size 1 is already sorted
            return;
        }

        // one pass: push largest element to the end
        for (int j = 0; j <= n - 2; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }

        bubbleSort(arr, n - 1); //Recursive call for remaining array bcoz after each pass teh largest element is pushed to last position in bubble sort
    }

    public static void main(String[] args) {
        // int[] arr = {5, 1, 4, 2, 8};
        Scanner s = new Scanner(System.in);
        System.out.print("Enter length of array : ");
        int n = s.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        bubbleSort(arr, n);

        System.out.print("Sorted array : ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
