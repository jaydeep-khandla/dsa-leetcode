/*
 * ============================================================
 * LEETCODE 54 - Spiral Matrix
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given an m x n matrix, return all elements of the matrix in
 * spiral order (clockwise spiral starting from top-left).
 *
 * Examples:
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 *        → Output: [1,2,3,6,9,8,7,4,5]
 * Input: [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 *        → Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * TOPICS: Array, Matrix, Simulation
 * PATTERN: Boundary Traversal with Direction Changes
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. DIRECTION-BASED TRAVERSAL (O(m*n) time, O(1) space) - OPTIMAL
 *    Use four boundaries (top, bottom, left, right) and four directions
 *    (right, down, left, up). Traverse in current direction until hitting
 *    boundary, then shrink boundary and change direction.
 *
 * 2. LAYER-BY-LAYER (O(m*n) time, O(1) space)
 *    Process each layer/ring of the matrix from outside to inside.
 *    For each layer, traverse top row, right column, bottom row, left column.
 *
 * 3. DIRECTION VECTOR APPROACH (O(m*n) time, O(1) space)
 *    Use direction vectors and visited set.
 *    Mark visited cells, change direction when blocked.
 *    Less efficient due to visited tracking.
 *
 * OPTIMAL SOLUTION: Approach 1 - Boundary tracking with direction changes
 * Key insight: Four boundaries define traversable area, shrink after each pass
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Four variables for boundaries
 * - while loop with direction control
 * - for loops for each direction
 * - List or vector for result
 *
 * GO:
 * - Four boundary variables
 * - for loop with direction logic
 * - Append to slice
 * - break when boundaries cross
 *
 * JAVASCRIPT:
 * - Boundary tracking
 * - Array for result
 * - for loops for each direction
 * - push() for adding elements
 *
 * PYTHON:
 * - Boundary variables
 * - for loops for traversal
 * - append() to list
 * - break condition check
 *
 * JAVA:
 * - Four int variables for boundaries
 * - while loop with direction counter
 * - for loops for each pass
 * - ArrayList for result
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - FILE ENUMERATION: Traversing directory structures in
 *   spiral pattern, listing files layer by layer.
 *
 * - IMAGE PROCESSING: Spiral scanning of image matrices,
 *   pixel access patterns for convolution.
 *
 * - GAME MAPS: Spiral exploration in games, fog of war
 *   reveal mechanics.
 *
 * - ROBOT PATH PLANNING: Spiral search patterns for
 *   coverage algorithms, warehouse robots.
 *
 * - DATA VISUALIZATION: Displaying matrices in spiral order
 *   in spreadsheets, data presentation.
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();

        int sc = 0, ec = matrix[0].length - 1;
        int sr = 0, er = matrix.length - 1;

        while (sr <= er && sc <= ec) {
            for (int i = sc; i <= ec; i++) {
                result.add(matrix[sr][i]);
            }

            sr++;

            for (int i = sr; i <= er; i++) {
                result.add(matrix[i][ec]);
            }

            ec--;

            if (sr <= er) {
                for (int j = ec; j >= sc; j--) {
                    result.add(matrix[er][j]);
                }

                er--;
            }

            if (sc <= ec) {
                for (int i = er; i >= sr; i--) {
                    result.add(matrix[i][sc]);
                }

                sc++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test case
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        List<Integer> result = solution.spiralOrder(matrix);
        System.out.println("Spiral order: " + result); // Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }
}