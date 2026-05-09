/*
 * ============================================================
 * LEETCODE 34 - Find First and Last Position of Element in Sorted Array
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given an array of integers nums sorted in non-decreasing order,
 * find the starting and ending position of a given target value.
 * If target is not found, return [-1, -1]. Must have O(log n) time.
 *
 * Examples:
 * Input: [5,7,7,8,8,10], target = 8   → Output: [3,4]
 * Input: [5,7,7,8,8,10], target = 6   → Output: [-1,-1]
 * Input: [], target = 0               → Output: [-1,-1]
 * Input: [1], target = 1              → Output: [1,1]
 *
 * TOPICS: Array, Binary Search
 * PATTERN: Binary Search for Boundaries (First and Last)
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. TWO BINARY SEARCHES (O(log n) time, O(1) space) - OPTIMAL
 *    First binary search for first occurrence (when found, search left).
 *    Second binary search for last occurrence (when found, search right).
 *    Combine results into [start, end].
 *
 * 2. MODIFIED SINGLE BINARY SEARCH (O(log n) time, O(1) space)
 *    Find any occurrence, then expand left and right to find boundaries.
 *    Less efficient for very large arrays.
 *
 * 3. LINEAR SCAN (O(n) time, O(1) space)
 *    Find first and last by scanning entire array.
 *    Simple but O(n) time.
 *
 * OPTIMAL SOLUTION: Approach 1 - Separate searches for first and last
 * Key insight: Binary search naturally finds boundaries by adjusting search direction
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Two functions: findFirst(), findLast()
 * - Binary search with boundary tracking
 * - Return pair or vector<int>
 *
 * GO:
 * - Two helper functions for first/last
 * - Binary search logic
 * - Return array of two ints
 *
 * JAVASCRIPT:
 * - Separate binary searches for boundaries
 * - Track ans variable during search
 * - Return array
 *
 * PYTHON:
 * - Two binary searches
 * - bisect_left and bisect_right concepts
 * - Return list [first, last]
 *
 * JAVA:
 * - Two static methods for searches
 * - Binary search with left/right adjustments
 * - Return int[] array
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - DATABASE INDEX QUERIES: Finding range of matching records,
 *   date range queries on indexed columns.
 *
 * - LOG ANALYSIS: Finding start and end of error occurrences,
 *   time-series event detection.
 *
 * - RESOURCE MANAGEMENT: Finding all available slots in a
 *   schedule, booking system range queries.
 *
 * - SENSOR DATA: Finding all readings in a value range,
 *   threshold-based event detection.
 *
 * - TEXT SEARCH: Finding all occurrences of word in document,
 *   range of line numbers for search results.
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int[] ans = new int[2];

        ans[0] = binarySearchFirstOccurence(nums, target);
        ans[1] = binarySearchLastOccurence(nums, target);

        return ans;
        
    }

    static int binarySearchFirstOccurence(int[] arr, int key) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                ans = mid;
                end = mid - 1;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    static int binarySearchLastOccurence(int[] arr, int key) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                ans = mid;
                start = mid + 1;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example inputs to test
        int[] test1 = {5,7,7,8,8,10};
        int target1 = 8;
        int[] test2 = {5,7,7,8,8,10};
        int target2 = 6;
        int[] test3 = {};
        int target3 = 0;

        // Call the method and print results
        int[] res1 = solution.searchRange(test1, target1);
        int[] res2 = solution.searchRange(test2, target2);
        int[] res3 = solution.searchRange(test3, target3);
        System.out.println(res1[0] + " " + res1[1]); // Expected: 3 4
        System.out.println(res2[0] + " " + res2[1]); // Expected: -1 -1
        System.out.println(res3[0] + " " + res3[1]); // Expected: -1 -1
    }
}