/*
 * ============================================================
 * LEETCODE 448 - Find All Numbers Disappeared in an Array
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given an array nums of n integers where nums[i] is in the range [1, n],
 * some elements appear twice and others appear once. Find all the
 * elements of [1, n] that do not appear in this array. Do it without
 * extra space and in O(n) time.
 *
 * Examples:
 * Input: [4,3,2,7,8,2,3,1] → Output: [5,6]
 * Input: [1,1]            → Output: [2]
 * Input: [1,2,2,3,3,4]   → Output: [5,6]
 *
 * TOPICS: Array, Hash Table
 * PATTERN: In-place Marking / Cycle Sort
 * DIFFICULTY: Easy
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. CYCLE SORT / IN-PLACE PLACEMENT (O(n) time, O(1) space) - OPTIMAL
 *    Treat array as if it were placed in sorted position.
 *    For each position i, place nums[i] at index nums[i]-1 if possible.
 *    After sorting, any position where nums[i] != i+1 is missing that number.
 *
 * 2. MARKING WITH NEGATION (O(n) time, O(1) space)
 *    For each num, negate the value at index abs(num)-1.
 *    If already negative, skip. After traversal, indices not marked
 *    (positive values) represent missing numbers.
 *
 * 3. HASH SET (O(n) time, O(n) space)
 *    Add all numbers to a HashSet, then iterate from 1 to n,
 *    collecting numbers not in the set. Uses extra space.
 *
 * OPTIMAL SOLUTION: Approach 1 - Cycle sort to place elements in correct positions
 * Key insight: After cycle sort, positions with wrong values indicate missing numbers
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Cycle sort implementation with while loop
 * - Check nums[i] != i + 1 for missing detection
 * - vector<int> for result collection
 *
 * GO:
 * - For loop with cycle sort logic
 * - Compare with expected value
 * - append() to result slice
 *
 * JAVASCRIPT:
 * - Cycle sort with while loop
 * - Check nums[i] !== i + 1
 * - push() missing numbers to result array
 *
 * PYTHON:
 * - While loop for cycle sort
 * - Compare nums[i] != i + 1
 * - List appending
 *
 * JAVA:
 * - while loop with cycle sort logic
 * - Check nums[i] != i + 1
 * - ArrayList for result collection
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - ATTENDANCE SYSTEMS: Finding students absent from class,
 *   identifying missing entries in attendance records.
 *
 * - INVENTORY MANAGEMENT: Finding missing product IDs from
 *   expected range, detecting gaps in serial numbers.
 *
 * - FILE VERIFICATION: Finding missing sequence numbers in
 *   data packets, checking completeness of data streams.
 *
 * - TEST COVERAGE: Identifying untested code paths,
 *   finding gaps in test suites.
 *
 * - SCHEDULING: Finding available time slots not in use,
 *   detecting free resources in allocation systems.
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        cycleSort(nums);
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }

        return result;
    }

    static void cycleSort(int[] nums) {
        int n = nums.length;
        int index = 0;

        while (index < n) {
            int value = nums[index];
            int correctIndex = value - 1;

            if (nums[correctIndex] != nums[index]) {
                int temp = nums[correctIndex];
                nums[correctIndex] = value;
                nums[index] = temp;
            } else {
                index++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test case
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = solution.findDisappearedNumbers(nums);
        System.out.println("The disappeared numbers are: " + result); // Output: [5, 6]
    }
}