// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        // 1. Brute force : TC = O(n^2), SC = O(1)
        //     int m = s.length();
        //     int n = t.length();
        //     if(m < n) return "";
        //     int []target = new int[128]; 
        //     for (char ch : t.toCharArray()) {
        //         target[ch]++;
        //     }
        //     int minLen = Integer.MAX_VALUE;
        //     String ans = "";

        //     for(int i=0;i<m;i++) {
        //         int freq[] = new int[128]; // to store frequency of every character of String s
        //         for(int j=i;j<m;j++) {
        //             freq[s.charAt(j)]++;

        //             if(isValid(freq,target)) {
        //                 if(j-i+1 < minLen) {
        //                     minLen = j-i+1;
        //                     ans = s.substring(i, j+1); // Returns a string that is a substring of this string from i to j+1
        //                     break;
        //                 }
        //             }
        //         }
        //     }
        //     return ans;
        // }
        // private static boolean isValid(int[] freq, int[] target) {

        //     for (int i = 0; i < 128; i++) {
        //         if (freq[i] < target[i]) {
        //             return false;
        //         }
        //     }

        //     return true;
        // }
        
        // 2. Optimal sol : Sliding window - TC = O(n), SC = O(1)
        int m = s.length();
        int n = t.length();
        if(m < n) return "";
        int []target = new int[256]; // frequency of characters of String t
        for(int i=0;i<n;i++) {
            target[t.charAt(i)]++;
        }

        int low = 0;
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        int []needed = new int[256];
        for(int high=0;high<m;high++) {
            needed[s.charAt(high)]++;

            while(isValid(needed, target)) {
                int currLen = high - low + 1;
                if(currLen < minLen) {
                    minLen = currLen;
                    ans = s.substring(low, high+1);
                }
                needed[s.charAt(low)]--;
                low++;
            }
        }
        return ans;
    }
    private static boolean isValid(int[] freq, int[] target) {
        for (int i = 0; i < 128; i++) {
            if (freq[i] < target[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));

        String s1 = "a", t1 = "a";
        System.out.println(minWindow(s1, t1));

        String s2 = "a", t2 = "aa";
        System.out.println(minWindow(s2, t2)); // No o/p as m < n
    }
}
