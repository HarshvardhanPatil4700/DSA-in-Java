import java.util.Scanner;

public class LargestElementOfArray {
    // public static void quickSort(int[] arr, int low, int high) {

    //     if (low < high) {

    //         int pivotIndex = partition(arr, low, high);

    //         quickSort(arr, low, pivotIndex - 1); // sort left part
    //         quickSort(arr, pivotIndex + 1, high); // sort right part
    //     }
    // }

    // public static int partition(int[] arr, int low, int high) { // partition using last element as pivot

    //     int pivot = arr[high];
    //     int i = low - 1;

    //     for (int j = low; j < high; j++) {
    //         if (arr[j] < pivot) {
    //             i++;

    //             // swap arr[i] and arr[j]
    //             int temp = arr[i];
    //             arr[i] = arr[j];
    //             arr[j] = temp;
    //         }
    //     }

    //     // place pivot in correct position
    //     int temp = arr[i + 1];
    //     arr[i + 1] = arr[high];
    //     arr[high] = temp;

    //     return i + 1;
    // }

    public static int largestEle(int a[],int n) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            if(a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static int secondLargest(int a[],int n) {
        int largest = a[0];
        int secLargest = -1; // or secLargest = Integer.MIN_VALUE;
        for(int i = 1; i< a.length;i++) {
            if(a[i] > largest) {
                secLargest = largest;
                largest = a[i];
            }
            else if(a[i] < largest && a[i] > secLargest) {
                secLargest = a[i];
            }
        }
        return secLargest;
    }

    public static int secondSmallest(int a[],int n) {
        int smallest = a[0];
        int secSmallest = Integer.MAX_VALUE; // or secLargest = Integer.MIN
        for(int i = 1; i< a.length;i++) {
            if(a[i] < smallest) {
                secSmallest = smallest;
                smallest = a[i];
            }
            else if(a[i] != smallest && a[i] < secSmallest) {
                secSmallest = a[i];
            }
        }
        return secSmallest;
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // TODO : 1. Largest element of array : 
        // Bruteforce - Sort the elements and return the last element [TC = O(N logN)]
        // int a[] = {1,2,4,5,7,8,3};
        // quickSort(a, 0, a.length-1);
        // System.out.println("Largest element: " + a[a.length - 1]);

        // Optimal : TC = O(N) 
        System.out.print("Enter the length of array : ");
        int n = s.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of array : ");
        for(int i = 0; i < n;i++){ 
            arr[i] = s.nextInt();
        }
        System.out.println("Largest Element of array is : " + largestEle(arr, n));

        // TODO : 2. Second largest element of array : (Commonly asked question)
        // Brute-force : Sort the elements and run if loop to get the second largest ele (TC = N logN + N)
        // int a[] = {1,4,2,3,5,7,3,7,2};
        // quickSort(a, 0, a.length-1);
        // // System.out.println("Second largest  = " + a[a.length-2]); WRONG : as we can have the largest number occuring multiple times
        // int largest = a[a.length-1]; // largest element of array
        // int secondLargest;
        // for(int i = n-2; i>=0;i--) {
        //     if(a[i] != largest) {
        //         secondLargest = a[i];
        //     }
        // } 
        // System.out.println("Second largest = " + secondLargest);

        // Better : take 2 pases - first pass to get the largest element,declare secondL = -1 and then run second pass to get the second largest element (where, the secondL must not be equal to largest) {TC = O(2*N)}

        // Optimal : TC = O(N)
        System.out.print("Enter length of array : ");
        int n1 = s.nextInt();
        int a[] = new int[n];
        System.out.println("Enter the elements of array : ");
        for(int i=0;i<n1;i++) {
            a[i] = s.nextInt();
        }

        System.out.println("Second Largest = " + secondLargest(a, n1));
        System.out.println("Second Smallest = " + secondSmallest(a, n1));
    }
}
