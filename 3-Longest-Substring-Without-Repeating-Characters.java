/*
 * ============================================================
 * LEETCODE 3 - Longest Substring Without Repeating Characters
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given a string s, find the length of the longest substring without
 * repeating characters.
 *
 * Examples:
 * Input: "abcabcbb" → Output: 3 ("abc")
 * Input: "bbbbb"    → Output: 1 ("b")
 * Input: "pwwkew"   → Output: 3 ("wke")
 * Input: ""         → Output: 0
 *
 * TOPICS: Hash Table, String, Sliding Window
 * PATTERN: Sliding Window (Two Pointers with HashMap)
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. SLIDING WINDOW WITH HASHMAP (O(n) time, O(min(n,m)) space) - OPTIMAL
 *    Use two pointers (start, end) defining a window. HashMap stores
 *    character -> last index. When duplicate found, move start pointer
 *    past the previous occurrence. Track max length at each step.
 *
 * 2. SLIDING WINDOW WITH ARRAY (O(n) time, O(1) space)
 *    Similar to above but use int array of size 128 (ASCII) instead of
 *    HashMap. Faster but assumes ASCII characters.
 *
 * 3. BRUTE FORCE (O(n^3) time, O(min(n,m)) space)
 *    Check all substrings for uniqueness. Outer loop for start,
 *    inner loop for end, innermost for uniqueness check.
 *
 * OPTIMAL SOLUTION: Approach 1 - Sliding window with character index tracking
 * Key insight: When duplicate found, slide window start to exclude it
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Use unordered_map<char, int> or array[128]
 * - Sliding window indices (left, right)
 * - max() function to track maximum length
 *
 * GO:
 * - Use map[rune]int for character tracking
 * - Convert string to runes for proper Unicode handling
 * - Two indices for window bounds
 *
 * JAVASCRIPT:
 * - Use object as HashMap
 * - Two indices for window
 * - charAt() or bracket notation
 *
 * PYTHON:
 * - Use dict for character tracking
 * - Two pointers with indices
 * - enumerate() to get index and character
 *
 * JAVA:
 * - Use HashMap<Character, Integer>
 * - Two int pointers (start, i)
 * - Math.max() for length tracking
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - TEXT EDITORS: Syntax highlighting, detecting duplicate identifiers
 *   in code, IDE features for variable renaming.
 *
 * - WEB BROWSERS: Caching recently visited URLs, tracking unique
 *   characters in search queries.
 *
 * - DATA COMPRESSION: Finding repeated patterns in text,
 *   LZW compression optimization.
 *
 * - FORM VALIDATION: Checking for unique characters in usernames,
 *   password strength validation.
 *
 * - GENETIC SEQUENCES: Finding longest sequence without repeating
 *   nucleotides in DNA/RNA analysis.
 */

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= start) {
                start = charIndexMap.get(currentChar) + 1; 
            }

            charIndexMap.put(currentChar, i); 
            maxLength = Math.max(maxLength, i - start + 1); 
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example inputs to test
        String test1 = "abcabcbb";
        String test2 = "bbbbb";
        String test3 = "pwwkew";
        String test4 = "";
        String test5 = " ";

        // Call the method and print results
        System.out.println(solution.lengthOfLongestSubstring(test1)); // Expected: 3
        System.out.println(solution.lengthOfLongestSubstring(test2)); // Expected: 1
        System.out.println(solution.lengthOfLongestSubstring(test3)); // Expected: 3
        System.out.println(solution.lengthOfLongestSubstring(test4)); // Expected: 0
        System.out.println(solution.lengthOfLongestSubstring(test5)); // Expected: 1
    }
}