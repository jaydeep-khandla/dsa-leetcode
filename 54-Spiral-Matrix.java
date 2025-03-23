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
