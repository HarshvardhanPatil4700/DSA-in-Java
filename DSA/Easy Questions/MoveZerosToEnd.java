public class MoveZerosToEnd {
    public static void zerosToEnd(int arr[],int n) {
        // 1. Brute force : TC = O(N) + O(no. of nonZeros) + O(no.of Zeros) = O(2N), SC = O(n) (no zero in array)
        // int[] temp = new int[n];
        // int idx = 0;

        // for (int i = 0; i < n; i++) { // Step 1: copy non-zero elements
        //     if (nums[i] != 0) {
        //         temp[idx] = nums[i];
        //         idx++;
        //     }
        // }

        // for(int i=0;i<temp.length;i++) { // Step 2: Copying temp (i.e non zeros) to the original array
        //     nums[i] = temp[i];
        // }

        // int numberOfNonZeros = temp.length;
        // for (int i = numberOfNonZeros; i < n; i++) { // Step 3: copy back to original array 
        //     nums[i] = 0;
        // }

        // for(int i : nums) { // Printing the array
        //     System.out.print(i + " ");
        // }

        // 2. Optimal solution : Move the zero to end while iterating (2 pointer approach). TC = O(N), SC = O(1) no extra space as we used the given array only
        int j = -1;
        for(int i=0; i<n; i++) {
            if(arr[i] == 0) {
                j = i; // if zero is encounterd, mark the position as j and iterate array using i
                break;
            }
        }

        for(int i = j+1; i<n; i++){
            if(arr[i] != 0) { // if next number to zero i.e 'i' is non zero then swap else (i.e if next num is also zero) then move to next num (i++)
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                j++;
            }
        }
    }
    public static void main(String[] args) {
        int nums[] = {1,2,3,0,0,4,0,5,0};
        int n = nums.length;
        System.out.print("Before : ");
        for(int i  : nums) {
            System.out.print(i + " ");
        }
        zerosToEnd(nums, n);
        System.out.print("\n After : ");
        for(int i  : nums) {
            System.out.print(i + " ");
        }
    }
}