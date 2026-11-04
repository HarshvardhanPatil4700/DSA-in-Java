
public class RemoveDuplicatesFromArray {
    public static int rd(int arr[],int n) {
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

        // Optimal : 2 pointer solution - Works only for SORTED array
        // int i = 0;
        // for (int j = 1; j < n; j++) {
        //     if (arr[i] != arr[j]) {
        //         i++;
        //         arr[i] = arr[j];
        //     }
        // }

        int left = 0, right = 1;
        while(right < n) {
            if(arr[right] != arr[right - 1]) {
                left++;
                arr[left] = arr[right];
            }
            right++;
        }

        // Print only unique elements
        for (int k = 0; k <= left; k++) {
            System.out.print(arr[k] + " ");
        }

        System.out.println("\ntotal non duplicate numbers = " + (left + 1));

        return left+1;
    }

    public static void main(String[] args) {
        // Optimal : 2 pointer solution - TC : O(N), SC = O(1)
        int arr[] = {1,1,2,2,2,3,3};
        int n = arr.length;
        rd(arr, n);
    }
}