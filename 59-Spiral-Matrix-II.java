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
