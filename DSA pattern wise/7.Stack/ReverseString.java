// 1. Use the Stack approach when you want to reverse a string using the LIFO (Last In, First Out) property, or when stack operations are useful in the larger problem. It requires O(n) extra space because you store all the characters in the stack.
// 2. Use the Two Pointers approach when you need to reverse a string or character array by swapping characters from both ends and moving toward the middle. It takes O(n) time and O(1) extra space, making it more efficient for in-place reversal. For LeetCode 344, where the input array must be modified in place with O(1) extra memory, Two Pointers is the best choice.

import java.util.Stack;

public class ReverseString {
    public static void reverseString(char[] s) {
        // 1. Using Stack approach : TC = O(n + n) = O(n), SC = O(n)
        Stack<Character> st = new Stack<>();
        // push all chars in stack
        for (char c : s) {
            st.push(c);
        }
        // pop all chars from stack. As it follows LIFO approach, it reverse a string
        for (int i = 0; i < s.length; i++) {
            s[i] = st.pop();
        }
    }

    // 2. using 2 pointers approach : TC = O(n), SC = O(1) (in-place)
    public static void reverseStr(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while(left < right) {
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;

            right--;
            left++;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(s);

        char[] str = {'H','a','n','n','a','h'};
        reverseString(str);
        System.out.println(str);
    }
}
