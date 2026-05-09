/*
 * ============================================================
 * LEETCODE 977 - Squares of a Sorted Array
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given an integer array nums sorted in non-decreasing order, return
 * an array of the squares of each number, also sorted in non-decreasing order.
 *
 * Examples:
 * Input: [-4, -1, 0, 3, 10]     → Output: [0, 1, 9, 16, 100]
 * Input: [-7, -3, 2, 3, 11]    → Output: [4, 9, 9, 49, 121]
 * Input: [-5, -4, -3, -2, -1]  → Output: [1, 4, 9, 16, 25]
 *
 * TOPICS: Array, Two Pointers, Sorting
 * PATTERN: Two Pointers (from both ends)
 * DIFFICULTY: Easy
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. TWO POINTERS FROM ENDS (O(n) time, O(n) space) - OPTIMAL
 *    Use left pointer at start and right pointer at end.
 *    Compare absolute values, square the larger one, place at
 *    result's end position. Work backwards filling result array.
 *
 * 2. SQUARE ALL AND SORT (O(n log n) time, O(n) space)
 *    Square every element, then sort the result.
 *    Simple but inefficient due to sorting step.
 *
 * 3. TWO POINTERS FORWARD WITH INSERTION (O(n^2) time, O(n) space)
 *    Square and insert into sorted position. Inefficient due to
 *    insertion overhead.
 *
 * OPTIMAL SOLUTION: Approach 1 - Two pointers comparing absolute values
 * Key insight: Largest squares are at either end of sorted input (by absolute value)
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Use vector<int> result(n)
 * - Fill from back: result[i--] = ...
 * - abs() for absolute value
 *
 * GO:
 * - Use make([]int, n) for result
 * - Index moving backward
 * - No built-in abs, manual implementation
 *
 * JAVASCRIPT:
 * - Use Array(n).fill(0)
 * - Fill from end using index
 * - Math.abs() function
 *
 * PYTHON:
 * - Use [0] * n or list comprehension
 * - Negative index for reverse fill
 * - abs() built-in
 *
 * JAVA:
 * - Use int[n] for result array
 * - Fill from end: result[i--] = ...
 * - Math.abs() for absolute value
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - DISTANCE CALCULATIONS: Squaring coordinates for Euclidean distance,
 *   finding points by distance from origin.
 *
 * - PHYSICS SIMULATIONS: Kinetic energy (1/2 * m * v^2), calculating
 *   magnitudes in vector calculations.
 *
 * - SIGNAL PROCESSING: Power calculations, RMS (root mean square)
 *   values in audio/electrical signals.
 *
 * - GRAPHICS: Normalizing vectors, calculating dot products,
 *   distance between pixels in image processing.
 *
 * - FINANCIAL MODELS: Variance calculations in statistics,
 *   calculating standard deviation from mean deviations.
 */

import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1;
 
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[i] = nums[left] * nums[left];
                left++;
            } else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example input
        int[] nums = {-4, -1, 0, 3, 10};
        
        // Call the method
        int[] sortedSquares = solution.sortedSquares(nums);
        
        // Print the result
        System.out.println(Arrays.toString(sortedSquares));
    }
}