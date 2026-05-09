/*
 * ============================================================
 * LEETCODE 84 - Largest Rectangle in Histogram
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given an array of integers heights representing the histogram's
 * bar height where the width of each bar is 1, find the area of
 * the largest rectangle in the histogram.
 *
 * Examples:
 * Input: [2,1,5,6,2,3] → Output: 10 (height=2 from index 0 to 2)
 * Input: [2,4]        → Output: 4
 * Input: [6,2,5,4,5,1,6] → Output: 12 (height=4 from index 1 to 4)
 *
 * TOPICS: Array, Stack, Monotonic Stack
 * PATTERN: Monotonic Stack (Increasing)
 * DIFFICULTY: Hard
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. MONOTONIC STACK (O(n) time, O(n) space) - OPTIMAL
 *    Use stack storing indices of increasing heights. For each bar,
 *    pop while stack top height > current height.
 *    Calculate area using popped height as shortest bar.
 *    Add sentinel 0 at end to flush stack.
 *
 * 2. DIVIDE AND CONQUER (O(n log n) time, O(log n) space)
 *    Find minimum height bar, calculate area using it as shortest.
 *    Recursively solve left and right subarrays. More complex.
 *
 * 3. STACK WITH PREVIOUS SMALLER (O(n) time, O(n) space)
 *    Precompute previous smaller and next smaller indices,
 *    then calculate max area for each bar.
 *
 * OPTIMAL SOLUTION: Approach 1 - Monotonic stack with area calculation on pop
 * Key insight: Each bar is shortest height for range between where it can span
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Use std::stack<int> for indices
 * - Add 0 sentinel at end
 * - while loop for popping
 * - Calculate width from stack top
 *
 * GO:
 * - Use slice as stack
 * - Append sentinel at end
 * - while loop for calculations
 * - int64 for area if needed
 *
 * JAVASCRIPT:
 * - Use array as stack
 * - Push 0 sentinel
 * - while loop for popping
 * - Calculate area
 *
 * PYTHON:
 * - Use list as stack
 * - append() and pop()
 * - while loop for area calculation
 * - Use integers
 *
 * JAVA:
 * - Use int[] as stack (more efficient than Stack)
 * - Sentinel 0 at end
 * - while loop for popping
 * - Math.max for area tracking
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - HISTOGRAM ANALYSIS: Finding largest population cluster
 *   in data distribution analysis.
 *
 * - LANDSCAPE PLANNING: Finding largest rectangular building
 *   plot in irregular terrain.
 *
 * - STOCK CHART ANALYSIS: Finding largest support rectangle
 *   in candlestick charts.
 *
 * - WAREHOUSE DESIGN: Finding maximum rectangular storage
 *   area in irregular floor plans.
 *
 * - MEMORY ALLOCATION: Finding largest contiguous memory
 *   block in memory management.
 */

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] stack = new int[heights.length + 1];
        int top = -1;
        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int h = (i == n ? 0 : heights[i]);

            while (top != -1 && h < heights[stack[top]]) {
                int tp = heights[stack[top--]];
                int ps = top == -1 ? -1 : stack[top];
                maxArea = Math.max(maxArea, tp * (i - ps - 1));
            }

            stack[++top] = i;
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] heights = {2, 1, 5, 6, 2, 3};
        int result = sol.largestRectangleArea(heights);

        System.out.println("Largest rectangle area: " + result);
    }
}