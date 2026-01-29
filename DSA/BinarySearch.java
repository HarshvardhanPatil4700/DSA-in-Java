// Binary search is a searching technique that finds an element by repeatedly dividing the sorted array into two halves and comparing the middle element with the key.
// Time Complexity (TC) : 
// Best case: O(1) → element found at middle
// Average case: O(log n)
// Worst case: O(log n)

// Space Complexity (SC) : Iterative binary search: O(1)

public class BinarySearch {
    public static int binarySearch(int numbers[], int key) {
        int start = 0, end = numbers.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            // comparisons
            if(numbers[mid] == key) {
                return mid;
            }
            if(numbers[mid] > key) { // search in 2nd half of array
                end = mid - 1;
            }
            if(numbers[mid] < key) { // search in 1st half of array
                start = mid + 1;
            }
        }
        return -1; // key not found
    }

    public static void main(String[] args) {
        int numbers[] = {2,4,6,8,10,12,14};
        int key = 10;
        System.out.println("index for " + key + " is : " + binarySearch(numbers, key));
        if(binarySearch(numbers, key) == -1) {
            System.out.println(key + " not found in array");
        }
    }
}
