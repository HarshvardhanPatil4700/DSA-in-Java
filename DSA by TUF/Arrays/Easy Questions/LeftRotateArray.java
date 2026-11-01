public class LeftRotateArray {
    // TODO : Left rotate the array by 1 place 
    public static int[] leftRotateby1(int arr[],int n) {
        int temp = arr[0];
        for(int i = 1; i < n; i++) {
            arr[i-1] = arr[i];
        }
        arr[n-1] = temp;

        return arr;
    }

    // TODO : Left rotate the array by n places 
    // 1. Brute force approach : TC = O(d) + O(n-d) + O(d) = O(n+d)
    // public static void leftRotatebyK(int arr[],int n, int d) {
    //     d = d % n; // because when we rotate array by n(no. of element) times then it gives back teh same array

    //     int temp[] = new int[d];
    //     for(int i = 0;i < d;i++) {
    //         temp[i] = arr[i];
    //     }
    //     for(int i = d;i<n; i++) {
    //         arr[i-d] = arr[i];
    //     }
    //     for(int i=n-d;i<n;i++) {
    //         arr[i] = temp[i-(n-d)];
    //     }
    //     for(int k : arr) {
    //         System.out.print(k + " ");
    //     }
    // }

    // 2. Optimal approach :
    public static void rotateLeft(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // because when we rotate array by n(no. of element) times then it gives back teh same array

        // reverse(nums, 0, n - 1); 
        // reverse(nums, 0, k - 1);
        // reverse(nums, k, n - 1);

        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        reverse(nums, 0, n - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            // swap start and end until start < end (basically, reverse the numbers)
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // TODO : Right rotate the array by k places :
    public static void rotateRight(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) return;

        k = k % n;   // handle k > n

        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }
    
    public static void main(String[] args) {
        // TODO : Left rotate the array by 1 place 
        int arr[] = {0,1,2,3,4};
        int n = arr.length;
        System.out.print("Before : ");
        for(int a : arr) {
            System.out.print(a + " ");
        }
        leftRotateby1(arr, n);
        System.out.print("\nAfter : ");
        for(int a : arr) {
            System.out.print(a + " ");
        }

        // TODO : Left rotate the array by n places 
        // 1. brute force
        // int ar[] = {2,4,6,8,10}; 
        // System.out.print("\nBefore : ");
        // for(int a : ar) {
        //     System.out.print(a + " ");
        // }
        // int d = 3;
        // System.out.print("\nAfter : ");
        // leftRotatebyK(ar, n, d);

        // 2. optimal approach : 
        int a[] = {1,2,3,4,5,6,7};
        int k = 3; 
        System.out.print("\nBefore : ");
        for(int i : a) {
            System.out.print(i + " ");
        }
        rotateLeft(a, k);
        System.out.print("\nAfter : ");
        for(int i : a) {
            System.out.print(i + " ");
        }

        // 
        int numbers[] = {1,2,3,4,5,6,7,8};
        int d = 3; 
        System.out.print("\nBefore : ");
        for(int i : numbers) {
            System.out.print(i + " ");
        }
        rotateRight(numbers, d);
        System.out.print("\nAfter : ");
        for(int i : numbers) {
            System.out.print(i + " ");
        }
    }
}
