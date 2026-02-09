import java.util.Scanner;

public class BubbleSort {
    public static void bubbleSort(int arr[], int n) {
        for(int i = n-1;i>=0;i--){
            int didSwap = 0;
            for(int j=0; j<=i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    didSwap = 1; // swapping performed(array is unsorted)
                }
            }
            if(didSwap == 0) { // array is sorted (no swaps required)
                break;
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
        
        bubbleSort(arr, n);

        System.out.print("Sorted array : ");
        for(int x : arr) {
            System.out.print(x + " ");
        }
    }
}
/* Bubble Sort is a simple comparison-based sorting algorithm where adjacent elements are compared and swapped if they are in the wrong order. With each pass, the largest element “bubbles up” to the end of the array.
Logic : 
first run from 0 to n-1 then 0 to n-2 then 0 to n-3 and so on...
we can see that, the every pass the n-i decreases */