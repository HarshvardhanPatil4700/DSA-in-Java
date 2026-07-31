// You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

// You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

// 1. You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
// 2. Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
// 3. Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
// Given the integer array fruits, return the maximum number of fruits you can pick.


import java.util.HashMap;
import java.util.Map;
// import java.util.HashSet;
// import java.util.Set;

public class FruitsIntoBasket {
    public static int totalFruits(int[] arr) {
        // Brute force : TC = O(n^2), SC = O(3) = O(1)
        // int n = arr.length;
        // int maxLen = 0;

        // for(int i=0;i<n;i++) {
        //     Set<Integer> set = new HashSet<>();
        //     for(int j=i;j<n;j++) {
        //         set.add(arr[j]);
        //         if(set.size() > 2) {
        //             break;
        //         }
        //         maxLen = Math.max(maxLen, j-i+1);
        //     }
        // }
        // return maxLen;

        // 2. Optimal sol - Sliding window - TC = O(n), SC = O(1)
        int n = arr.length;
        int left = 0;
        int maxLen = Integer.MIN_VALUE;
        Map<Integer,Integer> freq = new HashMap<>();

        for(int right = 0;right < n; right++) {
            freq.put(arr[right], freq.getOrDefault(arr[right], 0) +1);

            while(freq.size() > 2) {
                int leftFruit = arr[left];
                freq.put(leftFruit, freq.get(leftFruit) - 1);
                if(freq.get(leftFruit) == 0) {
                    freq.remove(leftFruit);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] fruits = {1,2,3,2,2,1};
        System.out.println(totalFruits(fruits)); // {2,3,2,2} => 4
    }
}
