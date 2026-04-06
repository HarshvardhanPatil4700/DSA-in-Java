import java.util.ArrayList;

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

    // 2. Optimal Sol : 
    

    public static void main(String[] args) {
        int a[] = {102,4,100,1,101,3,2,1,1};
        int seq[] = longestSequence(a);

        for(int n : seq) {
            System.out.print(n + " ");
        } 
    }
}