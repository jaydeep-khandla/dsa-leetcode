/*
 * ============================================================
 * LEETCODE 20 - Valid Parentheses
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid. An input string is valid if:
 * - Open brackets must be closed by the same type of brackets.
 * - Open brackets must be closed in the correct order.
 * - Every close bracket has a corresponding open bracket of the same type.
 *
 * Examples:
 * Input: "()"       → Output: true
 * Input: "()[]{}"   → Output: true
 * Input: "(]"       → Output: false
 * Input: "([)]"     → Output: false
 * Input: "{[]}"     → Output: true
 *
 * TOPICS: String, Stack
 * PATTERN: Stack - Matching Pairs
 * DIFFICULTY: Easy
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. STACK WITH MAP (O(n) time, O(n) space) - OPTIMAL
 *    Use a stack to keep track of opening brackets. For each closing bracket,
 *    check if the stack's top matches. Push opening brackets, pop for matches.
 *    Valid if stack is empty at the end.
 *
 * 2. STACK WITH SWITCH/CONDITIONAL (O(n) time, O(n) space)
 *    Same approach but use conditional statements or switch to determine
 *    opening brackets and matching pairs instead of a map.
 *
 * 3. COUNTER APPROACH (O(n) time, O(1) space) - LIMITED
 *    Use counters for each bracket type, but this fails for nested cases
 *    like "([)]" - only works for simple non-nested scenarios.
 *
 * OPTIMAL SOLUTION: Approach 1 - Stack-based matching
 * Key insight: Most recent opening bracket must match next closing bracket (LIFO)
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Use std::stack<char> for stack operations
 * - Use unordered_map<char, char> for bracket pairs
 * - push(), pop(), top(), empty() methods
 *
 * GO:
 * - Use slice as stack: append() to push, slice[:len-1] to pop
 * - map[rune]rune for bracket pairs
 * - for range loop over string
 *
 * JAVASCRIPT:
 * - Use array as stack with push() and pop()
 * - Object/map for bracket pairs
 * - for loop or for...of
 *
 * PYTHON:
 * - Use list as stack with append() and pop()
 * - dict for bracket pairs
 * - for loop over string
 *
 * JAVA:
 * - Use Stack<Character> or ArrayDeque<Character>
 * - HashMap<Character, Character> for bracket pairs
 * - charAt() for character access
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - COMPILER DESIGN: Syntax validation in programming language parsers,
 *   checking matching brackets, braces, parentheses in code.
 *
 * - TEXT EDITORS: Auto-closing brackets, bracket matching highlighting,
 *   code folding in IDEs like VS Code, IntelliJ.
 *
 * - MATHEMATICAL EXPRESSION EVALUATORS: Validating expression syntax
 *   before evaluation, spreadsheet formula validation.
 *
 * - HTML/XML VALIDATION: Checking matching tags in markup languages,
 *   document structure validation.
 *
 * - CONFIGURATION FILES: Validating JSON, YAML structure in config
 *   parsers, ensuring proper nesting of elements.
 */

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