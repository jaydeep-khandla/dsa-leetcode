/*
 * ============================================================
 * LEETCODE 1283 - Find the Smallest Divisor Given a Threshold
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given an array of integers nums and an integer threshold, we want to
 * find the smallest positive integer divisor such that upon dividing
 * all elements of the array by the divisor, the sum of the division
 * results is less than or equal to the threshold.
 * Each division result is rounded up to the nearest integer.
 *
 * Examples:
 * Input: nums = [1,2,5,9], threshold = 6    → Output: 5
 * Input: nums = [2,3,5,7,11], threshold = 8 → Output: 3
 * Input: nums = [19], threshold = 5         → Output: 4
 *
 * TOPICS: Array, Binary Search
 * PATTERN: Binary Search on Answer
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. BINARY SEARCH ON DIVISOR (O(n log(max(nums)))) time, O(1) space) - OPTIMAL
 *    Search divisor in range [1, max(nums)]. For each mid, compute
 *    sum = ceil(nums[i]/mid) for all i. If sum <= threshold, divisor works,
 *    search left half. Else, search right half.
 *
 * 2. LINEAR SEARCH (O(n * max(nums)) time, O(1) space)
 *    Try each divisor from 1 to max(nums), check condition.
 *    Simple but inefficient - O(n * range) complexity.
 *
 * 3. MATHEMATICAL APPROACH (complex)
 *    Use formula to estimate divisor bounds. Not practical.
 *
 * OPTIMAL SOLUTION: Approach 1 - Binary search on divisor value
 * Key insight: Sum is monotonic decreasing with divisor - larger divisor gives smaller sum
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Binary search on int range
 * - ceil division: (a + b - 1) / b
 * - std::max for finding max element
 *
 * GO:
 * - Binary search with int64 if needed
 * - Manual ceil: (num + divisor - 1) / divisor
 * - for loop for sum calculation
 *
 * JAVASCRIPT:
 * - Binary search with number
 * - Math.ceil() for rounding
 * - for loop for sum
 *
 * PYTHON:
 * - Binary search with int
 * - math.ceil() or (num + divisor - 1) // divisor
 * - sum() with generator expression
 *
 * JAVA:
 * - Binary search with int
 * - Manual ceil: (num + mid - 1) / mid
 * - for loop with sum accumulation
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - RESOURCE DISTRIBUTION: Finding minimum allocation per unit
 *   to meet total budget constraints.
 *
 * - DATA COMPRESSION: Finding compression level (divisor) to meet
 *   size threshold.
 *
 * - QUALITY CONTROL: Finding minimum quality threshold that
 *   maintains total defect budget.
 *
 * - NETWORK BANDWIDTH: Allocating bandwidth units to meet total
 *   throughput requirements.
 *
 * - ENERGY MANAGEMENT: Finding minimum power allocation per
 *   component to stay within energy budget.
 */

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