/*
 * ============================================================
 * LEETCODE 921 - Minimum Add to Make Parentheses Valid
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * A parentheses string is valid if and only if:
 * - It is an empty string
 * - It can be written as AB (A concatenated with B) where A and B are valid strings
 * - It can be written as (A) where A is a valid string
 * Given a string S of '(' and ')', you can insert '(' or ')' at any position.
 * Return the minimum number of parentheses to add to make the string valid.
 *
 * Examples:
 * Input: "())"   → Output: 1
 * Input: "((("   → Output: 3
 * Input: "()()"  → Output: 0
 *
 * TOPICS: String, Stack, Greedy
 * PATTERN: Balance Counter
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. BALANCE COUNTER (O(n) time, O(1) space) - OPTIMAL
 *    Track open and close counters. When seeing '(', increment open.
 *    When seeing ')', if open > 0, decrement open (match found),
 *    else increment close (unmatched close). Return open + close.
 *
 * 2. STACK APPROACH (O(n) time, O(n) space)
 *    Use stack to match parentheses. Push '(' on stack.
 *    For ')', if stack not empty, pop. Else increment close.
 *    Return stack size + close.
 *
 * 3. RECURSIVE/GROUPING (O(n) time, O(n) space)
 *    Group into balanced segments, count remaining open brackets.
 *    More complex implementation.
 *
 * OPTIMAL SOLUTION: Approach 1 - Counter-based balance tracking
 * Key insight: Open count minus matched pairs gives needed additions
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Two int variables: open = 0, close = 0
 * - For each char, update counters
 * - Return open + close
 *
 * GO:
 * - Two int variables
 * - for range over string
 * - Conditional logic for '(' and ')'
 *
 * JAVASCRIPT:
 * - Two variables for tracking
 * - for loop or for...of
 * - Conditional updates
 *
 * PYTHON:
 * - Two integer variables
 * - for loop over string
 * - Conditional logic
 *
 * JAVA:
 * - Two int counters: open and close
 * - charAt() for character access
 * - return open + close
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - CODE VALIDATION: Counting unclosed parentheses in syntax checkers,
 *   error reporting in compilers.
 *
 * - TEXT EDITORS: Auto-indentation suggestions, bracket matching
 *   in IDEs.
 *
 * - FORMULA VALIDATION: Validating mathematical expressions,
 *   spreadsheet formula syntax checking.
 *
 * - CONFIGURATION FILES: Checking nested structure validity,
 *   YAML/JSON bracket matching.
 *
 * - TRANSLATION/MIGRATION: Counting extra brackets needed for
 *   language-specific syntax conversion.
 */

class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0;

        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++; // Increment open counter when encountering '('
            } else {
                if (open == 0) {
                    close++; // Increment close counter when encountering unmatched ')'
                } else {
                    open--; // Decrease open counter for a matched pair
                }
            }
        }

        // Total unmatched parentheses
        return open + close;
    }

    public static void main(String[] args) {

        // Example test case
        String s = "()[]{}(}";

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Call the method and print the result
        int result = solution.minAddToMakeValid(s);
        System.out.println("Minimum additions needed to make the string valid: " + result);
    }
}