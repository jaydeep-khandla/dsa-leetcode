/*
 * ============================================================
 * LEETCODE 852 - Peak Index in a Mountain Array
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given an array arr that is strictly increasing first and then
 * strictly decreasing, find the peak index (the maximum element).
 * The array may have duplicate values. The array is mountain-like.
 *
 * You must solve it in O(log(n)) time.
 *
 * Examples:
 * Input: [0,1,0]     → Output: 1
 * Input: [0,2,1,0]   → Output: 1
 * Input: [0,10,5,2]   → Output: 1
 *
 * TOPICS: Array, Binary Search
 * PATTERN: Binary Search (mountain/peak finding)
 * DIFFICULTY: Easy
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. BINARY SEARCH FOR PEAK (O(log n) time, O(1) space) - OPTIMAL
 *    Find where array starts decreasing. If arr[mid] < arr[mid+1],
 *    peak is to the right. Otherwise, peak is at mid or left.
 *    Classic "find peak element" binary search.
 *
 * 2. LINEAR SCAN (O(n) time, O(1) space)
 *    Find first index where arr[i] > arr[i+1].
 *    Simple but linear time.
 *
 * 3. BUILT-IN MAX FIND (O(n) time, O(1) space)
 *    Find maximum element's index.
 *    Less efficient, doesn't use binary search.
 *
 * OPTIMAL SOLUTION: Approach 1 - Binary search exploiting monotonicity
 * Key insight: Peak is where increasing trend reverses to decreasing
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Binary search with mid comparison
 * - while(start < end) loop
 * - Return start or end when converged
 *
 * GO:
 * - Binary search logic
 * - Use start < end condition
 * - Return start index
 *
 * JAVASCRIPT:
 * - Binary search with mid < mid+1 check
 * - while loop structure
 * - Return start
 *
 * PYTHON:
 * - Binary search with mid < mid+1 check
 * - while start < end
 * - Return start
 *
 * JAVA:
 * - Binary search with mid < mid+1 check
 * - while loop with start < end
 * - Return start
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - PERFORMANCE OPTIMIZATION: Finding optimal resource allocation
 *   point, peak efficiency in systems.
 *
 * - PRICING OPTIMIZATION: Finding price that maximizes revenue,
 *   peak of demand curve.
 *
 * - PHYSICS SIMULATIONS: Finding maximum point in energy landscapes,
 *   identifying equilibrium states.
 *
 * - MACHINE LEARNING: Finding learning rate with best convergence,
 *   peak accuracy in hyperparameter tuning.
 *
 * - TERRAIN ANALYSIS: Finding mountain peaks in elevation data,
 *   topographic mapping applications.
 */

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example inputs to test
        int[] test1 = { 0, 1, 0 };
        int[] test2 = { 0, 2, 1, 0 };
        int[] test3 = { 0, 10, 5, 2 };
        int[] test4 = { 3, 4, 5, 1 };
        int[] test5 = { 24, 69, 100, 99, 79, 78, 67, 36, 26, 19 };

        // Call the method and print results
        System.out.println(solution.peakIndexInMountainArray(test1)); // Expected: 1
        System.out.println(solution.peakIndexInMountainArray(test2)); // Expected: 1
        System.out.println(solution.peakIndexInMountainArray(test3)); // Expected: 1
        System.out.println(solution.peakIndexInMountainArray(test4)); // Expected: 2
        System.out.println(solution.peakIndexInMountainArray(test5)); // Expected: 2
    }
}