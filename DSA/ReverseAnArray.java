public class ReverseAnArray {
    public static void reverse(int nums[]) {
        int first = 0, last = nums.length - 1;
        while(first < last) { // stop when pointers cross
            // swaping methods:
            // 1. using temp
            // int temp = nums[last];
            // nums[last] = nums[first];
            // nums[first] = temp;

            // 2. Swap without temp (Addition–Subtraction)
            // nums[first] = nums[first] + nums[last];
            // nums[last] = nums[first] - nums[last];
            // nums[first] = nums[first] - nums[last];

            // 3. Swap without temp (XOR method)
            nums[first] = nums[first] ^ nums[last];
            nums[last] = nums[first] ^ nums[last];
            nums[first] = nums[first] ^ nums[last];
        
            first++; // first pointer moves to next index 
            last--; // last pointer moves to preceding index
        }
    }
    public static void main(String[] args) {
        // int nums[] = {2,4,6,8,10};
        // for(int i = nums.length-1; i >= 0; i--) {
        //     System.out.print(nums[i] + " ");
        // } in this case, T.C is O(n) - we have to traverse complete array , S.C - O(n) as we make new array of same size 

        int nums[] = {2,4,6,8,10};
        System.out.print("before : ");
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        reverse(nums);
        System.out.print("\nafter : ");
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }       
        // in this case, T.C = O(n/2) = O(n), S.C = O(1)
    }
}