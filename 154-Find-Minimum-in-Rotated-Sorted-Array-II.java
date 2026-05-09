/*
 * ============================================================
 * LEETCODE 154 - Find Minimum in Rotated Sorted Array II
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Suppose an array of length n sorted in ascending order is rotated
 * between 1 and n times. Given the sorted array (may contain duplicates),
 * find the minimum element. Required: O(log n) average, O(n) worst case.
 *
 * Examples:
 * Input: [3,4,5,1,2]   → Output: 1
 * Input: [2,2,2,0,2]   → Output: 0
 * Input: [3,1,3,3]     → Output: 1
 *
 * TOPICS: Array, Binary Search
 * PATTERN: Binary Search with Duplicate Handling
 * DIFFICULTY: Hard
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. BINARY SEARCH WITH DUPLICATE HANDLING (O(log n) avg, O(n) worst, O(1) space) - OPTIMAL
 *    When nums[start] == nums[mid] == nums[end], can't determine direction.
 *    Increment start and decrement end to skip duplicates. Then proceed
 *    with standard binary search logic.
 *
 * 2. LINEAR SCAN (O(n) time, O(1) space)
 *    Find first element smaller than previous. Simple but linear worst case.
 *
 * 3. MODIFIED BINARY SEARCH (O(log n) average, O(1) space)
 *    Similar to 153, but handle duplicates by skipping equal elements
 *    at boundaries.
 *
 * OPTIMAL SOLUTION: Approach 1 - Binary search with duplicate skipping
 * Key insight: Duplicates make binary decision impossible; skip them
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - while loop with start < end
 * - Check for duplicates with three-way comparison
 * - Increment/decrement for duplicates
 *
 * GO:
 * - for loop with conditional logic
 * - Duplicate skipping with start++/end--
 * - Compare elements
 *
 * JAVASCRIPT:
 * - while loop with binary search
 * - Duplicate detection with triple equality
 * - Increment/decrement for skipping
 *
 * PYTHON:
 * - while loop with binary search
 * - Check for duplicates
 * - Slice adjustment
 *
 * JAVA:
 * - while loop with binary search
 * - Three-way equality check
 * - Increment/decrement indices
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - SENSOR FUSION: Finding minimum from sensors with duplicate
 *   readings, calibration data analysis.
 *
 * - FINANCIAL DATA: Finding minimum price in datasets with
 *   duplicate entries, stock price analysis with repeated values.
 *
 * - DATABASE QUERIES: Finding minimum timestamp in logs with
 *   duplicate timestamps.
 *
 * - ROUND-ROBIN TOURNAMENTS: Finding minimum score when multiple
 *   teams have same score.
 *
 * - MEDICAL DATA: Analyzing test results with duplicate readings,
 *   finding minimum value in repeated measurements.
 */

class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while(start <= end){
            int mid = start + (end - start)/2;

            if (nums[start] == nums[mid] && nums[end] == nums[mid]){
                min = Math.min(min, nums[mid]);
                start++;
                end--;
            } else if (nums[start] <= nums[mid]){
                min = Math.min(min, nums[start]);
                start = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                end = mid - 1;
            }
        }

        return min;
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        int[] test1 = {3,4,5,1,2};
        int[] test2 = {4,5,6,7,0,1,2, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
        int[] test3 = {11,13,15,17};
        int[] test4 = {1,3,5};

        System.out.println(sol.findMin(test1)); // Expected: 1
        System.out.println(sol.findMin(test2)); // Expected: 0
        System.out.println(sol.findMin(test3)); // Expected: 11
        System.out.println(sol.findMin(test4)); // Expected: 1
    }
}