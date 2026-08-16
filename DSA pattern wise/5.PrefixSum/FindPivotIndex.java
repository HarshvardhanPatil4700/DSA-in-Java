// Pivot Index means finding an index where the sum of elements on the left equals the sum of elements on the right.

class FindPivotIndex {
    public static int pivotIndex(int[] nums) {
        // 1. brute force - TC = O(n), SC = O(n)
        // int n = nums.length;
        // int prefix[] = prefixSum(nums);
        // int suffix[] = suffixSum(nums);
        // for(int i=0;i<prefix.length;i++) {
        //     if(prefix[i] == suffix[i]) {
        //         return i;
        //     }
        // }
        // return -1;

        // 2. Prefix sum - TC = O(n), SC = O(1)
        int n = nums.length;
        int left = 0;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        for(int i = 0; i < n; i++) {
            // left += nums[i-1]; 
            int right = sum - left - nums[i];
            
            if(left == right) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }

    // public static int[] prefixSum(int[] arr) {
    //     int n = arr.length;
    //     int prefix[] = new int[n];
    //     for(int i=1;i<n;i++) {
    //         prefix[i] = prefix[i-1] + arr[i-1];
    //     }
    //     return prefix;
    // }

    // public static int[] suffixSum(int[] arr) {
    //     int n = arr.length;
    //     int suffix[] = new int[n];
    //     suffix[n-1] = 0;
    //     for(int i=n-2;i>=0;i--) {
    //         suffix[i] = arr[i+1] + suffix[i+1];
    //     }
    //     return suffix;
    // }

    public static void main(String[] args) {
        int []arr = {1,7,3,6,5,6};
        System.out.println(pivotIndex(arr));

        int []nums = {1,2,3};
        System.out.println(pivotIndex(nums));

        int []numbers = {2,1,-1};
        System.out.println(pivotIndex(numbers));
    }
}
/* left += nums[i-1]; fails for index = 0 as there is no left element for i=0, instead compute left after checking (left == right) so that left is taken as 0 for 0th index and we can also include index = 0 in for loop */