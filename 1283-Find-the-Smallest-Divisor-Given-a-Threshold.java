public class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = Integer.MIN_VALUE;

        // Find the maximum value in nums
        for (int i = 0; i < nums.length; i++) {
            end = Math.max(end, nums[i]);
        }

        // Perform binary search to find the smallest divisor
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if it's possible to divide nums with the divisor mid
            if (isPossible(mid, threshold, nums)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    // Helper method to check if the divisor is valid
    static boolean isPossible(int mid, int threshold, int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] / mid;

            if (nums[i] % mid != 0) {
                sum++;
            }
        }
        return sum <= threshold;
    }

    public static void main(String[] args) {
        // Test case
        Solution solution = new Solution();
        int[] nums = {1, 2, 5, 9}; // Array of numbers
        int threshold = 6; // Threshold value

        // Call smallestDivisor method
        int result = solution.smallestDivisor(nums, threshold);
        System.out.println("Smallest divisor: " + result);
    }
}
