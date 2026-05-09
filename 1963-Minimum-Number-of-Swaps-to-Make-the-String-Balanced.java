/*
 * ============================================================
 * LEETCODE 1963 - Minimum Number of Swaps to Make the String Balanced
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * You are given a string s of length n consisting only of '[' and ']'.
 * A string is balanced if:
 * - Every '[' has a corresponding ']'
 * - Every ']' has a corresponding '['
 * In one swap, you can select two indices i and j (0-indexed) where
 * i < j, and swap s[i] with s[j].
 * Return the minimum number of swaps required to make s balanced.
 *
 * Examples:
 * Input: "[]][][" → Output: 2
 * Input: "[]"     → Output: 0
 * Input: "[[]]"   → Output: 0
 *
 * TOPICS: String, Stack, Greedy
 * PATTERN: Balance Counter with Swap Tracking
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. BALANCE COUNTER WITH SWAP COUNT (O(n) time, O(1) space) - OPTIMAL
 *    Count unmatched '[' when seeing ']'. Each unmatched '[' will need
 *    a swap. Swaps = ceil(unmatched / 2). Use greedy: when encountering ']',
 *    if balance > 0, match it; else increment unmatched.
 *
 * 2. STACK APPROACH (O(n) time, O(n) space)
 *    Use stack to track unmatched '[' indices.
 *    When seeing ']', pop from stack. If empty, mark as needing swap.
 *    Count swaps needed.
 *
 * 3. SWAP-BASED SIMULATION (O(n) time, O(n) space)
 *    Simulate swaps by tracking where each bracket should go.
 *    Less efficient.
 *
 * OPTIMAL SOLUTION: Approach 1 - Greedy balance counting
 * Key insight: Each two unmatched open brackets require one swap
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Single int counter for unmatched
 * - for loop over string
 * - Increment counter on ']', decrement on '['
 * - Formula for swap count: (counter + 1) / 2
 *
 * GO:
 * - int counter variable
 * - for range over string
 * - Conditional logic for brackets
 * - Return (counter + 1) / 2
 *
 * JAVASCRIPT:
 * - Variable for unmatched count
 * - for loop or for...of
 * - Conditional increment/decrement
 * - Math.ceil or integer math
 *
 * PYTHON:
 * - int variable for tracking
 * - for loop over string
 * - Conditional updates
 * - Formula: (counter + 1) // 2
 *
 * JAVA:
 * - int counter for unmatched
 * - charAt() for character access
 * - char comparison
 * - Return (counter + 1) / 2
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - TEXT EDITORS: Auto-balancing brackets in code editors,
 *   suggesting minimal bracket swaps.
 *
 * - CONFIGURATION FILES: Balancing nested structures,
 *   counting minimal reorders.
 *
 * - GENE SEQUENCING: Finding minimum swaps to balance
 *   complementary DNA strands.
 *
 * - PUZZLE GAMES: Minimum moves to balance parentheses
 *   in bracket puzzle games.
 *
 * - COMPILER ERROR RECOVERY: Suggesting minimal changes
 *   to fix bracket imbalance in code.
 */

public class Solution {
    public static int minSwaps(String s) {
        int swap = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '[') {
                swap++;
            } else if (swap > 0) {
                swap--;
            }
        }

        return (swap + 1) / 2;
    }

    public static void main(String[] args) {
        String input = "[]][][";
        int result = minSwaps(input);
        System.out.println("Minimum swaps needed: " + result);
    }
}