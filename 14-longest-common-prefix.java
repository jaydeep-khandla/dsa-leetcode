/*
 * ============================================================
 * LEETCODE 14 - Longest Common Prefix
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Write a function to find the longest common prefix string amongst an array
 * of strings. If there is no common prefix, return an empty string "".
 *
 * Examples:
 * Input: ["flower", "flow", "flight"]  → Output: "fl"
 * Input: ["dog", "racecar", "car"]     → Output: ""
 * Input: ["interspecies", "interstellar", "interstate"] → Output: "inters"
 *
 * TOPICS: String, Trie
 * PATTERN: Horizontal Scanning / Vertical Scanning
 * DIFFICULTY: Easy
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. HORIZONTAL SCANNING (O(S) time, O(1) space) - OPTIMAL
 *    Use the first string as the initial prefix. Compare it with each
 *    subsequent string, progressively shortening the prefix when a
 *    mismatch is found using indexOf() or startsWith().
 *
 * 2. VERTICAL SCANNING (O(S) time, O(1) space)
 *    Compare characters at the same position for all strings.
 *    Stop when a mismatch or end of any string is found.
 *    Efficient when common prefix is short or arrays are large.
 *
 * 3. SORT AND COMPARE FIRST AND LAST (O(n log n) time, O(1) space)
 *    Sort the array lexicographically. The common prefix of the entire
 *    array must be the common prefix between first and last strings
 *    (most different strings after sorting).
 *
 * 4. DIVIDE AND CONQUER (O(S) time, O(log n) space)
 *    Recursively find LCP of left half and right half, then combine.
 *    Good for understanding recursion but not optimal here.
 *
 * OPTIMAL SOLUTION: Approach 1 - Horizontal scanning with prefix reduction
 * Key insight: Common prefix of all strings must be prefix of first string
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Use string class with substr(), compare()
 * - std::min_element to find shortest string
 * - for loop iterating through characters
 *
 * GO:
 * - Use string indexing with rune conversion for Unicode
 * - Compare using direct character access
 * - strings.HasPrefix() from strings package
 *
 * JAVASCRIPT:
 * - Array methods: indexOf(), startsWith() (ES6+)
 * - for...of loops or traditional for loops
 * - substring() for prefix reduction
 *
 * PYTHON:
 * - Use min() to find shortest string
 * - startswith() method on strings
 * - zip() function to compare characters column-wise
 *
 * JAVA:
 * - indexOf() to check prefix match
 * - substring() for prefix reduction
 * - Traditional for loops for character comparison
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - AUTOCOMPLETE/TYPEAHEAD: Finding common prefixes for suggestion engines,
 *   search bars, command-line interfaces (CLI autocomplete).
 *
 * - FILE SYSTEMS: Suggesting directory paths, showing common parent
 *   directories, file organization tools.
 *
 * - BIOINFORMATICS: DNA sequence analysis, finding common gene sequences,
 *   protein sequence alignment tools.
 *
 * - DATABASE INDEXING: Prefix-based indexing, lexicographical sorting
 *   optimization, range queries on string columns.
 *
 * - VERSION CONTROL: Finding common branches, diff generation,
 *   file path comparisons in Git-like systems.
 */

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return ""; // Added check to avoid infinite loop
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Define the test cases
        String[][] testCases = {
            {"flower", "flow", "flight"},
            {"dog", "racecar", "car"},
            {"interspecies", "interstellar", "interstate"},
            {"throne", "drones", "stone"},
            {""}, // Edge case: empty string
            {} // Edge case: empty array
        };

        // Iterate through each test case
        for (String[] testCase : testCases) {
            // Compute the longest common prefix
            String result = solution.longestCommonPrefix(testCase);
            // Print the result
            System.out.println("Input: " + String.join(", ", testCase));
            System.out.println("Longest Common Prefix: " + result);
            System.out.println();
        }
    }
}