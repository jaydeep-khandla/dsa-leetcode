public class Solution {
    public int longestValidParentheses(String s) {
        int[] stack = new int[s.length() + 1];
        int top = -1;
        stack[++top] = -1;

        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack[++top] = i;
            } else {
                top--;

                if (top == -1) {
                    stack[++top] = i;
                }

                max = Math.max(max, i - stack[top]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String input = "(()))())(";
        int result = sol.longestValidParentheses(input);
        System.out.println("Longest valid parentheses length: " + result);
    }
}
