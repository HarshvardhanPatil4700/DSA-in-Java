// Quick Sort is a divide-and-conquer sorting algorithm that works by picking a pivot element and placing it in its correct position, such that: elements smaller than pivot go to the left and elements greater than pivot go to the right. Then the same process is recursively applied to left and right parts.

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1); // sort left part
            quickSort(arr, pivotIndex + 1, high); // sort right part
        }
    }

    public static int partition(int[] arr, int low, int high) { // partition using last element as pivot

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // place pivot in correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        int[] arr = {10, 7, 8, 9, 1, 5};

        quickSort(arr, 0, arr.length - 1);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
