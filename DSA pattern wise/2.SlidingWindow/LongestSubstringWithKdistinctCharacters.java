// You are given a string s consisting only lowercase alphabets and an integer k. Your task is to find the length of the longest substring that contains exactly k distinct characters.

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKdistinctCharacters {
    public static int longestKSubstr(String s,int k) {
        int n = s.length();
        int low = 0, res = -1;
        Map<Character,Integer> freq = new HashMap<>();

        for(int high = 0;high<n;high++) {
            char c = s.charAt(high);
            freq.put(c, freq.getOrDefault(c,0) +1);

            // shrink the window
            while(freq.size() > k) {
                char leftChar = s.charAt(low);
                freq.put(leftChar, freq.get(leftChar) -1);
                if(freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                low++;
            }

            // if exactly k unique, update answer
            if(freq.size() == k) {
                int currLen = high-low+1;
                res = Math.max(res, currLen);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        
    }
}
/* 
Why we dont check for freq.size() < k ?

Our goal : We want the longest substring with exactly k distinct characters.
There are three possible cases after adding a character:
Case 1: freq.size() < k
Example:
s = "aab"
k = 3

Window = "aab"
Distinct characters = {a, b}
freq.size() = 2

This window doesn't yet have enough distinct characters.
Should we shrink it?
No! If you shrink it, you'll remove characters and make it even less likely to reach 3 distinct characters.
Instead, we keep expanding by moving high to the right.

Case 2 - freq.size() == k  {In code}
Case 3 - freq.size() > k  {In code}
*/