// public class RecursiveInsertionSort {
//     public static void insertionSort(int arr[],int n) {
//         if(n <= 1) // base case: single element is already sorted
//             return;

//         for(int i = 0; i <= n-1; i++) {
//             int j = i;
//             while(j > 0 && arr[j-1] > arr[j]) { // j > 0 bcoz if j = 0 then,it has not arr[j-1] 
//                 // swap
//                 int temp = arr[j];
//                 arr[j] = arr[j-1];
//                 arr[j-1] = temp;

//                 j--; // to keep moving left until it reaches the correct position
//             }
//         }

//         insertionSort(arr, n-1);
//     }
        
//     public static void main(String[] args) {
//         int[] arr = {5, 2, 4, 6, 1, 3};

//         insertionSort(arr, arr.length);

//         for (int x : arr) {
//             System.out.print(x + " ");
//         }
//     }
// }

class RecursiveInsertionSort {

    public static void insertionSort(int[] arr, int n) {
        if (n <= 1) { // base case: single element is already sorted
            return;
        }

        // sort first n-1 elements
        insertionSort(arr, n - 1);

        // insert last element at its correct position
        int last = arr[n - 1];
        int j = n - 2;

        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = last;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 6, 1, 3};

        insertionSort(arr, arr.length);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
