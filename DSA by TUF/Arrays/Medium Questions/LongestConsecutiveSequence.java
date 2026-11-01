// import java.util.ArrayList; for brute force
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    // 1. Brute force : TC = O(n^2) SC = O(1)
    // public static int[] longestSequence(int a[]) {
    //     int n = a.length;

    //     ArrayList<Integer> bestSeq = new ArrayList<>(); // store longest sequence

    //     for(int i = 0; i < n; i++) {
    //         int x = a[i];

    //         ArrayList<Integer> currentSeq = new ArrayList<>(); // new sequence for each i
    //         currentSeq.add(x); //  add starting element

    //         while (ls(a, x + 1) == true) {
    //             x = x + 1;                     // move to next element
    //             currentSeq.add(x);             // add correct element (not a[i])
    //         }

    //         if(currentSeq.size() > bestSeq.size()) { // update best sequence
    //             bestSeq = currentSeq;
    //         }
    //     }

    //     int result[] = new int[bestSeq.size()]; 
    //     for(int i = 0; i < bestSeq.size(); i++) {
    //         result[i] = bestSeq.get(i);         
    //     }
    //     return result;
    // }

    // private static boolean ls(int[] a, int n) {
    //     for(int i = 0; i < a.length; i++) {
    //         if(a[i] == n)
    //             return true;
    //     }
    //     return false;
    // }

    // 2. Optimal Sol : using order set ds. TC = O(n), SC = O(n)
    public static int longestSequence(int a[]) {
        int n = a.length;
        if (n == 0) return 0; // If the array is empty, no sequence exists
        int longest = 1; // to store the length of longest sequence

        Set<Integer> set = new HashSet<>();

        for(int i=0;i<n;i++) { // inserting all array elements into set (O[n])
            set.add(a[i]);
        }
         
        // Loop through each element in the set to find the starting point of consecutive sequences (O(n))
        for (int it : set) {
            if (!set.contains(it - 1)) { // If there is no number before 'it', it’s the start of a sequence
                int cnt = 1; // Start the count for this sequence               
                int x = it; // Store the current number

                // Keep checking for the next consecutive number
                while (set.contains(x + 1)) {
                    // Move to the next number in sequence
                    x = x + 1; 
                    // Increment the length of current sequence
                    cnt = cnt + 1; 
                }

                longest = Math.max(longest, cnt); // Update the longest sequence length if needed
            }
        }

        return longest;
    }
    

    public static void main(String[] args) {
        int a[] = {102,4,100,1,101,3,2,1,1};
        int longestSeqLength = longestSequence(a);
        System.out.println("The longest sequence length is : " + longestSeqLength);
    }
}