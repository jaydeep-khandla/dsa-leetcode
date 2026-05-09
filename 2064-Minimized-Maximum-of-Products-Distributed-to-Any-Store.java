/*
 * ============================================================
 * LEETCODE 2064 - Minimized Maximum of Products Distributed to Any Store
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * You are given n integer quantities representing the number of
 * products in each type. You have m stores. Distribute the n product
 * types to the m stores such that:
 * - Each store gets products of at most one product type
 * - Each store gets an integer number of products
 * - No store gets more than x products (x is to be minimized)
 * Find the minimum possible x.
 *
 * Examples:
 * Input: n = 6, quantities = [10, 6, 5, 3] → Output: 3
 * Input: n = 1, quantities = [5]           → Output: 5
 * Input: n = 2, quantities = [1, 1]       → Output: 1
 *
 * TOPICS: Array, Binary Search
 * PATTERN: Binary Search on Answer (allocation problem)
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. BINARY SEARCH ON MAX PRODUCTS (O(n log(max))) - OPTIMAL
 *    Search for minimum x in range [1, max(quantities)].
 *    For each mid, calculate required stores = sum(ceil(qty/mid)).
 *    If stores <= n, mid works; search left. Else search right.
 *
 * 2. LINEAR SEARCH (O(n * max)) time, O(1) space)
 *    Try each x from 1 to max, check condition.
 *    Simple but O(n*range) complexity.
 *
 * 3. MATHEMATICAL APPROACH (complex)
 *    Use formula to estimate bounds. Not practical.
 *
 * OPTIMAL SOLUTION: Approach 1 - Binary search with store counting
 * Key insight: If max x works, any larger x also works (monotonic)
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Binary search with long long for sums
 * - (qty + mid - 1) / mid for ceiling
 * - std::max for bounds
 *
 * GO:
 * - Binary search with int64 for large sums
 * - (qty + mid - 1) / mid for ceil
 * - for loop with sum calculation
 *
 * JAVASCRIPT:
 * - Binary search with number
 * - Math.ceil() or manual ceil
 * - for loop for counting
 *
 * PYTHON:
 * - Binary search with int
 * - (qty + mid - 1) // mid for ceil
 * - sum() for total calculation
 *
 * JAVA:
 * - Binary search with int (long for sums)
 * - (qty + mid - 1) / mid for ceiling
 * - for loop with sum accumulation
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - WAREHOUSE DISTRIBUTION: Minimizing maximum stock per
 *   warehouse while distributing products evenly.
 *
 * - RESOURCE ALLOCATION: Minimizing maximum load per server
 *   in distributed computing.
 *
 * - MANUFACTURING: Distributing batches to machines minimizing
 *   maximum batch size.
 *
 * - TEAM TASK分配: Distributing tasks among teams minimizing
 *   maximum load per team.
 *
 * - EVENT PLANNING: Allocating attendees to venues minimizing
 *   maximum attendees per venue.
 */

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