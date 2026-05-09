/*
 * ============================================================
 * LEETCODE 32 - Longest Valid Parentheses
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given a string containing just the characters '(' and ')', find the length
 * of the longest valid (well-formed) parentheses substring.
 *
 * Examples:
 * Input: "(()"      → Output: 2 ("()")
 * Input: ")()())"   → Output: 4 ("()()")
 * Input: ""         → Output: 0
 * Input: "()(()"    → Output: 2
 *
 * TOPICS: String, Dynamic Programming, Stack
 * PATTERN: Stack or DP with State Tracking
 * DIFFICULTY: Hard
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. STACK-BASED (O(n) time, O(n) space) - OPTIMAL
 *    Use stack storing indices. Push -1 initially. For each char:
 *    - '(' push index
 *    - ')' pop, if empty push this index, else calculate length = i - stack.top()
 *    Track maximum length seen.
 *
 * 2. TWO-PASS SCANNING (O(n) time, O(1) space)
 *    Pass left-to-right tracking open and close counts. If close > open,
 *    reset. Pass right-to-left similarly for cases like "((".
 *    More complex edge cases handling.
 *
 * 3. DYNAMIC PROGRAMMING (O(n) time, O(n) space)
 *    dp[i] = length of valid substring ending at i.
 *    If s[i]=')' and s[i-dp[i-1]-1]='(', dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2].
 *    Track maximum.
 *
 * OPTIMAL SOLUTION: Approach 1 - Stack-based with index tracking
 * Key insight: Stack stores indices of "break points", enabling length calculation
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Use std::stack<int> or vector as stack
 * - push() and pop() methods
 * - Use INT_MIN or -1 as sentinel
 *
 * GO:
 * - Use slice as stack with append/pop
 * - int type for indices
 * - for loop over string
 *
 * JAVASCRIPT:
 * - Use array as stack with push/pop
 * - Track maximum length
 * - for loop or for...of
 *
 * PYTHON:
 * - Use list as stack with append/pop
 * - List indexing for stack access
 * - for loop with enumerate()
 *
 * JAVA:
 * - Use Stack<Integer> or int[] as stack
 * - push(), pop(), peek() methods
 * - Array implementation for better performance
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - COMPILER ERROR DETECTION: Finding longest valid expression
 *   before syntax error, error recovery in parsers.
 *
 * - FORMULA VALIDATION: Checking longest valid mathematical
 *   expressions, spreadsheet formula validation.
 *
 * - CODE ANALYSIS: Detecting structural issues in nested code,
 *   identifying incomplete blocks in linters.
 *
 * - CONFIGURATION PARSING: Validating nested configuration structures,
 *   finding valid sections in JSON/YAML files.
 *
 * - INTERPRETER DESIGN: Tracking valid execution contexts,
 *   determining scopes in scripting language interpreters.
 */

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