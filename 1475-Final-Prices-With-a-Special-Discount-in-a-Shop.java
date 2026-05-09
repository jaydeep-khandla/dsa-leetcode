/*
 * ============================================================
 * LEETCODE 1475 - Final Prices With a Special Discount in a Shop
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * You are given an array prices where prices[i] is the price of the
 * i-th item in a store. There is a special discount: for the i-th item,
 * you can get a discount equal to the first price to the right that is
 * smaller than or equal to prices[i]. If there is no such price, discount is 0.
 * Apply the discount and return the final prices.
 *
 * Examples:
 * Input: [8,4,6,2,3] → Output: [4,2,4,2,3] (8-4=4, 4-0=4, 6-2=4, 2-0=2, 3-0=3)
 * Input: [1,2,3,4,5] → Output: [1,2,3,4,5]
 * Input: [10,1,1,6]  → Output: [9,0,1,6]
 *
 * TOPICS: Array, Stack, Monotonic Stack
 * PATTERN: Next Smaller Element (Monotonic Stack)
 * DIFFICULTY: Easy
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. MONOTONIC STACK (O(n) time, O(n) space) - OPTIMAL
 *    Use a stack storing indices of elements in non-increasing order.
 *    For each element, pop smaller elements and apply discount.
 *    Remaining elements have no discount.
 *
 * 2. BRUTE FORCE (O(n^2) time, O(1) space)
 *    For each element, find first smaller to the right via linear search.
 *    Simple but inefficient - O(n^2) worst case.
 *
 * 3. NESTED LOOPS (O(n^2) time, O(1) space)
 *    Same as brute force with explicit nested loops.
 *    Not efficient for large inputs.
 *
 * OPTIMAL SOLUTION: Approach 1 - Monotonic stack for next smaller element
 * Key insight: Stack maintains candidates for future discounts
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Use std::stack<int> for indices
 * - while loop for popping smaller elements
 * - Update array in-place
 *
 * GO:
 * - Use slice as stack
 * - append() to push, slice[:len-1] to pop
 * - for loop with stack logic
 *
 * JAVASCRIPT:
 * - Use array as stack with push/pop
 * - while loop for popping smaller
 * - Update array in-place
 *
 * PYTHON:
 * - Use list as stack
 * - append() and pop()
 * - for loop with range
 *
 * JAVA:
 * - Use Stack<Integer> or int[] as stack
 * - while loop for stack operations
 * - Direct array modification
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - RETAIL PRICE OPTIMIZATION: Applying store-wide discounts,
 *   loyalty program calculations.
 *
 * - TAX CALCULATION: Finding next lower tax bracket,
 *   cumulative tax calculations.
 *
 * - TICKETING SYSTEMS: Applying loyalty discounts to tickets,
 *   seat selection with price adjustments.
 *
 * - E-COMMERCE: Dynamic pricing with discount codes,
 *   automatic price reduction applications.
 *
 * - SUBSCRIPTION SERVICES: Applying tiered discounts,
 *   monthly billing with adjustments.
 */

public class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }

        return prices;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices = {8, 4, 6, 2, 3};
        int[] result = sol.finalPrices(prices);

        System.out.println("Final prices after discount:");
        for (int price : result) {
            System.out.print(price + " ");
        }
    }
}