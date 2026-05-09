/*
 * ============================================================
 * LEETCODE 33 - Search in Rotated Sorted Array
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * There is an integer array nums sorted in ascending order (with distinct
 * values). The array was rotated between 1 and n times. Given the array
 * and a target value, return the index of target if it is in nums,
 * otherwise return -1. Must have O(log n) time complexity.
 *
 * Examples:
 * Input: [4,5,6,7,0,1,2], target = 0  → Output: 4
 * Input: [4,5,6,7,0,1,2], target = 3  → Output: -1
 * Input: [1], target = 0              → Output: -1
 *
 * TOPICS: Array, Binary Search
 * PATTERN: Binary Search with Rotated Array Handling
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. MODIFIED BINARY SEARCH (O(log n) time, O(1) space) - OPTIMAL
 *    Determine which half is properly sorted at each step.
 *    If left half sorted (nums[start] <= nums[mid]):
 *      - Check if target in left half, else search right
 *    Else: right half is sorted
 *      - Check if target in right half, else search left
 *
 * 2. FIND PIVOT + TWO SEARCHES (O(log n) time, O(1) space)
 *    First find pivot (minimum element), then search in
 *    appropriate half with standard binary search.
 *
 * 3. LINEAR SEARCH (O(n) time, O(1) space)
 *    Scan array for target. Simple but linear time.
 *
 * OPTIMAL SOLUTION: Approach 1 - Modified binary search
 * Key insight: One half is always sorted in rotated array
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - while loop with start <= end
 * - Check sorted half with nums[start] <= nums[mid]
 * - Conditional adjustments for target range
 *
 * GO:
 * - for loop with binary search logic
 * - Check sorted half condition
 * - Adjust start/end based on target
 *
 * JAVASCRIPT:
 * - while loop structure
 * - nums[start] <= nums[mid] check
 * - Target range validation
 *
 * PYTHON:
 * - while loop with binary search
 * - Conditional for sorted half
 * - Index adjustments
 *
 * JAVA:
 * - while loop with start <= end
 * - nums[start] <= nums[mid] for sorted check
 * - Range-based target location
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - SEARCH ENGINE CACHING: Finding rotated index in circular
 *   cache systems, LRU cache implementation.
 *
 * - DATABASE INDEX ROTATION: Finding values in rotated
 *   B-tree indexes, key-value store lookups.
 *
 * - CALENDAR SYSTEMS: Finding appointments in rotated
 *   daily schedule data.
 *
 * - IMAGE ROTATION: Finding pixel values in rotated
 *   image matrices.
 *
 * - GAME DEVELOPMENT: Finding elements in circular game
 *   boards, tile-based map searches.
 */

class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[start] <= nums[mid]){
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

        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] test1 = {4,5,6,7,0,1,2};
        int target1 = 0;
        int[] test2 = {4,5,6,7,0,1,2};
        int target2 = 3;
        int[] test3 = {1};
        int target3 = 0;
        int[] test4 = {1,3};
        int target4 = 3;

        System.out.println(sol.search(test1, target1)); // Expected: 4
        System.out.println(sol.search(test2, target2)); // Expected: -1
        System.out.println(sol.search(test3, target3)); // Expected: -1
        System.out.println(sol.search(test4, target4)); // Expected: 1
        
    }
}