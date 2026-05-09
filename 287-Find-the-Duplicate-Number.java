/*
 * ============================================================
 * LEETCODE 287 - Find the Duplicate Number
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given an array of integers nums containing n + 1 integers where each
 * integer is in the range [1, n] inclusive. There is only one duplicate
 * number in nums, but it can be repeated more than once.
 * Find the single duplicate number.
 *
 * You must not modify the array and must use only O(1) extra space.
 *
 * Examples:
 * Input: [1, 3, 4, 2, 2] → Output: 2
 * Input: [3, 1, 3, 4, 2] → Output: 3
 * Input: [2, 2, 2, 2]    → Output: 2
 *
 * TOPICS: Array, Two Pointers, Binary Search, Bit Manipulation
 * PATTERN: Floyd's Tortoise and Hare (Cycle Detection)
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. FLOYD'S TORTOISE AND HARE (O(n) time, O(1) space) - OPTIMAL
 *    Treat array as linked list where nums[i] points to next index.
 *    Find cycle using slow/fast pointers. Find cycle entrance = duplicate.
 *    Phase 1: Find intersection point. Phase 2: Find entrance.
 *
 * 2. BINARY SEARCH ON COUNT (O(n log n) time, O(1) space)
 *    Binary search on value range [1, n]. Count elements <= mid.
 *    If count > mid, duplicate is in [1, mid], else [mid+1, n].
 *    Does not modify array but uses counting approach.
 *
 * 3. MARKING/NEGATION (O(n) time, O(1) space)
 *    Use array indices as markers. For each num, go to index abs(num)-1.
 *    If negative, found duplicate. Mark by negating.
 *    Modifies array temporarily but restores original.
 *
 * OPTIMAL SOLUTION: Approach 1 - Floyd's cycle detection
 * Key insight: Array with duplicates creates a cycle in index-based traversal
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Floyd's: Two pointers, while(slow != fast), then reset one pointer
 * - Binary: count <= mid using std::count_if
 * - Marking: abs() function, array manipulation
 *
 * GO:
 * - Floyd's: Two int variables as pointers
 * - Binary: Loop counting elements
 * - Math.Abs() for absolute value
 *
 * JAVASCRIPT:
 * - Floyd's: Two variables, while loop
 * - Binary: filter() or manual counting
 * - Math.abs() function
 *
 * PYTHON:
 * - Floyd's: Two variables following indices
 * - Binary: sum(1 for x in nums if x <= mid)
 * - abs() built-in
 *
 * JAVA:
 * - Floyd's: Two int pointers following indices
 * - Binary: Loop counting
 * - Math.abs() function
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - CYCLE DETECTION IN LINKED LISTS: Finding entry point of cycle
 *   in linked data structures, network routing analysis.
 *
 * - DUPLICATE DETECTION: Finding duplicate records in databases,
 *   identifying duplicate entries in ID systems.
 *
 * - NETWORK TOPOLOGY: Detecting cycles in network graphs,
 *   finding redundant connections in mesh networks.
 *
 * - MEMORY MANAGEMENT: Detecting memory leaks from circular references,
 *   garbage collection cycle detection.
 *
 * - CRYPTOGRAPHY: Finding collisions in hash functions,
 *   birthday paradox analysis in security systems.
 */

public class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int absValue = Math.abs(nums[i]);
            if (nums[absValue - 1] < 0) {
                return absValue;
            } else {
                nums[absValue - 1] = -nums[absValue - 1];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test case
        int[] nums = {1, 3, 4, 2, 2};
        int result = solution.findDuplicate(nums);
        System.out.println("The duplicate number is: " + result); // Output: 2
    }
}