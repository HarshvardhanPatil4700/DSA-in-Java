// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
// There is only one repeated number in nums, return this repeated number.
// You must solve the problem without modifying the array nums and using only constant extra space.

public class FindDuplicateNumber {
    public static int findDuplicate(int[] arr) {
        // 1. Brute force - TC = O(n^2), SC = O(1)
        // for(int i=0;i<arr.length;i++) {
        //     for(int j=i+1;j<arr.length;j++) {
        //         if(arr[i] == arr[j]) {
        //             return arr[i];
        //         }
        //     }
        // }
        // return -1;

        // 2. Better sol : HashSet - TC=O(n), SC=O(1)
        // HashSet<Integer> set = new HashSet<>();
        // for(int i=0;i<arr.length;i++) {
        //     if(set.contains(arr[i])) {
        //         return arr[i];
        //     }
        //     set.add(arr[i]);
        // }
        // return -1;

        // 3. Optimal Sol - Slow and Fast pointers (Floyd's Cycle Detection) - TC = O(n), SC = O(1)
        int slow = 0, fast = 0;
        // find meeting point
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        // find the start of cycle 
        slow = 0;
        while(slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int nums[] = {1,3,2,4,2};
        System.out.println(findDuplicate(nums));

        int num[] = {3,1,3,4,2};
        System.out.println(findDuplicate(num));

        int n[] = {3,3,3,3,3};
        System.out.println(findDuplicate(n));
    }
}
