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
