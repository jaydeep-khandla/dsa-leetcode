/*
 * ============================================================
 * LEETCODE 125 - Valid Palindrome
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * A phrase is a palindrome if, after converting all uppercase letters into
 * lowercase letters and removing all non-alphanumeric characters, it reads
 * the same forward and backward. Given a string s, return true if it is a
 * palindrome, or false otherwise.
 *
 * Examples:
 * Input: "A man, a plan, a canal: Panama" → Output: true
 * Input: "race a car"                   → Output: false
 * Input: " "                            → Output: true
 *
 * TOPICS: Two Pointers, String
 * PATTERN: Two Pointers (left and right)
 * DIFFICULTY: Easy
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. TWO POINTERS WITH FILTERING (O(n) time, O(1) space) - OPTIMAL
 *    Use left and right pointers starting from both ends. Skip non-alphanumeric
 *    characters. Compare lowercase versions of alphanumeric chars. Return false
 *    on mismatch, true if pointers cross.
 *
 * 2. CLEAN STRING AND REVERSE COMPARE (O(n) time, O(n) space)
 *    Filter the string to keep only alphanumeric chars, convert to lowercase,
 *    then compare with its reverse. Simple but uses extra space.
 *
 * 3. DEQUE APPROACH (O(n) time, O(n) space)
 *    Add only alphanumeric characters to a deque from both ends.
 *    Compare elements from both ends. Same logic as two pointers.
 *
 * OPTIMAL SOLUTION: Approach 1 - Two pointers with in-place filtering
 * Key insight: Palindrome property - characters must match from both ends
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Use two indices (left, right) with string
 * - isalnum() and tolower() from <cctype>
 * - Increment/decrement indices
 *
 * GO:
 * - Use rune conversion for proper Unicode handling
 * - unicode.IsLetter(), unicode.IsDigit() for filtering
 * - unicode.ToLower() for case conversion
 *
 * JAVASCRIPT:
 * - Use two pointers with charCodeAt() for character codes
 * - Regular expressions with /[a-zA-Z0-9]/ for alphanumeric check
 * - toLowerCase() method for case conversion
 *
 * PYTHON:
 * - Use string indexing
 * - str.isalnum() for alphanumeric check
 * - str.lower() for lowercase conversion
 * - Two-pointer or reversed string comparison
 *
 * JAVA:
 * - Use Character.isLetterOrDigit() for filtering
 * - Character.toLowerCase() for case conversion
 * - Two pointers with charAt()
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - TEXT EDITORS: "Find and Replace" as palindrome detection,
 *   spell checker optimization, text analysis tools.
 *
 * - DNA SEQUENCE ANALYSIS: Palindromic sequences in genetics,
 *   restriction enzyme recognition sites in bioinformatics.
 *
 * - PASSWORD VALIDATION: Checking palindromic patterns in passwords
 *   for security compliance (often prohibited).
 *
 * - DATA COMPRESSION: Finding palindromic structures for compression
 *   algorithms, run-length encoding optimization.
 *
 * - SECURITY: Detecting palindromic injection attacks, input validation
 *   in authentication systems.
 */

class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0; 
        int last = s.length() - 1;
        while (start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currFirst)) {
                start++;
            } else if (!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example inputs to test
        String test1 = "A man, a plan, a canal: Panama";
        String test2 = "race a car";
        String test3 = " ";

        // Call the method and print results
        System.out.println(solution.isPalindrome(test1)); // Expected: true
        System.out.println(solution.isPalindrome(test2)); // Expected: false
        System.out.println(solution.isPalindrome(test3)); // Expected: true
    }
}