/*
 * ============================================================
 * LEETCODE 268 - Missing Number
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 *
 * Examples:
 * Input: nums = [3, 0, 1]     → Output: 2
 * Input: nums = [0, 1]       → Output: 2
 * Input: nums = [9, 6, 4, 2, 3, 5, 7, 0, 1] → Output: 8
 *
 * TOPICS: Array, Hash Table, Math, Binary Search, Bit Manipulation
 * PATTERN: XOR or Sum Formula
 * DIFFICULTY: Easy
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. SUM FORMULA (O(n) time, O(1) space) - OPTIMAL
 *    Calculate expected sum = n*(n+1)/2 for range [0, n]. Subtract actual
 *    sum of array elements. Difference is the missing number.
 *    Simple arithmetic, handles all cases efficiently.
 *
 * 2. XOR APPROACH (O(n) time, O(1) space)
 *    XOR all indices (0 to n) and all array elements. XOR of missing
 *    number with itself cancels out, leaving the answer.
 *    Avoids potential overflow issues with large sums.
 *
 * 3. SORTING + SCAN (O(n log n) time, O(1) or O(n) space)
 *    Sort the array, then scan to find where nums[i] != i.
 *    Less efficient due to sorting.
 *
 * 4. HASH SET (O(n) time, O(n) space)
 *    Add all numbers to a set, then check which number in range
 *    [0, n] is missing. Uses extra space.
 *
 * OPTIMAL SOLUTION: Approach 1 - Sum formula (simple, intuitive)
 * Alternative: Approach 2 - XOR (avoids overflow, mathematically elegant)
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - SUM: Use long long for large n to avoid overflow, n*(n+1)/2 formula
 * - XOR: Use ^ operator, accumulate index ^ nums[i]
 * - Use std::accumulate for sum
 *
 * GO:
 * - SUM: Use int64 type casting for large values
 * - XOR: Use ^ operator, handles large ints with care
 * - for range loop
 *
 * JAVASCRIPT:
 * - SUM: Use reduce() or for loop, numbers are safe up to 2^53
 * - XOR: Use ^ operator
 * - for loop or reduce()
 *
 * PYTHON:
 * - SUM: Use sum() built-in, handles large integers natively
 * - XOR: Use ^ operator
 * - range() for indices
 *
 * JAVA:
 * - SUM: Use long for calculation, cast back to int if needed
 * - Math.abs() and arithmetic operations
 * - Traditional for loop
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - INVENTORY MANAGEMENT: Finding missing items in numbered inventory,
 *   tracking serialized products, warehouse management.
 *
 * - DATA RECONCILIATION: Detecting missing records in sequences,
 *   finding gaps in transaction IDs, audit trail analysis.
 *
 * - EXAM/SCORE ANALYSIS: Identifying unanswered question numbers,
 *   finding skipped questions in automated grading systems.
 *
 * - PERMUTATION VERIFICATION: Checking if a permutation of [0, n] is
 *   complete, validating Sudoku solutions.
 *
 * - MARSHALLING/DEMARSHALLING: Serialization protocols that include
 *   checksums based on expected sequence completeness.
 */

public class Solution {
    public int missingNumber(int[] nums) {
        int n =  nums.length;
        int exp = (n * (n + 1)) / 2;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return exp - sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test case
        int[] nums = {3, 0, 1};
        int result = solution.missingNumber(nums);
        System.out.println("The missing number is: " + result); // Output: 2
    }
}