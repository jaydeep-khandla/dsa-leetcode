/*
 * ============================================================
 * LEETCODE 2373 - Largest Local Values in a Matrix
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * You are given an n x n integer matrix grid. For each 3x3 submatrix
 * centered at row r and column c (where 3 <= n <= 100), find the
 * maximum value in that submatrix. Return a matrix of size (n-2) x (n-2)
 * containing these maximum values.
 *
 * Examples:
 * Input: [[9,9,8,1],[5,6,2,3],[4,7,0,1],[3,4,5,6]]
 *        → Output: [[9,9],[7,7]]
 * Input: [[1,1,1,1,1],[2,2,2,2,2],[3,3,3,3,3],[4,4,4,4,4],[5,5,5,5,5]]
 *        → Output: [[4,4,4],[4,4,4],[4,4,4]]
 *
 * TOPICS: Array, Matrix, Enumeration
 * PATTERN: 3x3 Submatrix Enumeration
 * DIFFICULTY: Easy
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. BRUTE FORCE ENUMERATION (O(n^2) time, O(1) space per cell, O(n^2) space) - OPTIMAL
 *    For each possible 3x3 center (i from 1 to n-2, j from 1 to n-2),
 *    iterate through 9 cells, find maximum, store in result matrix.
 *
 * 2. SLIDING WINDOW WITH MAX (O(n^2) time, O(1) space)
 *    Similar approach but could optimize with precomputed row maxima.
 *    Not necessary for this problem size.
 *
 * 3. DIVIDE AND CONQUER (O(n^2) time, O(n) space)
 *    Find 3x3 maximum using segment tree or similar.
 *    Overkill for n <= 100.
 *
 * OPTIMAL SOLUTION: Approach 1 - Direct 3x3 enumeration for each center
 * Key insight: Only 9 cells per submatrix, enumerate all centers
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Two nested loops for result matrix
 * - Nested loops for 3x3 window (9 comparisons)
 * - Math.max for comparisons
 *
 * GO:
 * - Nested loops for result
 * - 3x3 nested loops
 * - max() function
 *
 * JAVASCRIPT:
 * - Two nested for loops
 * - 3x3 inner loops
 * - Math.max chain
 *
 * PYTHON:
 * - Two nested for loops
 * - 3x3 inner loops
 * - max() function
 *
 * JAVA:
 * - Two nested for loops
 * - 3x3 inner loops with Math.max
 * - int[][] for result
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - IMAGE PROCESSING: Finding local maxima in pixel grids,
 *   feature detection in images.
 *
 * - SMOOTHING/FILTERING: Local maximum filtering for noise
 *   reduction in signal processing.
 *
 * - GAME AI: Finding best move in local neighborhood,
 *   pathfinding heuristics.
 *
 * - ENVIRONMENTAL DATA: Finding peak pollution levels
 *   in local regions, temperature analysis.
 *
 * - SOCIAL NETWORKS: Finding influential nodes in local
 *   neighborhoods, community detection.
 */

public class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;

        int[][] result = new int[n-2][n-2];

        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < n-2; j++) {
                int max = findMax(grid, i, j);
                result[i][j] = max;
            }
        }

        return result;
    }

    static int findMax(int[][] grid, int row, int col) {
        int max = Integer.MIN_VALUE;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test case
        int[][] grid = {
            {9, 9, 8, 1},
            {5, 6, 2, 3},
            {4, 7, 9, 0},
            {7, 2, 6, 4}
        };
        int[][] result = solution.largestLocal(grid);

        // Print the result matrix
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}