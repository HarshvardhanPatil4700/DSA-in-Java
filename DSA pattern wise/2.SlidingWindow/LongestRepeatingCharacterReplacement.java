// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
// Return the length of the longest substring containing the same letter you can get after performing the above operations.

public class LongestRepeatingCharacterReplacement {
    public static int findMax(int []arr) {
        int maxCount = -1;
        for(int i=0;i<arr.length;i++) {
            maxCount = Math.max(maxCount, arr[i]);
        }
        return maxCount;
    }
    public static int characterReplacement(String s, int k) {
        // Sliding window - TC = O(n), SC = O(256) = O(1)
        int n = s.length();
        int low = 0, maxLen = Integer.MIN_VALUE;
        int []chars = new int[256];

        for(int high = 0; high < n; high++) {
            chars[s.charAt(high)]++;
            
            int len = high - low + 1;
            int maxCount = findMax(chars);
            int diff = len - maxCount; // it gives total no. of other or non unique characters to maximum occuring character

            while(diff > k) {
                chars[s.charAt(low)]--;
                low++; // note here we dont check if the count of character is zero bcoz we have used an array not hashMap
                 
                // Update the changes after shrink :
                len = high - low + 1;
                maxCount = findMax(chars);
                diff = len - maxCount;
            }
            // After the while loop 2 cases exit : 1) diff < k  2) diff = k .both the cases are favourable
            len = high - low + 1;
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "ABAB";
        System.out.println(characterReplacement(str, 2)); // "ABAB" changes to "AAAA" or "BBBB" => 4

        String s = "AABABBA";
        System.out.println(characterReplacement(s, 1)); // "AABABBA" -> "AAAABBA" => 4
    }
}
