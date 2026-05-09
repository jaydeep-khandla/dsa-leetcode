/*
 * ============================================================
 * LEETCODE 121 - Best Time to Buy and Sell Stock
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * You are given an array prices where prices[i] is the price of a given stock on
 * the ith day. You want to maximize your profit by choosing a single day to buy
 * one stock and choosing a different day in the future to sell that stock. Return
 * the maximum profit. If no profit is possible, return 0.
 *
 * Examples:
 * Input: [7, 1, 5, 3, 6, 4] → Output: 5 (Buy at 1, Sell at 6)
 * Input: [7, 6, 4, 3, 1]   → Output: 0 (No valid transaction)
 * Input: [1, 2]            → Output: 1 (Buy at 1, Sell at 2)
 *
 * TOPICS: Arrays, Dynamic Programming, Greedy
 * PATTERN: One-Pass Traversal / Kadane's Algorithm Variant
 * DIFFICULTY: Easy
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. BRUTE FORCE (O(n²) time, O(1) space)
 *    Iterate through each day as potential buy day, then find the maximum sell
 *    price after that day. Compare all pairs to find maximum difference.
 *
 * 2. ONE-PASS - OPTIMAL (O(n) time, O(1) space)
 *    Track the minimum price seen so far while iterating. At each price, calculate
 *    potential profit by subtracting the minimum price. Update maximum profit if
 *    current profit is higher. This works because selling after buying is enforced
 *    by only considering prices after the minimum.
 *
 * 3. PEAK-VALLEY APPROACH (O(n) time, O(1) space)
 *    Find local minima (valleys) and maxima (peaks). The difference between a peak
 *    and its preceding valley is a candidate for maximum profit. Sum all upward
 *    movements between consecutive elements captures all profitable transactions.
 *
 * OPTIMAL SOLUTION: Approach 2 - One-Pass with minimum tracking
 * Key insight: Maximum profit = max(prices[i] - minPriceSeenBefore[i])
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Use std::vector<int> for array, INT_MAX from <climits>
 * - Track min_price with std::min, max_profit with std::max
 * - Single for-each loop iterating through vector
 *
 * GO:
 * - Use slice []int for array, math.MaxInt for initialization
 * - Use built-in min/max functions (Go 1.21+) or manually compare
 * - for range loop over slice
 *
 * JAVASCRIPT:
 * - Use standard array, Infinity constant for initialization
 * - Math.min() and Math.max() for comparisons
 * - for...of loop or traditional for loop
 *
 * PYTHON:
 * - Use list, float('inf') for initialization
 * - Built-in min() and max() functions
 * - for loop with enumerate() if index needed
 *
 * JAVA:
 * - Use int[] array, Integer.MAX_VALUE for initialization
 * - Math.min() and Math.max() methods
 * - Traditional for loop or enhanced for loop
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - STOCK MARKET ANALYSIS: Trading algorithms to find optimal buy/sell timing
 *   for maximum returns, basis for complex trading strategies.
 *
 * - FINANCIAL PORTFOLIO MANAGEMENT: Tools suggesting best times to buy/sell
 *   assets, cryptocurrency trading bots, robo-advisors.
 *
 * - INVENTORY MANAGEMENT: Finding best time to purchase inventory (lowest cost)
 *   and sell (highest revenue) in supply chain optimization.
 *
 * - PRICE TRACKING SYSTEMS: E-commerce price monitoring for best purchase
 *   windows - flight tickets, hotel bookings, product price drops.
 *
 * - RESOURCE ALLOCATION: Any scenario needing minimum cost before maximum
 *   benefit - job scheduling, server resource purchases, etc.
 */

public class Solution {

    // Method to calculate the maximum profit
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int buy = prices[0];
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
        }
        
        return profit;
    }

    // Main method to test the maxProfit function
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Test Case 1: " + solution.maxProfit(prices1));  // Expected output: 5

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Test Case 2: " + solution.maxProfit(prices2));  // Expected output: 0

        int[] prices3 = {1, 2};
        System.out.println("Test Case 3: " + solution.maxProfit(prices3));  // Expected output: 1
    }
}