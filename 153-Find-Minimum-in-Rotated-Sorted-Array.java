/*
 * ============================================================
 * LEETCODE 153 - Find Minimum in Rotated Sorted Array
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Suppose an array of length n sorted in ascending order is rotated
 * between 1 and n times. Given the sorted array with unique elements,
 * find the minimum element. You must write an algorithm with O(log n)
 * time complexity.
 *
 * Examples:
 * Input: [3,4,5,1,2] → Output: 1
 * Input: [4,5,6,7,0,1,2] → Output: 0
 * Input: [11,13,15,17] → Output: 11
 *
 * TOPICS: Array, Binary Search
 * PATTERN: Binary Search (rotated array minimum)
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. BINARY SEARCH (O(log n) time, O(1) space) - OPTIMAL
 *    If nums[start] <= nums[mid], minimum is in right half (start = mid + 1).
 *    Otherwise, minimum is at mid or left (end = mid). Classic binary search
 *    for finding rotation point.
 *
 * 2. LINEAR SCAN (O(n) time, O(1) space)
 *    Find first element smaller than the first element.
 *    Simple but linear time.
 *
 * 3. MIN ELEMENT TRACKING (O(n) time, O(1) space)
 *    Track minimum while traversing. Same O(n) complexity.
 *
 * OPTIMAL SOLUTION: Approach 1 - Binary search exploiting sorted property
 * Key insight: Rotated array has two sorted halves; minimum is at pivot point
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - while loop with start < end condition
 * - Compare nums[mid] with nums[start]
 * - Move start or end accordingly
 *
 * GO:
 * - for loop with conditional logic
 * - Compare elements
 * - Return nums[start] or nums[end]
 *
 * JAVASCRIPT:
 * - while loop with binary search
 * - Compare arr[mid] with arr[start]
 * - Adjust start/end
 *
 * PYTHON:
 * - while loop with binary search
 * - Compare elements
 * - Return at loop exit
 *
 * JAVA:
 * - while loop with binary search
 * - Compare nums[mid] with nums[start]
 * - Math.min for tracking minimum
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - DATABASE INDEX ROTATION: Finding minimum timestamp in rotated
 *   time-series data, circular buffer minimum.
 *
 * - CALENDAR SYSTEMS: Finding earliest available slot in rotated
 *   schedule data, appointment scheduling.
 *
 * - ROUTING TABLES: Finding minimum cost route in rotated routing
 *   tables, network path optimization.
 *
 * - SENSOR DATA: Finding minimum value in rotated sensor readings,
 *   temperature/humidity monitoring systems.
 *
 * - GAME LEADERBOARDS: Finding lowest score in rotated sorted
 *   leaderboard data structures.
 */

class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while(start <= end){
            int mid = start + (end - start)/2;

            if (nums[start] <= nums[mid]){
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
        int[] test2 = {4,5,6,7,0,1,2};
        int[] test3 = {11,13,15,17};
        int[] test4 = {1,3,5};

        System.out.println(sol.findMin(test1)); // Expected: 1
        System.out.println(sol.findMin(test2)); // Expected: 0
        System.out.println(sol.findMin(test3)); // Expected: 11
        System.out.println(sol.findMin(test4)); // Expected: 1
    }
}