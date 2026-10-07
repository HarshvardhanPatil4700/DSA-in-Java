import java.util.Stack;

public class RemoveAllAdjacentDuplicates {
    public static String removeDuplicates(String s) {
        // 1. Stack Approach: TC: O(n), SC: O(n)
        int n = s.length();
        Stack<Character> st = new Stack<>();
        String ans = "";

        for(int i = 0; i < n; i++) {
            // Case 1: If stack is empty then, add the char to stack 
            if(st.empty()) {
                st.push(s.charAt(i));
                continue;
            }
            
            // Case 2: If char matches the top of stack (conflict) then, remove the current char and top of stack
            if(s.charAt(i) == st.peek()) {
                st.pop();
            } else {
                // Case 3: If char doesn't match the top of stack then, add the char to stack
                st.push(s.charAt(i));
            }
        }
        // after processing all the characters, we will pop all the elements from the stack and form the final answer as:
        while(!st.empty()) {
            ans = st.pop() + ans;
        }
        return ans;

        // 2. Using StringBuilder: TC: O(n), SC: O(n)
        // StringBuilder sb = new StringBuilder(); // sb = ""
        // for(char c : s.toCharArray()) {
        //     if(sb.length() > 0 && sb.charAt(sb.length()-1) == c) {
        //         sb.deleteCharAt(sb.length()-1);
        //     } else {
        //         sb.append(c);
        //     }
        // }
        // return sb.toString();
    }
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s)); // Output: "ca"
        String str = "azxxzy";
        System.out.println(removeDuplicates(str)); // Output: "ay"
    }
}