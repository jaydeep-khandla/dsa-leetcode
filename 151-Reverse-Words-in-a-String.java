/*
 * ============================================================
 * LEETCODE 151 - Reverse Words in a String
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters.
 * The words in s are separated by one or more spaces.
 * After reversing the order of words, trim extra spaces and
 * return a single string with words separated by single space.
 *
 * Examples:
 * Input: "the sky is blue"     → Output: "blue is sky the"
 * Input: "  hello world  "    → Output: "world hello"
 * Input: "a good   example"   → Output: "example good a"
 *
 * TOPICS: String, Two Pointers
 * PATTERN: String Parsing with Trimming
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. SPLIT AND REVERSE (O(n) time, O(n) space) - OPTIMAL
 *    Split by whitespace, filter empty strings, reverse order,
 *    join with single space. Handles all edge cases efficiently.
 *
 * 2. TWO POINTER REVERSAL (O(n) time, O(n) space)
 *    Reverse entire string first, then reverse each word in place.
 *    Manually trim extra spaces. More complex but in-place possible.
 *
 * 3. STACK-BASED (O(n) time, O(n) space)
 *    Traverse string, build words, push to stack.
 *    Pop from stack to build reversed result. Clear logic.
 *
 * OPTIMAL SOLUTION: Approach 1 - Split, filter, reverse, join
 * Key insight: Language built-ins handle edge cases efficiently
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - std::stringstream for word extraction
 * - or use split by spaces manually
 * - std::reverse for word reversal
 * - join with loop or accumulate
 *
 * GO:
 * - strings.Fields() to split by whitespace
 * - Reverse slice
 * - strings.Join() with space separator
 *
 * JAVASCRIPT:
 * - split() with regex, filter empty strings
 * - reverse() array method
 * - join(' ') to combine
 *
 * PYTHON:
 * - split() without args handles all whitespace
 * - list slicing [::-1] for reverse
 * - join(' ') method
 *
 * JAVA:
 * - split("\\s+") with regex for whitespace
 * - Collections.reverse() or manual reverse
 * - StringBuilder for final join
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - TEXT FORMATTING: Reversing word order for RTL languages,
 *   text alignment in document processing.
 *
 * - LOG PROCESSING: Reverse log entries by timestamp,
 *   extracting words in reverse order for analysis.
 *
 * - SEARCH INDEXING: Building reverse indexes, finding last
 *   word matches in queries.
 *
 * - SENTIMENT ANALYSIS: Reversing word order for language
 *   translation preprocessing.
 *
 * - PASSWORD HASHING: Some hashing schemes process words
 *   in reverse order for added security.
 */

public class Solution {
    public String reverseWords(String s) {
        // Split the string by one or more spaces and trim leading/trailing spaces
        String[] words = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        
        // Iterate through the words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i != 0) {
                result.append(" ");  // Add space between words, except after the last word
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example test case
        String s = "  the sky is blue  ";
        String result = solution.reverseWords(s);
        System.out.println("Reversed words: '" + result + "'"); // Output: "blue is sky the"
    }
}