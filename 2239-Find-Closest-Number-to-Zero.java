/*
 * ============================================================
 * LEETCODE 2239 - Find Closest Number to Zero
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given an integer array nums, return the number with the value closest to 0.
 * If there are multiple numbers equally close to zero, return the positive
 * number with the highest value.
 *
 * Examples:
 * Input: [-4, -2, 1, 4, 8]  → Output: 1
 * Input: [2, -1, 1]        → Output: 1  (both -1 and 1 are distance 1, return 1)
 * Input: [0, -1, 2]       → Output: -1 (0 is distance 0, but return -1 if tie)
 *
 * TOPICS: Array
 * PATTERN: Linear Scan with Distance Tracking
 * DIFFICULTY: Easy
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. SINGLE PASS - TRACK MINIMUM DISTANCE (O(n) time, O(1) space) - OPTIMAL
 *    Track the number with minimum absolute distance to zero. On tie
 *    (same distance), prefer the positive number. Handle 0 as special case.
 *
 * 2. SORTING APPROACH (O(n log n) time, O(1) space)
 *    Sort by absolute value, then return the first element. If first is
 *    negative and second is positive with same absolute value, return positive.
 *    Less efficient due to sorting.
 *
 * 3. TWO PASSES (O(n) time, O(1) space)
 *    First pass finds minimum absolute value. Second pass finds positive
 *    number with that distance. More passes but clear logic.
 *
 * OPTIMAL SOLUTION: Approach 1 - Single pass with tie-breaking logic
 * Key insight: Track minimum distance, break ties preferring positive numbers
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Use std::abs() for absolute value
 * - Compare distances with abs()
 * - std::max() for tie-breaking
 *
 * GO:
 * - Use math.Abs() for float64, manual abs for int
 * - Compare using absolute value
 * - Ternary or conditional for tie-breaking
 *
 * JAVASCRIPT:
 * - Use Math.abs() for absolute value
 * - Math.max() for tie-breaking
 * - Traditional for loop
 *
 * PYTHON:
 * - Use abs() built-in function
 * - Conditional expression for tie-breaking
 * - for loop iterating through list
 *
 * JAVA:
 * - Use Math.abs() for absolute value
 * - Math.max() for tie-breaking
 * - Traditional for loop
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - PROXIMITY SENSORS: Finding closest reading to target value,
 *   GPS coordinate nearest to reference point.
 *
 * - FINANCIAL ANALYSIS: Finding interest rate closest to target,
 *   currency exchange rate nearest to reference value.
 *
 * - SCIENTIFIC MEASUREMENTS: Finding temperature/pressure reading
 *   closest to desired setpoint in control systems.
 *
 * - GAME AI: Evaluating moves closest to optimal value, finding
 *   nearest target position for pathfinding.
 *
 * - CALIBRATION SYSTEMS: Finding calibration value closest to
 *   standard reference, adjusting measurements to nominal values.
 */

class Solution {
    public int findClosestNumber(int[] nums) {
        int dis = Integer.MAX_VALUE, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = Math.abs(nums[i]);

            if (dis < tmp) continue;

            if (dis == tmp) ans = Math.max(ans, nums[i]);

            if (dis > tmp) {
                dis = tmp;
                ans = nums[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example test cases
        int[] nums1 = {1, -1, 2, -2, 3};
        int[] nums2 = {5, 6, -7, -8, 9};
        
        System.out.println("Closest number to zero in nums1: " + sol.findClosestNumber(nums1)); // Should print: 1
        System.out.println("Closest number to zero in nums2: " + sol.findClosestNumber(nums2)); // Should print: 6
    }
}