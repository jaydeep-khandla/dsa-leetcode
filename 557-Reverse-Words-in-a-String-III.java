/*
 * ============================================================
 * LEETCODE 557 - Reverse Words in a String III
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given a string s, reverse the order of characters in each word
 * within a sentence while still preserving whitespace and initial
 * word order.
 *
 * Examples:
 * Input: "Let's take LeetCode contest" → Output: "s'teL ekat edoCteeL tsetnoc"
 * Input: "Mr Ding"                    → Output: "rM gniD"
 *
 * TOPICS: Two Pointers, String
 * PATTERN: Two Pointers (within word boundaries)
 * DIFFICULTY: Easy
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. WORD-BY-WORD REVERSAL (O(n) time, O(n) or O(1) space) - OPTIMAL
 *    Split string by spaces, reverse each word, join with spaces.
 *    In-place modification possible with char array and two pointers
 *    per word.
 *
 * 2. STRINGBUILDER PER WORD (O(n) time, O(n) space)
 *    Build result string by iterating. When space or end reached,
 *    append reversed word. Simpler logic, uses extra space.
 *
 * 3. IN-PLACE TWO POINTERS (O(n) time, O(1) space)
 *    Convert to char array. Use two pointers to reverse each word
 *    in place. Track word boundaries with start/end indices.
 *
 * OPTIMAL SOLUTION: Approach 3 - In-place with two pointers per word
 * Key insight: Reverse each contiguous word segment independently
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Convert to char array or use string with indices
 * - Two pointers for each word
 * - stringstream or manual splitting
 *
 * GO:
 * - Use strings.Fields() to split words
 * - Reverse each word's runes
 * - strings.Join() to combine
 *
 * JAVASCRIPT:
 * - split(), reverse(), join() chain (ES6)
 * - Or use two pointers with char array
 * - for...of loop for iteration
 *
 * PYTHON:
 * - Split by space: str.split(' ')
 * - Reverse each word with slicing: word[::-1]
 * - Join: ' '.join()
 *
 * JAVA:
 * - Split by regex: s.split("\\s+")
 * - Reverse each word manually
 * - Use StringBuilder for result
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - TEXT FORMATTING: Reversing words in subtitles, text effects
 *   in presentations, RTL language processing.
 *
 * - PIG LATIN TRANSLATORS: Part of word manipulation in language
 *   learning applications.
 *
 * - SEARCH ENGINE FEATURES: Creating reversed indexes, autocomplete
 *   suffix-based suggestions.
 *
 * - CRYPTOGRAPHY: Simple transformations in ciphers, encoding
 *   schemes that reverse word order.
 *
 * - SENTIMENT ANALYSIS: Preprocessing text, handling emoticons
 *   and text variations.
 */

public class Solution {
    public String reverseWords(String s) {
        // Convert string to character array for in-place manipulation
        char[] arr = s.toCharArray();
        int len = arr.length;
        int sp = 0; // Start pointer for each word

        // Iterate through the array
        for (int ep = 0; ep <= len; ep++) {
            // When we reach the end of a word or the end of the string
            if (ep == len || arr[ep] == ' ') {
                int left = sp;
                int right = ep - 1;

                // Reverse the word between sp and ep
                while (left < right) {
                    char temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    left++;
                    right--;
                }

                // Move start pointer to the next word
                sp = ep + 1;
            }
        }

        // Convert character array back to string
        return new String(arr);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test case
        String s = "the sky is Blue";
        String result = solution.reverseWords(s);
        System.out.println("Reversed words: '" + result + "'"); // Output: "ehT yks si eulb"
    }
}