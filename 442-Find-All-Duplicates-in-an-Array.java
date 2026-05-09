/*
 * ============================================================
 * LEETCODE 442 - Find All Duplicates in an Array
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given an integer array nums of length n where nums[i] is in the
 * range [1, n], each integer appears once or twice. Return an array
 * of all the integers that appears twice. You must write an algorithm
 * that runs in O(n) time and uses O(1) extra space.
 *
 * Examples:
 * Input: [4,3,2,7,8,2,3,1] → Output: [2,3]
 * Input: [1,1,2]           → Output: [1]
 * Input: [2,2]             → Output: [2]
 *
 * TOPICS: Array, Hash Table
 * PATTERN: In-place Marking with Negative Sign
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. IN-PLACE MARKING (O(n) time, O(1) space) - OPTIMAL
 *    For each number, go to its corresponding index (abs(num)-1).
 *    If that index's value is negative, it's a duplicate.
 *    Mark by negating the value at the index.
 *
 * 2. SORTING + SCAN (O(n log n) time, O(1) space)
 *    Sort the array first. Then scan adjacent pairs to find duplicates.
 *    Uses O(1) space but loses original order and O(n log n) time.
 *
 * 3. COUNTING ARRAY (O(n) time, O(n) space)
 *    Create frequency array of size n+1. Count occurrences.
 *    Find all indices with count 2. Uses O(n) extra space.
 *
 * 4. XOR APPROACH (doesn't work here)
 *    XOR cancels pairs but can't identify which specific numbers.
 *
 * OPTIMAL SOLUTION: Approach 1 - Mark visited indices with negation
 * Key insight: Use array values as indices, mark visited with negative sign
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Use abs() for absolute value
 * - Negative marking in array
 * - Check if nums[abs(num)-1] < 0
 *
 * GO:
 * - Use math.Abs() for float, manual for int
 * - Slice as array for in-place marking
 * - Convert to positive for indexing
 *
 * JAVASCRIPT:
 * - Use Math.abs() for absolute value
 * - Negative marking
 * - arr[Math.abs(num) - 1] < 0 check
 *
 * PYTHON:
 * - Use abs() for absolute value
 * - Negative marking in list
 * - nums[abs(num) - 1] < 0 check
 *
 * JAVA:
 * - Use Math.abs() for absolute value
 * - Negative marking with Math.abs()
 * - Check nums[Math.abs(num) - 1] < 0
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - DUPLICATE DETECTION IN DATABASES: Finding duplicate records
 *   in indexed columns, data deduplication.
 *
 * - QUALITY ASSURANCE: Finding duplicate test case IDs,
 *   identifying repeated error patterns in logs.
 *
 * - STUDENT GRADING: Finding students who submitted duplicate
 *   answers, detecting plagiarism in assignments.
 *
 * - SERIAL NUMBER VERIFICATION: Finding duplicate product
 *   serial numbers in inventory systems.
 *
 * - USER ID VALIDATION: Detecting duplicate user registrations,
 *   identifying fake accounts in systems.
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            int absValue = Math.abs(nums[i]);
            if (nums[absValue - 1] < 0) {
                duplicates.add(absValue);  // If the value is already negative, it's a duplicate
            }
            nums[absValue - 1] = -nums[absValue - 1];  // Mark the element as visited by negating the value
        }

        return duplicates;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test case
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = solution.findDuplicates(nums);
        System.out.println("The duplicate numbers are: " + result); // Output: [2, 3]
    }
}