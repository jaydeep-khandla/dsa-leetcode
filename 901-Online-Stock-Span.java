/*
 * ============================================================
 * LEETCODE 901 - Online Stock Span
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Design a StockSpanner class that collects daily price quotes for
 * some stock, and returns the span of that day's price. The span
 * is the number of consecutive days (starting from today and going
 * backward) where the price of the stock was less than or equal to
 * today's price.
 *
 * Examples:
 * Input: [100,80,60,70,60,75,85]
 * Output: [1,1,1,2,1,4,6]
 *
 * TOPICS: Stack, Design, Monotonic Stack
 * PATTERN: Monotonic Stack (non-increasing)
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. MONOTONIC STACK (amortized O(1) time, O(n) space) - OPTIMAL
 *    Use a stack storing pairs of (price, span). For each price,
 *    pop all smaller prices, accumulate their spans, push new pair.
 *    Each element is pushed and popped at most once (amortized O(1)).
 *
 * 2. NAIVE STACK (O(n) time per call, O(n) space)
 *    Store all prices in stack, for each price, pop and count while
 *    prices <= current. Simple but inefficient for large inputs.
 *
 * 3. ARRAY-BASED STACK (O(1) average time, O(n) space)
 *    Use array as stack with manual push/pop.
 *    Same logic as monotonic stack but manual implementation.
 *
 * OPTIMAL SOLUTION: Approach 1 - Monotonic stack with span accumulation
 * Key insight: Smaller prices don't affect span of future greater prices
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Use std::stack<pair<int, int>> for price-span pairs
 * - while loop for popping smaller prices
 * - push() new pair with accumulated span
 *
 * GO:
 * - Use struct for Stack with Pairs
 * - for loop with append/pop
 * - Return span for each price
 *
 * JAVASCRIPT:
 * - Use array as stack with push/pop
 * - Store [price, span] pairs
 * - for loop for span calculation
 *
 * PYTHON:
 * - Use list as stack
 * - Tuple (price, span) pairs
 * - while loop for popping
 *
 * JAVA:
 * - Use Stack<int[]> for pairs
 * - push() and pop() methods
 * - while loop for accumulation
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - STOCK MARKET ANALYSIS: Tracking consecutive days of price
 *   increases/decreases, support/resistance level identification.
 *
 * - WEATHER PATTERNS: Finding consecutive days of similar temperature,
 *   heat wave/cold snap detection.
 *
 * - DEMAND FORECASTING: Tracking consecutive high-demand periods,
 *   inventory planning based on demand streaks.
 *
 * - LOAD BALANCING: Finding consecutive periods of low/high load,
 *   auto-scaling trigger detection.
 *
 * - QUALITY CONTROL: Tracking consecutive passing tests,
 *   defect rate monitoring in manufacturing.
 */

import java.util.Stack;

public class Solution {
    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        stack.push(new int[]{price, span});
        return span;
    }

    public static void main(String[] args) {
        StockSpanner spanner = new StockSpanner();
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        for (int price : prices) {
            System.out.println("Next(" + price + ") = " + spanner.next(price));
        }
    }
}