public class Solution {
    public int largestRectangleArea(int[] heights) {
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
        int[] heights = {2, 1, 5, 6, 2, 3};
        int result = sol.largestRectangleArea(heights);

        System.out.println("Largest rectangle area: " + result);
    }
}
