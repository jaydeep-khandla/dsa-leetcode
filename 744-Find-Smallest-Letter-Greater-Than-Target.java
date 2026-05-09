/*
 * ============================================================
 * LEETCODE 744 - Find Smallest Letter Greater Than Target
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given a characters array letters that is sorted in non-decreasing
 * order and a character target, return the smallest character in
 * letters that is strictly greater than target.
 * You may assume that all letters in letters are lowercase.
 *
 * Examples:
 * Input: letters = ['c', 'f', 'j'], target = 'a' → Output: 'c'
 * Input: letters = ['c', 'f', 'j'], target = 'c' → Output: 'f'
 * Input: letters = ['c', 'f', 'j'], target = 'j' → Output: 'c' (wrap)
 *
 * TOPICS: Array, Binary Search
 * PATTERN: Binary Search (upper bound)
 * DIFFICULTY: Easy
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. BINARY SEARCH (O(log n) time, O(1) space) - OPTIMAL
 *    Find the first element > target. Use modified binary search.
 *    If target >= last element, wrap around to first element.
 *
 * 2. LINEAR SCAN (O(n) time, O(1) space)
 *    Iterate through array, return first letter > target.
 *    If none found, return first element (wrap).
 *
 * 3. BUILT-IN BINARY SEARCH (language-specific)
 *    Use language's upper bound or bisect functions.
 *    C++: upper_bound, Python: bisect_right
 *
 * OPTIMAL SOLUTION: Approach 1 - Binary search for upper bound
 * Key insight: Find first element strictly greater than target
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - std::upper_bound for upper bound
 * - Or manual binary search with char comparisons
 * - char type handling
 *
 * GO:
 * - Manual binary search
 * - bytes.IndexByte() for simple cases
 * - for loop with binary search
 *
 * JAVASCRIPT:
 * - Manual binary search
 * - for loop with char code comparison
 * - charCodeAt() for character codes
 *
 * PYTHON:
 * - bisect module: bisect_right()
 * - Or manual binary search
 * - List of characters
 *
 * JAVA:
 * - Manual binary search
 * - Compare chars directly
 * - char array handling
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - LEXICOGRAPHIC SEARCH: Finding next word in dictionary,
 *   autocomplete systems with sorted word lists.
 *
 * - GRADING SYSTEMS: Finding next letter grade above cutoff,
 *   grade boundary calculations.
 *
 * - CALENDAR SYSTEMS: Finding next available date/time slot,
 *   scheduling next meeting after given time.
 *
 * - FREQUENCY ALLOCATION: Finding next available channel above
 *   current frequency in radio spectrum management.
 *
 * - INVENTORY SORTING: Finding next higher-priced item,
 *   catalog browsing with price filtering.
 */

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ans = letters[0];
        int start = 0;
        int end = letters.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
                ans = letters[mid];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example inputs to test
        char[] test1 = { 'c', 'f', 'j' };
        char target1 = 'a';
        char[] test2 = { 'c', 'f', 'j' };
        char target2 = 'c';
        char[] test3 = { 'c', 'f', 'j' };
        char target3 = 'd';
        char[] test4 = { 'c', 'f', 'j' };
        char target4 = 'g';
        char[] test5 = { 'c', 'f', 'j' };
        char target5 = 'j';
        char[] test6 = { 'c', 'f', 'j' };
        char target6 = 'k';
        char[] test7 = { 'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n' };
        char target7 = 'e';

        // Call the method and print results
        System.out.println(solution.nextGreatestLetter(test1, target1)); // Expected: c
        System.out.println(solution.nextGreatestLetter(test2, target2)); // Expected: f
        System.out.println(solution.nextGreatestLetter(test3, target3)); // Expected: f
        System.out.println(solution.nextGreatestLetter(test4, target4)); // Expected: j
        System.out.println(solution.nextGreatestLetter(test5, target5)); // Expected: c
        System.out.println(solution.nextGreatestLetter(test6, target6)); // Expected: c
        System.out.println(solution.nextGreatestLetter(test7, target7)); // Expected: n
    }
}