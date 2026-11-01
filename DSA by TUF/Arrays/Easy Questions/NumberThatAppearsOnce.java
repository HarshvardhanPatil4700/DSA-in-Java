// Finding a number that appers once, and other numbers twice 

public class NumberThatAppearsOnce {
    public static int numberThatAppearsOnce(int nums[]) {
        // 1. Brute force :
        // for (int i = 0; i < nums.length; i++) {
        //     int number = nums[i];
        //     int cnt = 0; // reset for each element

        //     for (int j = 0; j < nums.length; j++) {
        //         if (nums[j] == number) {
        //             cnt++;
        //         }
        //     }

        //     if (cnt == 1) {
        //         return number; // found unique element
        //     }
        // }

        // return -1; // if no unique element found

        // 2. Better Sol :- Hashing. TC = O(n), SC = O(maxi)
        // int maxi = nums[0];
        // for(int i = 0; i<nums.length;i++) {
        //     maxi = Math.max(maxi,nums[i]);
        // }

        // int hash[] = new int[maxi+1];
        // for(int i=0;i<nums.length;i++) {
        //     hash[nums[i]]++;
        // }

        // for(int i=0;i<nums.length;i++) {
        //     if(hash[nums[i]] == 1) {
        //         return nums[i]; // returns the number that appears once
        //     }
        // }
        // return -1; // no number appears once

        // 3. Optimal Soln :- Xor
        int xor = 0;
        for(int n : nums) {
            xor ^= n; // xor = xor ^ n
        }
        return xor;
    }
    public static void main(String[] args) {
        // 1. Brute force :
        // int nums[] = {1,1,2,3,3,4,4,5,5};
        // System.out.println(numberThatAppearsOnce(nums));

        // 2. Better Sol :- Hashing
        // int nums[] = {1,1,2,3,3,4,4,5,5};
        // System.out.println(numberThatAppearsOnce(nums));

        // 3. Optimal Sol :- Xor 
        int nums[] = {1,1,2,3,3,4,4,5,5};
        System.out.println(numberThatAppearsOnce(nums));
    }
}
/*
How the XOR Bit manipulation (Optimal sol) works :
0^1 = 1
1^1 = 0 
0^2 = 2
2^3 = 1
1^3 = 2 (3^3 = 0; 3 cancels)
2^4 = 6
6^4 = 2 (4^4 = 0; 4 cancels)
2^5 = 7
7^2 = 2 (5^5 = 0; 5 cancels)
Therefore, xor = 2
*/
