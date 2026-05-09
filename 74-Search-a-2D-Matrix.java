/*
 * ============================================================
 * LEETCODE 74 - Search a 2D Matrix
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Write an efficient algorithm that searches for a value in an
 * m x n matrix. This matrix has properties:
 * - Integers in each row are sorted from left to right
 * - The first integer of each row is greater than the last integer of the previous row
 *
 * Examples:
 * Input: [[1,3,11,15],[2,5,8,12],[4,9,10,13],[7,10,14,17]] target = 5
 *        → Output: true
 * Input: [[1,3,11,15],[2,5,8,12],[4,9,10,13],[7,10,14,17]] target = 14
 *        → Output: true
 *
 * TOPICS: Array, Binary Search, Matrix
 * PATTERN: Two-Level Binary Search or Staircase Search
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. STAIRCASE SEARCH (O(m+n) time, O(1) space)
 *    Start from top-right or bottom-left corner.
 *    If current > target, move left. If current < target, move down.
 *    Works because of sorted property of rows and columns.
 *
 * 2. BINARY SEARCH (O(log(m*n)) time, O(1) space) - OPTIMAL
 *    Treat 2D matrix as 1D sorted array using index mapping.
 *    Binary search on range [0, m*n-1]. Convert index to row/col.
 *    Standard binary search on virtual array.
 *
 * 3. DOUBLE BINARY SEARCH (O(log m + log n) time, O(1) space)
 *    Binary search on rows to find correct row, then binary search in that row.
 *    Less optimal than single binary search.
 *
 * OPTIMAL SOLUTION: Approach 2 - Binary search on virtual 1D array
 * Key insight: Treat as sorted 1D array with index mapping
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Binary search with mid calculation
 * - Convert: row = mid / n, col = mid % n
 * - Compare with target
 *
 * GO:
 * - Binary search on virtual index
 * - Index to row/col conversion
 * - for loop with binary search
 *
 * JAVASCRIPT:
 * - Binary search implementation
 * - index = mid // cols, index % cols
 * - Compare values
 *
 * PYTHON:
 * - Binary search on flattened view
 * - row, col = divmod(mid, n)
 * - while loop with binary search
 *
 * JAVA:
 * - Binary search implementation
 * - row = mid / cols, col = mid % cols
 * - while loop structure
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - DATABASE INDEXES: Searching sorted indexes in database
 *   systems, B-tree traversal.
 *
 * - EXCEL/SPREADSHEET: Finding values in sorted Excel columns,
 *   VLOOKUP optimization.
 *
 * - INVENTORY SYSTEMS: Finding items in sorted warehouse
 *   grid systems, bin location lookup.
 *
 * - FLIGHT SCHEDULES: Finding flights by departure time in
 *   sorted time slots, booking systems.
 *
 * - VIDEO/IMAGE COMPRESSION: Finding frames in compressed
 *   video streams, keyframe search.
 */

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int r = 0;
        int c = cols - 1;
        while (r < rows && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] < target) {
                r += 1;
            } else {
                c -= 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test case
        int[][] matrix = {
            {1, 4, 7, 11},
            {2, 5, 8, 12},
            {3, 6, 9, 16},
            {10, 13, 14, 17}
        };
        int target = 5;
        boolean result = solution.searchMatrix(matrix, target);
        System.out.println("Target " + target + " found: " + result); // Output: true
    }
}