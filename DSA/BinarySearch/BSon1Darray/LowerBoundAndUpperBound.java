public class LowerBoundAndUpperBound {
    public static int lowerBound(int[] arr,int x) { // used to solve the Search Insert problem
        // // 1. Brute force - Linear search : TC = O(n)
        // for(int i=0;i<arr.length;i++) {
        //     if(arr[i] >= x) {
        //         return i;
        //     }
        // }
        // return arr.length; // lower bound doesn't exist (Hypothetical index)

        // 2. Binary search - TC = O(log2 n)
        int n = arr.length;
        int low = 0, high = n-1;
        int ans = n; // even if we dont get the LB in array LB is set to Hypothetical index

        while(low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] >= x) { // may be an answer (search in left half)
                ans = mid;
                high = mid - 1;
            } 
            else {  // arr[mid] < x (search in right half)
                low = mid + 1;
            }

        }
        return ans;
    }

    public static int upperBound(int[] arr,int x) {
        // // 1. Brute force - Linear search : TC = O(n)
        // for(int i=0;i<arr.length;i++) {
        //     if(arr[i] > x) {
        //         return i;
        //     }
        // }
        // return arr.length; // lower bound doesn't exist (Hypothetical index)

        // 2. Binary search - TC = O(log2 n)
        int n = arr.length;
        int low = 0, high = n-1;
        int ans = n; // even if we dont get the LB in array LB is set to Hypothetical index

        while(low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] > x) { // may be an answer (search in left half)
                ans = mid;
                high = mid - 1;
            } 
            else {  // arr[mid] < x (search in right half)
                low = mid + 1;
            }

        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4,7,8,9,9,9,11};
        int lb = lowerBound(nums, 5);
        System.out.println(lb);
        System.out.println(lowerBound(nums, 9)); // it selects the lowest index for lb
        System.out.println(lowerBound(nums, 13)); // return hypothetical index  
        
        int ub = upperBound(nums, 6);
        System.out.println(ub);
        System.out.println(upperBound(nums, 8)); // returns smallest index of multiple indexes
        System.out.println(upperBound(nums, 11)); // Hypothetical index
        System.out.println(upperBound(nums, 0)); 
    }
}
