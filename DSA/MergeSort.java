public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right)  // base case
            return;   

        int mid = left + (right - left) / 2;

        // divide
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        // conquer (merge)
        merge(arr, left, mid, right);
    }

    // merge two sorted halves
    public static void merge(int[] arr, int left, int mid, int right) {

        int[] temp = new int[right - left + 1]; // +1 as index starts from 0, left = 0 right = n-1 arr length = l+r+1
        int i = left;      // pointer for left half
        int j = mid + 1;   // pointer for right half
        int k = 0;         // pointer for temp array

        // compare and merge
        // while (i <= mid && j <= right) {
        //     if (arr[i] <= arr[j]) {
        //         temp[k++] = arr[i++];
        //     } else {
        //         temp[k++] = arr[j++];
        //     }
        // }
        while (i <= mid && j <= right) { // if elements exists
            if (arr[i] <= arr[j]) { // when left part of array has smaller value, Push left part's value in temp array and move pointer(i) forward
                temp[k] = arr[i];
                i++;
            } else { // when right part of array has smaller value, Push right part's value in temp array and move pointer (j) forward
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // copy remaining elements
        // while (i <= mid) temp[k++] = arr[i++];
        // while (j <= right) temp[k++] = arr[j++];
        // copy remaining elements from left half
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        // copy remaining elements from right half
        while (j <= right) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        // copy temp back to original array
        for (int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x];
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 5, 2, 8};

        mergeSort(arr, 0, arr.length - 1);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
