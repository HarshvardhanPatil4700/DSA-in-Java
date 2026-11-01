
public class RemoveDuplicatesFromArray {
    public static void rd(int arr[],int n) {
        // Optimal : 2 pointer solution - Works only for SORTED array
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }

        // Print only unique elements
        for (int k = 0; k <= i; k++) {
            System.out.print(arr[k] + " ");
        }

        System.out.println("\ntotal non duplicate numbers = " + (i + 1));
    }

    public static void main(String[] args) {
        // Brute force : TC = O(N logN + N) , SC = O(N)
        // int arr[] = {1,1,2,2,2,3,3,3};
        // Set<Integer> nums = new HashSet<>();
        // for (int n : arr) {
        //     nums.add(n);
        // }
        // System.out.println(nums);        
        
        // int index = 0;
        // for(int iter : nums) {
        //     arr[index] = iter;
        //     index++;
        // }
        // System.out.println("total non duplicate numbers = " + index);

        // Optimal : 2 pointer solution - TC : O(N), SC = O(1)
        int arr[] = {1,1,2,2,2,3,3};
        int n = arr.length;
        rd(arr, n);
    }
}