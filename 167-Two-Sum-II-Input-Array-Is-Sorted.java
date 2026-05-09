/*
 * ============================================================
 * LEETCODE 167 - Two Sum II - Input Array Is Sorted
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given a 1-indexed array of integers numbers that is already sorted in
 * non-decreasing order, find two numbers such that they add up to a specific
 * target number. Return the indices of the two numbers (1-indexed).
 * You may assume that each input would have exactly one solution.
 *
 * Examples:
 * Input: numbers = [2, 7, 11, 15], target = 9   → Output: [1, 2]
 * Input: numbers = [2, 3, 4], target = 6        → Output: [1, 3]
 * Input: numbers = [-1, 0], target = -1        → Output: [1, 2]
 *
 * TOPICS: Array, Two Pointers, Binary Search
 * PATTERN: Two Pointers (Opposite Direction)
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. TWO POINTERS (O(n) time, O(1) space) - OPTIMAL
 *    Use left pointer at start and right pointer at end. If sum > target,
 *    move right pointer left. If sum < target, move left pointer right.
 *    Since array is sorted, this guarantees finding the pair.
 *
 * 2. BINARY SEARCH FOR EACH ELEMENT (O(n log n) time, O(1) space)
 *    For each element at index i, binary search for (target - nums[i])
 *    in the remaining array. Less efficient than two pointers.
 *
 * 3. HASH MAP / SET (O(n) time, O(n) space)
 *    Store visited numbers with their indices. For each number, check if
 *    complement exists. Works but uses extra space.
 *
 * OPTIMAL SOLUTION: Approach 1 - Two pointers exploiting sorted property
 * Key insight: In sorted array, moving pointers inward systematically explores all pairs
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Use vector<int> and two index variables
 * - while (left < right) loop structure
 * - Return vector<int> with adjusted indices
 *
 * GO:
 * - Use slice for array, two index variables
 * - for loop with condition
 * - Return slice of integers
 *
 * JAVASCRIPT:
 * - Use array, two index variables
 * - while loop or for loop
 * - Return array with adjusted indices
 *
 * PYTHON:
 * - Use list, two index variables
 * - while loop with left < right
 * - Return list [left+1, right+1] for 1-indexed
 *
 * JAVA:
 * - Use int[] array, two int variables
 * - while loop structure
 * - Return new int[]{left+1, right+1}
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - TWO-SUM IN FINANCIAL DATA: Finding trading pairs that match target
 *   values in stock prices, currency exchange rates.
 *
 * - RESOURCE MATCHING: Allocating resources where two requirements sum
 *   to available capacity - server load balancing, task assignment.
 *
 * - DATA VALIDATION: Finding pairs in sorted data that satisfy
 *   constraints - range queries, validation checks.
 *
 * - ANOMALY DETECTION: Finding data pairs with specific sum patterns
 *   in fraud detection systems.
 *
 * - MEETING SCHEDULING: Finding time slots that sum to available hours,
 *   matching availability between two calendars.
 */

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1}; // Return 1-based indices
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[]{-1, -1}; // If no solution found
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example input
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        // Call the method
        int[] result = solution.twoSum(numbers, target);

        // Print the result
        System.out.println(Arrays.toString(result));
    }
}