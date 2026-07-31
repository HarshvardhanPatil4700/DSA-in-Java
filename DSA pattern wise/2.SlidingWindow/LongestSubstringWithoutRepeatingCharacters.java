
import java.util.HashSet;
import java.util.Set;

// Given a string s, find the length of the longest substring without duplicate characters.

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        // Brute force - TC = O(n^2), SC = O(1)
        int n = s.length();
        int maxLen = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            Set<Character> set = new HashSet<>();
            for(int j=i;j<n;j++) {
                char c = s.charAt(j);
                if(set.contains(c)){
                    break;
                }
                set.add(c);
                maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String str = "abcabcbba";
        System.out.println(lengthOfLongestSubstring(str)); // "abc" => 3

        
    }
}
