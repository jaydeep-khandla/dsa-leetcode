/*
 * ============================================================
 * LEETCODE 48 - Rotate Image
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise) in-place.
 * You must modify the matrix in-place and cannot allocate
 * another 2D matrix.
 *
 * Examples:
 * Input: [[1,2,3],[4,5,6],[7,8,9]] → Output: [[7,4,1],[8,5,2],[9,6,3]]
 * Input: [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 *        → Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 * TOPICS: Array, Math, Matrix
 * PATTERN: Matrix Transpose + Row Reversal
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. TRANSPOSE THEN REVERSE ROWS (O(n^2) time, O(1) space) - OPTIMAL
 *    First transpose matrix (swap matrix[i][j] with matrix[j][i]).
 *    Then reverse each row. Results in 90-degree clockwise rotation.
 *
 * 2. REVERSE TOP TO BOTTOM THEN TRANSPOSE (O(n^2) time, O(1) space)
 *    First reverse rows top-to-bottom, then transpose.
 *    Also achieves 90-degree clockwise rotation.
 *
 * 3. ROTATE IN FOUR QUADRANTS (O(n^2) time, O(1) space)
 *    For each element, rotate 4 elements in a cycle.
 *    More complex but does one swap per 4 positions.
 *
 * OPTIMAL SOLUTION: Approach 1 - Transpose + row reversal
 * Key insight: 90-degree rotation = transpose + horizontal flip
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Two nested loops for transpose
 * - Two nested loops for row reversal
 * - std::swap for swapping elements
 *
 * GO:
 * - Two nested for loops
 * - Slice access with swap
 * - for i < n, for j = i+1 < n
 *
 * JAVASCRIPT:
 * - for loops for transpose
 * - Bracket notation for access
 * - temp variable for swap
 *
 * PYTHON:
 * - zip(*matrix) for transpose
 * - List comprehension for row reversal
 * - In-place modification
 *
 * JAVA:
 * - Two nested for loops for transpose
 * - Two nested for loops for row reversal
 * - temp variable for swapping
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - IMAGE PROCESSING: Rotating images in photo editors,
 *   90-degree orientation corrections.
 *
 * - GAME DEVELOPMENT: Rotating game boards, sprite animation
 *   frames, board game simulations.
 *
 * - COMPUTER GRAPHICS: 2D transformations, rotation matrices
 *   in rendering pipelines.
 *
 * - ROBOTICS: Rotating sensor readings, coordinate transformations
 *   in 2D path planning.
 *
 * - UI DESIGN: Rotating UI elements, icon transformations,
 *   responsive layout adjustments.
 */

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                
                left++;
                right--;
            }
        }
    }

    // Utility function to print the matrix
    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Original matrix:");
        sol.printMatrix(matrix);
        
        sol.rotate(matrix);
        
        System.out.println("Rotated matrix:");
        sol.printMatrix(matrix);
    }
}