/*
 * ============================================================
 * LEETCODE 1011 - Capacity To Ship Packages Within D Days
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * A conveyor belt has packages to be shipped, each with weights given
 * in an array. You are to ship the packages in d days. The belt has a
 * capacity. Find the least weight capacity so that all packages can
 * be shipped within d days.
 *
 * Examples:
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5     → Output: 15
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 6     → Output: 11
 * Input: weights = [3,2,2,4,7,10], days = 3            → Output: 7
 *
 * TOPICS: Array, Binary Search
 * PATTERN: Binary Search on Answer (Decision Problem)
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. BINARY SEARCH ON CAPACITY (O(n log(sum - max)) time, O(1) space) - OPTIMAL
 *    Search for minimum capacity in range [max(weights), sum(weights)].
 *    For each mid, simulate loading: accumulate weights, when sum > mid,
 *    start new day. Count required days. If days > d, need higher capacity.
 *
 * 2. GREEDY SIMULATION (O(n) time, O(1) space)
 *    Given capacity, greedily fill days until sum exceeds, then start new.
 *    This is the simulation used within binary search.
 *
 * 3. LINEAR SEARCH (O(n * (sum - max)) time, O(1) space)
 *    Try each capacity from max to sum. Simulate and find first valid.
 *    Inefficient, O(n*range) complexity.
 *
 * OPTIMAL SOLUTION: Approach 1 - Binary search with greedy simulation
 * Key insight: Capacity is monotonic - if capacity works, any higher works
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Binary search with long long for sums
 * - std::max and std::min for bounds
 * - Simulate with running sum
 *
 * GO:
 * - Binary search with int64
 * - math.MaxInt constant for bounds
 * - for loop with sum tracking
 *
 * JAVASCRIPT:
 * - Binary search with number type
 * - Math.max, Math.min for bounds
 * - for loop with day counting
 *
 * PYTHON:
 * - Binary search with int
 * - max() and sum() built-ins
 * - while loop for simulation
 *
 * JAVA:
 * - Binary search with int (use long for sum)
 * - Math.max, Math.min for bounds
 * - for loop with day counter
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - DELIVERY OPTIMIZATION: Finding minimum truck capacity for
 *   delivering packages within time constraints.
 *
 * - CLOUD COMPUTING: Finding minimum server capacity for processing
 *   jobs within deadline.
 *
 * - MANUFACTURING: Determining minimum machine capacity to complete
 *   production orders within time limits.
 *
 * - BANDWIDTH PLANNING: Allocating bandwidth for data transfer,
 *   ensuring completion within deadline.
 *
 * - RESOURCE ALLOCATION: Finding minimum resource allocation to
 *   complete tasks within time constraints.
 */

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