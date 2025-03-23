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
