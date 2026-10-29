// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. An input string is valid if:
// 1. Open brackets must be closed by the same type of brackets.
// 2. Open brackets must be closed in the correct order.
// 3. Every close bracket has a corresponding open bracket of the same type

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()) {
            // Push opening brackets
            if(ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }
            // Process closing brackets
            else {
                if(st.empty()) { // checks if any closing brackets is before opening brckets
                    return false;
                }

                char top = st.pop();
                if(ch == ')' && top != '(' ||
                    ch == '}' && top != '{' ||
                    ch == ']' && top != '['
                ) {
                    return false;
                }
            }
        }
        return st.isEmpty(); // also checks if any parentheses is left after processing closing brackets
    }
    
    public static void main(String[] args) {
        String s1 = "()";
        System.out.println(isValid(s1));
        String s2 = "()[]{}";
        System.out.println(isValid(s2));
        String s3 = "(]";
        System.out.println(isValid(s3));
        String s4 = "([])";
        System.out.println(isValid(s4));
        String s5 = "([)]";
        System.err.println(isValid(s5));
    }
}

/* Before processing a closing bracket, check whether the stack is empty :
- If the stack is empty, there is no opening bracket available to match the current closing bracket, so return false.
- If the stack is not empty, pop the top opening bracket and check whether it matches. */