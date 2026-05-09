/*
 * ============================================================
 * LEETCODE 81 - Search in Rotated Sorted Array II
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * There is an integer array nums sorted in non-decreasing order
 * (may contain duplicates). The array was rotated between 1 and n times.
 * Given an integer target, return true if target is in nums,
 * otherwise return false. Must have O(log n) average time.
 *
 * Examples:
 * Input: [2,5,6,0,0,1,2], target = 0 → Output: true
 * Input: [2,5,6,0,0,1,2], target = 3 → Output: false
 * Input: [1,1,1,1,1,1,1] target = 1  → Output: true
 *
 * TOPICS: Array, Binary Search
 * PATTERN: Binary Search with Duplicate Handling
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. MODIFIED BINARY SEARCH (O(log n) avg, O(n) worst, O(1) space) - OPTIMAL
 *    Same as 33 but handle duplicates: if nums[start] == nums[mid] == nums[end],
 *    increment start and decrement end to skip duplicates.
 *    Then proceed with standard binary search logic.
 *
 * 2. TWO-PASS WITH DUPLICATE SKIP (O(log n) avg, O(n) worst, O(1) space)
 *    Skip duplicates at boundaries first, then perform binary search.
 *    Similar logic, different implementation order.
 *
 * 3. LINEAR SEARCH (O(n) time, O(1) space)
 *    Scan array for target. Simple but linear time worst case.
 *
 * OPTIMAL SOLUTION: Approach 1 - Binary search with duplicate skipping
 * Key insight: Duplicates make binary decision impossible; skip them
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - while loop with start <= end
 * - Three-way duplicate check
 * - Increment/decrement for duplicates
 * - Standard binary search after
 *
 * GO:
 * - for loop with binary search logic
 * - Duplicate detection with triple check
 * - start++ and end-- for skipping
 *
 * JAVASCRIPT:
 * - while loop structure
 * - Duplicate check with triple equality
 * - Index adjustments
 *
 * PYTHON:
 * - while loop with binary search
 * - Duplicate handling with start/end adjustment
 * - Continue after skip
 *
 * JAVA:
 * - while loop with start <= end
 * - Three-way equality check
 * - Increment/decrement indices
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - REPEATED DATA SEARCH: Finding targets in datasets with
 *   duplicate entries, log file search.
 *
 * - DATABASE QUERIES: Searching indexed columns with duplicates,
 *   range queries on non-unique indexes.
 *
 * - SENSOR FUSION: Finding values in noisy sensor readings,
 *   duplicate measurement handling.
 *
 * - STOCK HISTORICAL DATA: Searching price history with
 *   repeated values, tick data analysis.
 *
 * - TEXT SEARCH: Finding patterns in text with repeated
 *   characters, DNA sequence matching.
 */

class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return true;
            }

            if (nums[start] == nums[mid] && nums[end] == nums[mid]){
                start++;
                end--;
            } else if (nums[start] <= nums[mid]){
                if (target >= nums[start] && target <= nums[mid]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[end]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] test1 = {2,5,6,0,0,1,2};
        int target1 = 0;
        int[] test2 = {2,5,6,0,0,1,2};
        int target2 = 3;
        int[] test3 = {1};
        int target3 = 0;
        int[] test4 = {1,3, 8, 9, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int target4 = 3;

        System.out.println(sol.search(test1, target1)); // Expected: true
        System.out.println(sol.search(test2, target2)); // Expected: false
        System.out.println(sol.search(test3, target3)); // Expected: false
        System.out.println(sol.search(test4, target4)); // Expected: true
        
    }
}