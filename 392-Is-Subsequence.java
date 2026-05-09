/*
 * ============================================================
 * LEETCODE 392 - Is Subsequence
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given two strings s and t, return true if s is a subsequence of t,
 * or false otherwise. A subsequence is a sequence that can be derived
 * from another sequence by deleting some or no characters without
 * changing the order of the remaining characters.
 *
 * Examples:
 * Input: s = "abc", t = "ahbgdc" → Output: true
 * Input: s = "axc", t = "ahbgdc" → Output: false
 * Input: s = "ace", t = "abcde"  → Output: true
 * Input: s = "aec", t = "abcde"  → Output: false
 *
 * TOPICS: Two Pointers, String, Dynamic Programming
 * PATTERN: Two Pointers (sequential matching)
 * DIFFICULTY: Easy
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. TWO POINTERS (O(n+m) time, O(1) space) - OPTIMAL
 *    Use two pointers, one for s and one for t. Move through t,
 *    when characters match, advance s pointer. If s pointer reaches
 *    end, subsequence found.
 *
 * 2. INDEX TRACKING (O(n+m) time, O(1) space)
 *    Track current index in s. When char matches, move to next index.
 *    Continue until t ends or all chars in s matched.
 *
 * 3. RECURSIVE/BACKTRACKING (O(n+m) time, O(n) space)
 *    Recursively find each character in t starting from last found position.
 *    Less efficient due to repeated scanning.
 *
 * OPTIMAL SOLUTION: Approach 1 - Two pointers with single pass
 * Key insight: Order must be preserved, so single directional scan suffices
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Two indices: i for s, j for t
 * - while loops to traverse both strings
 * - Check if i reaches s.length()
 *
 * GO:
 * - Two indices: sIdx for s, tIdx for t
 * - for loop with range on t
 * - Check if sIdx reaches len(s)
 *
 * JAVASCRIPT:
 * - Two indices or reduce approach
 * - for loops or while loops
 * - Compare indices at end
 *
 * PYTHON:
 * - Two indices approach
 * - for loop with enumerate or while loop
 * - Check against len(s)
 *
 * JAVA:
 * - Two int indices
 * - while loop with index comparisons
 * - charAt() for character access
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - TEXT SEARCH: Finding patterns in DNA sequences, substring
 *   matching in bioinformatics applications.
 *
 * - VERSION CONTROL: Checking if a branch name exists in commit history,
 *   determining if changes are included in release.
 *
 * - STREAMING/PLAYLIST: Checking if a playlist song order matches
 *   requested sequence, verifying data packet order.
 *
 * - PERMISSION SYSTEMS: Checking if user has subset of required permissions,
 *   validating feature flags in a feature set.
 *
 * - WEB ROUTING: Checking if required HTTP headers are present in order,
 *   validating request sequence in middleware.
 */

public class Solution {
    
    // Method to check if 's' is a subsequence of 't'
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int n1 = s.length(), n2 = t.length();

        if (n1 < 1) return true;

        while (j < n2) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                if (i == n1) {
                    return true;
                }
            }
            j++;
        }

        return i == n1;
    }

    // Main method to test the isSubsequence function
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        String s1 = "abc";
        String t1 = "ahbgdc";
        System.out.println("Test Case 1: " + solution.isSubsequence(s1, t1));  // Expected output: true
        
        String s2 = "axc";
        String t2 = "ahbgdc";
        System.out.println("Test Case 2: " + solution.isSubsequence(s2, t2));  // Expected output: false
    }
}