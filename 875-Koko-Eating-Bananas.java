/*
 * ============================================================
 * LEETCODE 875 - Koko Eating Bananas
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Koko loves to eat bananas. There are n piles of bananas, pile[i]
 * has k_i bananas. Koko can decide her eating speed (bananas per hour).
 * Each hour, she chooses a pile and eats at most k bananas from it.
 * If the pile has less than k, she eats it all and doesn't eat again.
 * Koko can finish eating all bananas within h hours. Find minimum
 * eating speed k such that she can finish within h hours.
 *
 * Examples:
 * Input: piles = [3,6,7,11], h = 8     → Output: 4
 * Input: piles = [30,11,23,4,20], h = 5 → Output: 30
 * Input: piles = [30,11,23,4,20], h = 6 → Output: 23
 *
 * TOPICS: Array, Binary Search
 * PATTERN: Binary Search on Answer
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. BINARY SEARCH ON SPEED (O(n log(max))) time, O(1) space) - OPTIMAL
 *    Search for minimum speed k in range [1, max(piles)].
 *    For each mid, calculate hours = sum(ceil(pile/mid)).
 *    If hours <= h, speed works; search left. Else search right.
 *
 * 2. LINEAR SEARCH (O(n * max)) time, O(1) space)
 *    Try each speed from 1 to max, simulate and check.
 *    Simple but O(n*range) complexity.
 *
 * 3. MATHEMATICAL ESTIMATE (O(n) time, O(1) space)
 *    Use average or sum/h to estimate. Not always correct.
 *
 * OPTIMAL SOLUTION: Approach 1 - Binary search with hour calculation
 * Key insight: Hours required is monotonic decreasing with speed
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Binary search with int/long long
 * - (pile + speed - 1) / speed for ceiling
 * - std::max for finding max pile
 *
 * GO:
 * - Binary search with int64
 * - ceil formula: (pile + speed - 1) / speed
 * - for loop for hour calculation
 *
 * JAVASCRIPT:
 * - Binary search with number
 * - Math.ceil() or manual ceiling
 * - for loop for sum
 *
 * PYTHON:
 * - Binary search with int
 * - (pile + speed - 1) // speed for ceiling
 * - sum() with generator
 *
 * JAVA:
 * - Binary search with long for sums
 * - (pile + speed - 1) / speed
 * - for loop with hour count
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - RESOURCE CONSUMPTION: Finding minimum resource consumption
 *   rate to meet deadline, project management.
 *
 * - VIDEO BUFFERING: Finding minimum download speed to buffer
 *   video within time limit, streaming optimization.
 *
 * - WORKER SCHEDULING: Finding minimum number of workers
 *   to complete tasks within deadline.
 *
 * - DATA PROCESSING: Finding minimum processing rate
 *   to complete batch within time limit.
 *
 * - MACHINE LEARNING: Finding minimum learning iterations
 *   to complete training within time budget.
 */

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int res = -1, start = 1, end = Integer.MIN_VALUE;

        // Find the maximum number of bananas in any pile
        for (int i = 0; i < piles.length; i++) {
            end = Math.max(end, piles[i]);
        }

        // Perform binary search to find the minimum eating speed
        while (start <= end) {
            int mid = start + (end - start) / 2;

            long hoursCount = 0;

            // Calculate the total hours required to eat all bananas at speed 'mid'
            for (int i = 0; i < piles.length; i++) {
                hoursCount += piles[i] / mid;
                if (piles[i] % mid != 0) {
                    hoursCount++;
                }
            }

            // If hours exceed 'h', increase the eating speed
            if (hoursCount > h) {
                start = mid + 1;
            } else {
                // Otherwise, record the result and try smaller speeds
                res = mid;
                end = mid - 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // Test case
        Solution solution = new Solution();
        int[] piles = {3, 6, 7, 11}; // Piles of bananas
        int h = 8; // Hours to eat all bananas

        // Call minEatingSpeed method
        int result = solution.minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed: " + result);
    }
}