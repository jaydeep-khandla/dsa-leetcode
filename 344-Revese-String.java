/*
 * ============================================================
 * LEETCODE 344 - Reverse String
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Write a function that reverses a string. The input string is given
 * as an array of characters s. You must do this by modifying the
 * input array in-place with O(1) extra memory.
 *
 * Examples:
 * Input: ['h', 'e', 'l', 'l', 'o'] → Output: ['o', 'l', 'l', 'e', 'h']
 * Input: ['H', 'a', 'n', 'n', 'a', 'h'] → Output: ['h', 'a', 'n', 'n', 'a', 'H']
 *
 * TOPICS: Two Pointers, String
 * PATTERN: Two Pointers (left and right swapping)
 * DIFFICULTY: Easy
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. TWO POINTERS WITH SWAP (O(n) time, O(1) space) - OPTIMAL
 *    Use left and right pointers starting from both ends.
 *    Swap characters at both pointers, then move pointers inward.
 *    Continue until pointers meet or cross.
 *
 * 2. RECURSIVE APPROACH (O(n) time, O(n) space)
 *    Recursively swap endpoints and recurse on the inner substring.
 *    Less space-efficient due to recursion stack.
 *
 * 3. BUILT-IN REVERSE (varies by language)
 *    Use language's built-in reverse function if allowed.
 *    Language-specific, may not meet in-place requirement.
 *
 * OPTIMAL SOLUTION: Approach 1 - Two pointers with in-place swap
 * Key insight: Swap from both ends moving inward (classic two-pointer)
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Use std::swap() for swapping characters
 * - Two indices: i from start, j from end
 * - std::reverse() if using STL
 *
 * GO:
 * - Convert to rune slice for Unicode
 * - Manual swap with temp variable
 * - Two indices moving inward
 *
 * JAVASCRIPT:
 * - Array destructuring: [s[l], s[r]] = [s[r], s[l]]
 * - Traditional swap with temp variable
 * - In-place modification
 *
 * PYTHON:
 * - Tuple unpacking: s[l], s[r] = s[r], s[l]
 * - Traditional swap with temp variable
 * - List is mutable
 *
 * JAVA:
 * - char temp variable for swapping
 * - Two indices, swap, then move inward
 * - charAt() and setCharAt() for Strings (requires new String)
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - TEXT EDITORS: Implementing undo functionality, reversing text
 *   selections, RTL (right-to-left) language support.
 *
 * - NETWORK PROTOCOLS: Reversing byte order for endianness conversion,
 *   data packet reconstruction.
 *
 * - CRYPTOGRAPHY: Simple cipher reversals, palindrome checking,
 *   encoding transformations.
 *
 * - GAME DEVELOPMENT: Player name reversal, score display formatting,
 *   text-based game input processing.
 *
 * - DATA SERIALIZATION: Converting between big-endian and little-endian
 *   representations, binary data manipulation.
 */

import java.util.Arrays;

class Solution {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;

            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example input
        char[] s = {'h', 'e', 'l', 'l', 'o'};

        // Call the method
        solution.reverseString(s);

        // Print the result
        System.out.println(Arrays.toString(s));
    }
}