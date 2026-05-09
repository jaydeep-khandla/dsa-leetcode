/*
 * ============================================================
 * LEETCODE 3289 - The Two Sneaky Numbers of Digitville
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * You are given an array nums of length n + 2. Each element in nums is
 * in the range [1, n]. There are exactly two numbers appearing once,
 * and all other numbers appear exactly twice.
 * Return the two numbers that appear only once in any order.
 *
 * Examples:
 * Input: [1, 2, 3, 2, 3, 4, 5, 5] → Output: [1, 4]
 * Input: [1, 2, 1, 2, 3, 3, 4, 5] → Output: [4, 5]
 * Input: [4, 1, 2, 1, 2, 3, 3]   → Output: [4, 3]
 *
 * TOPICS: Array, Bit Manipulation, Hash Table
 * PATTERN: XOR with Bit Masking
 * DIFFICULTY: Easy
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. HASH SET (O(n) time, O(n) space)
 *    Use a HashSet. If element already in set, remove it.
 *    Remaining elements are the unique ones.
 *    Simple and intuitive.
 *
 * 2. XOR WITH BIT MANIPULATION (O(n) time, O(1) space) - OPTIMAL
 *    XOR all elements. Result has 1s at bits where the two unique
 *    numbers differ. Find any set bit, use it to partition numbers
 *    into two groups. XOR each group to get the unique numbers.
 *
 * 3. SUM AND FORMULA (O(n) time, O(1) space)
 *    sum = a + b (unique numbers). Find one number via XOR bit trick.
 *    Compute a = (xor & -xor) mask, second = sum - a.
 *    Efficient but requires handling edge cases.
 *
 * OPTIMAL SOLUTION: Approach 2 - XOR with bit masking
 * Key insight: XOR of all elements cancels pairs, remaining bits show difference
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - XOR operator: ^
 * - Bit manipulation: (xor & -xor) for rightmost set bit
 * - Use long long if needed for large numbers
 *
 * GO:
 * - XOR operator: ^
 * - Bit manipulation with uint types
 * - int type handles most cases
 *
 * JAVASCRIPT:
 * - XOR operator: ^
 * - Bitwise AND: &
 * - Negative number trick: -x for two's complement
 *
 * PYTHON:
 * - XOR operator: ^
 * - x & (-x) for rightmost set bit
 * - Handle large integers naturally
 *
 * JAVA:
 * - XOR operator: ^
 * - Bitwise AND: &
 * - Math.abs() if needed for positive values
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - ERROR DETECTION: Finding unique error codes in log files,
 *   identifying single occurrences in duplicate data streams.
 *
 * - INVENTORY DIFFERENCE: Finding items that appear once among
 *   duplicates in warehouse inventory systems.
 *
 * - USER SESSION ANALYSIS: Identifying unique users among repeated
 *   sessions, tracking single-visit vs returning visitors.
 *
 * - DATA COMPARISON: Comparing two datasets to find elements
 *   present in one but not both, diff tools.
 *
 * - FREQUENCY ANALYSIS: Finding elements with odd occurrence counts,
 *   detecting anomalies in pattern analysis.
 */

import java.util.HashSet;

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        int[] res = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for(int i=0,j=0;i<n;i++){
            if(!set.isEmpty() && set.contains(nums[i])){
                res[j] = nums[i];
                j++;
            } else{
                set.add(nums[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example inputs to test
        int[] test1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2};
        int[] test2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 2, 3};
        int[] test3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 3, 4};

        // Call the method and print results
        int[] res1 = solution.getSneakyNumbers(test1);
        int[] res2 = solution.getSneakyNumbers(test2);
        int[] res3 = solution.getSneakyNumbers(test3);
        System.out.println(res1[0] + " " + res1[1]); // Expected: 1 1
        System.out.println(res2[0] + " " + res2[1]); // Expected: 2 2
        System.out.println(res3[0] + " " + res3[1]); // Expected: 3 3
    }  
}