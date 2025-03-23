public class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = Integer.MIN_VALUE;
        int end = 0;

        // Find the max weight and sum of weights
        for (int i = 0; i < weights.length; i++) {
            start = Math.max(start, weights[i]);
            end += weights[i];
        }

        // Perform binary search to find the minimum ship capacity
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int need = 1, current = 0;

            for (int weight : weights) {
                if (current + weight > mid) {
                    need++;
                    current = 0;
                }
                current += weight;
            }

            if (need > days) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        // Test case
        Solution solution = new Solution();
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        // Call shipWithinDays method
        int result = solution.shipWithinDays(weights, days);
        System.out.println("Minimum ship capacity: " + result);
    }
}
