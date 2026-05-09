/*
 * ============================================================
 * LEETCODE 59 - Spiral Matrix II
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given a positive integer n, generate an n x n matrix filled
 * with elements from 1 to n^2 in spiral order.
 *
 * Examples:
 * Input: n = 3 → Output: [[1,2,3],[8,9,4],[7,6,5]]
 * Input: n = 4 → Output: [[1,2,3,4],[12,13,14,5],[11,16,15,6],[10,9,8,7]]
 *
 * TOPICS: Array, Matrix, Simulation
 * PATTERN: Spiral Generation with Boundary Tracking
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. DIRECTION-BASED GENERATION (O(n^2) time, O(n^2) space) - OPTIMAL
 *    Use four boundaries (top, bottom, left, right) and four directions.
 *    Fill matrix in spiral order, shrinking boundaries after each direction.
 *    Track current number to fill.
 *
 * 2. LAYER-BY-LAYER (O(n^2) time, O(n^2) space)
 *    Fill each layer/ring from outside to inside.
 *    For each layer, fill top row, right column, bottom row, left column.
 *
 * 3. SIMULATION WITH DIRECTION VECTOR (O(n^2) time, O(n^2) space)
 *    Use direction vectors and boundary checks.
 *    Change direction when hitting boundary or filled cell.
 *
 * OPTIMAL SOLUTION: Approach 1 - Boundary tracking with sequential filling
 * Key insight: Same logic as Spiral Matrix I, but fill instead of collect
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - 2D vector initialization
 * - Four boundary variables
 * - for loops for each direction
 * - Increment counter for each fill
 *
 * GO:
 * - 2D slice initialization
 * - Four boundary variables
 * - for loops with counter
 * - Fill matrix in place
 *
 * JAVASCRIPT:
 * - 2D array with Array(n).fill()
 * - Boundary tracking
 * - for loops with counter
 * - Fill array
 *
 * PYTHON:
 * - 2D list with list comprehension
 * - Four boundary variables
 * - for loops
 * - Assign values
 *
 * JAVA:
 * - 2D int array initialization
 * - Four boundary variables
 * - for loops
 * - matrix[row][col] = val
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - SEATING ARRANGEMENTS: Generating seat numbers in theater
 *   or stadium in spiral pattern.
 *
 * - SPRAY PAINTING ROBOTS: Path planning for spiral coverage
 *   of surfaces, painting algorithms.
 *
 * - GAME GRID GENERATION: Creating spiral-numbered game boards,
 *   Sudoku spiral patterns.
 *
 * - SPIRAL ANTENNA DESIGN: Creating spiral array indices,
 *   electromagnetic applications.
 *
 * - DOCUMENT SCANNING: Generating spiral path through document
 *   scanner array, image acquisition.
 */

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int val = 1;

        int sc = 0, ec = matrix[0].length - 1;
        int sr = 0, er = matrix.length - 1;

        while (sr <= er && sc <= ec) {
            for (int j = sc; j <= ec; j++) {
                matrix[sr][j] = val;
                val++;
            }

            sr++;

            for (int i = sr; i <= er; i++) {
                matrix[i][ec] = val;
                val++;
            }

            ec--;

            if (sr <= er) {
                for (int j = ec; j >= sc; j--) {
                    matrix[er][j] = val;
                    val++;
                }

                er--;
            }

            if (sc <= ec) {
                for (int i = er; i >= sr; i--) {
                    matrix[i][sc] = val;
                    val++;
                }

                sc++;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test case
        int n = 3;
        int[][] result = solution.generateMatrix(n);

        // Print the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}