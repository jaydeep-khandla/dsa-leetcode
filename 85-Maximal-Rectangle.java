/*
 * ============================================================
 * LEETCODE 85 - Maximal Rectangle
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given a 2D binary matrix (0 and 1), find the largest rectangle
 * containing only 1's and return its area.
 *
 * Examples:
 * Input: [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 6 (rectangle from (1,1) to (2,4))
 *
 * TOPICS: Array, Stack, Matrix, Dynamic Programming
 * PATTERN: Histogram Row-by-Row (Using 84)
 * DIFFICULTY: Hard
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. HISTOGRAM APPROACH (O(m*n) time, O(n) space) - OPTIMAL
 *    Treat each row as base of histogram. For each row, calculate
 *    heights of 1s above (cumulative). Apply Largest Rectangle in
 *    Histogram (problem 84) to each row. Track maximum area.
 *
 * 2. DP-BASED (O(m*n) time, O(n) space)
 *    Use three DP arrays: left (nearest left 0), right (nearest right 0),
 *    height (consecutive 1s). Calculate area for each cell using heights.
 *    More complex but works similarly.
 *
 * 3. BRUTE FORCE (O(m^2 * n^2) time, O(m*n) space)
 *    Check all sub-rectangles, count 1s. Extremely inefficient.
 *
 * OPTIMAL SOLUTION: Approach 1 - Row-by-row histogram with stack
 * Key insight: Convert 2D to 1D histogram problem for each row
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Create heights array from matrix
 * - Update heights row by row
 * - Call histogram function
 * - Track maximum area
 *
 * GO:
 * - Slice for heights
 * - Update based on matrix rows
 * - Histogram calculation
 * - Return max area
 *
 * JAVASCRIPT:
 * - Array for heights
 * - Update with char comparison
 * - Histogram calculation
 * - Track max
 *
 * PYTHON:
 * - List for heights
 * - Update based on row values
 * - Call histogram function
 * - Use max()
 *
 * JAVA:
 * - int[] heights array
 * - Update in for loop
 * - Call largestRectangleArea
 * - Track maxArea
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - IMAGE PROCESSING: Finding largest white region in
 *   binary images, connected component analysis.
 *
 * - LAND USE PLANNING: Finding largest rectangular region
 *   for construction in irregular plots.
 *
 * - DIGITAL CIRCUIT DESIGN: Finding largest rectangular
 *   area of gates in VLSI chip design.
 *
 * - GAME BOARDS: Finding largest empty rectangle in
 *   grid-based games, Tetris-like analysis.
 *
 * - DATABASE STORAGE: Finding largest contiguous block
 *   of storage in fragmented storage systems.
 */

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int[] heights = new int[matrix[0].length];
        int largest = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int val = matrix[i][j] - '0';
                if (val == 0) {
                    heights[j] = 0;
                } else {
                    heights[j] += val;
                }
            }

            int maxArea = largestRectangleArea(heights);
            if (largest < maxArea) {
                largest = maxArea;
            }
        }

        return largest;
    }

    static int largestRectangleArea(int[] heights) {
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
        char[][] matrix = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        int result = sol.maximalRectangle(matrix);
        System.out.println("Maximal rectangle area: " + result);
    }
}