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
