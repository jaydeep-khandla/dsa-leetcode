import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        // If the length of the string is odd, it can't be valid
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If it's an opening bracket, push to stack
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.add(ch);
            } else {
                // If it's a closing bracket, check for matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }

                // Get the top element from stack
                char top = stack.peek();
                stack.pop();

                // If the brackets don't match, return false
                if ((ch == ')' && top != '(') || (ch == ']' && top != '[') || (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }

        // If stack is empty, all brackets are matched, return true
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test case
        String s = "()[]{}(}";
        boolean result = solution.isValid(s);
        System.out.println("Is valid: " + result); // Output: true
    }
}
