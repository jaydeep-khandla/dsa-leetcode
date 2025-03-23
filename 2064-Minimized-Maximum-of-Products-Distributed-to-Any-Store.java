public class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int start = 1;
        int end = Integer.MIN_VALUE;

        // Find the maximum quantity in the array
        for (int i = 0; i < quantities.length; i++) {
            end = Math.max(end, quantities[i]);
        }

        // Perform binary search to minimize the maximum number of items per group
        while (start < end) {
            int mid = start + (end - start) / 2;
            int total = 0;

            // Calculate how many groups are needed if the maximum items per group is 'mid'
            for (int i = 0; i < quantities.length; i++) {
                total += quantities[i] / mid;
                if (quantities[i] % mid != 0) {
                    total++;
                }
            }

            // If the total number of groups exceeds 'n', increase the minimum group size
            if (total > n) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }

    public static void main(String[] args) {
        // Test case
        Solution solution = new Solution();
        int n = 3; // Number of groups
        int[] quantities = {10, 20, 30, 40}; // Quantities to be divided

        // Call minimizedMaximum method
        int result = solution.minimizedMaximum(n, quantities);
        System.out.println("Minimized maximum: " + result);
    }
}
