import java.util.HashMap;

public class CountSubarraysWithXORk {
    public static int countOfSubarraysWithXORk(int arr[],int k) {
        // 1. Brute force : Generate all subarrays and check for all -> TC = O(n^3),SC = O(1)
        // int n = arr.length;
        // int count = 0;
        // for(int i=0;i<n;i++) {
        //     for(int j=i;j<n;j++) {
        //         int xor = 0;
        //         for(int l=i;l<=j;l++) {
        //             xor = xor ^ arr[l];
                    
        //             if(xor == k) {
        //                 count++;
        //             }
        //         }
        //     }
        // }
        // return count;

        // 2. Better Solution : Tc = O(n^2) SC = O(1)
        // int n = arr.length;
        // int count = 0;
        // for(int i=0;i<n;i++) {
        //     int xor = 0;
        //     for(int j=i;j<n;j++) {
        //         xor = xor ^ arr[j];

        //         if(xor == k) {
        //             count++;
        //         }
        //     }
        // }
        // return count;

        // 3. Optimal sol : Tc = O(n), SC = O(n) {for HashMap}
        int n = arr.length;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>(); // Store frequency of prefix XORs
        map.put(0, 1); // Initialize with prefix XOR 0
        int prefixXor = 0;
        for(int num : arr) {
            prefixXor ^= num; // Update prefix XOR
            int target = prefixXor ^ k; // element that is required in HashMap,so that subarray is formed (i.e required XOR)

            if(map.containsKey(target)) { // If target exists in map, add its frequency
                count += map.get(target);
            }

            map.put(prefixXor, map.getOrDefault(prefixXor, 0) + 1);// Store current prefix XOR in map
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;
        System.out.println(countOfSubarraysWithXORk(arr, k));
    }
}
/*
map.put(0, 1); -> It handles the case when a subarray starting from index 0 has XOR = k, becauseprefixXOR ^ k = required previous XOR 
Eg :Array: [4, 2, 2, 6, 4], k = 6
Prefix XOR progression:
Index 0 → 4 -> 0 ^ 4 = 4 (This would not happen if we dont put (0,1) in HashMap)
Index 1 → 6 (subarray [4,2])*/