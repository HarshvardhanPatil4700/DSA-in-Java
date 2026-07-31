// Given a string s, find the length of the longest substring without duplicate characters.

// import java.util.HashSet;
// import java.util.Set;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        // Brute force - TC = O(n^2), SC = O(1)
        // int n = s.length();
        // int maxLen = Integer.MIN_VALUE;
        // for(int i=0;i<n;i++) {
        //     Set<Character> set = new HashSet<>();
        //     for(int j=i;j<n;j++) {
        //         char c = s.charAt(j);
        //         if(set.contains(c)){
        //             break;
        //         }
        //         set.add(c);
        //         maxLen = Math.max(maxLen, j-i+1);
        //     }
        // }
        // return maxLen;

        // 3. Optimal sol - Sliding window : TC = O(n),SC = O(1)
        int n = s.length();
        int low = 0;
        int maxLen = Integer.MIN_VALUE;
        Map<Character,Integer> mp = new HashMap<>();

        for(int high = 0; high < n; high++) {
            char c = s.charAt(high);
            mp.put(c,mp.getOrDefault(c, 0) + 1);
            int k = high - low + 1; // It is current window size before shrink
            while(mp.size() < k) {
                char leftChar = s.charAt(low);
                mp.put(leftChar, mp.get(leftChar) - 1);
                if(mp.get(leftChar) == 0) {
                    mp.remove(leftChar);
                }
                low++;
                k = high - low + 1; // updated window size after shrinking
            }
            int currLen = high - low + 1; // mp.size() == high - low + 1. It is the final valid window size after all shrinking is done
            maxLen = Math.max(currLen, maxLen);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String str = "abcabcbba";
        System.out.println(lengthOfLongestSubstring(str)); // "abc" => 3

        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s)); // "b" => 1
    
        String s1 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s1)); // "wke" => 3
    }
}
