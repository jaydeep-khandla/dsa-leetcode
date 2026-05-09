/*
 * ============================================================
 * LEETCODE 503 - Next Greater Element II
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given a circular integer array nums (i.e., next element of nums[n-1]
 * is nums[0]), return the next greater number for every element in nums.
 * The next greater number of a number x is the first greater number to
 * its traversing order next in the array. If it doesn't exist, return -1.
 *
 * Examples:
 * Input: [1,2,1]    → Output: [2,-1,2]
 * Input: [1,2,3,4,3] → Output: [2,3,4,-1,4]
 *
 * TOPICS: Stack, Array, Monotonic Stack
 * PATTERN: Monotonic Stack with Circular Traversal
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. MONOTONIC STACK WITH CIRCULAR ARRAY (O(n) time, O(n) space) - OPTIMAL
 *    Use a stack storing indices of elements in decreasing order.
 *    Traverse array twice (using modulo for circular nature).
 *    For each element, pop from stack while current > stack's element.
 *    For elements in range [0, n), assign result.
 *
 * 2. TWO PASSES WITH STACK (O(n) time, O(n) space)
 *    First pass handles non-circular part. Second pass handles wrap-around.
 *    Less elegant but conceptually simple.
 *
 * 3. BRUTE FORCE WITH MODULO (O(n^2) time, O(1) space)
 *    For each element, search circularly for next greater.
 *    Simple but inefficient for large inputs.
 *
 * OPTIMAL SOLUTION: Approach 1 - Single pass with stack and circular indexing
 * Key insight: Traverse 2n elements, use modulo for circular access
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Use std::stack<int> for indices
 * - Modulo: i % n for circular access
 * - vector<int> result initialized with -1
 *
 * GO:
 * - Use slice as stack with append/pop
 * - Modulo operator % for circular indexing
 * - Make slice with -1 initialized
 *
 * JAVASCRIPT:
 * - Use array as stack with push/pop
 * - i % n for circular access
 * - Array.fill(-1) for initialization
 *
 * PYTHON:
 * - Use list as stack with append/pop
 * - i % n for circular access
 * - List comprehension with [-1] * n
 *
 * JAVA:
 * - Use Stack<Integer> or int[] as stack
 * - i % n for circular indexing
 * - int[] result with -1 initialization
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - STOCK PRICE ANALYSIS: Finding next higher price in circular
 *   time series, identifying resistance levels in trading.
 *
 * - TEMPERATURE MONITORING: Finding next hotter day in weather data,
 *   circular time period analysis.
 *
 * - ROUND-ROBIN SCHEDULING: Finding next available resource in
 *   circular queue systems, load balancer next-server selection.
 *
 * - CIRCULAR BUFFERS: Next greater element in ring buffer analysis,
 *   finding next available slot in circular data structures.
 *
 * - EVENT PROCESSING: Finding next event of higher priority in
 *   circular event queues, scheduling systems.
 */

import java.util.Stack;

public class Solution {
    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % nums.length]) {
                stack.pop();
            }

            if (i < nums.length) {
                if (stack.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peek();
                }
            }

            stack.push(nums[i % nums.length]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        int[] result = nextGreaterElements(nums);
        System.out.println("Next greater elements: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}