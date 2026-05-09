/*
 * ============================================================
 * LEETCODE 2558 - Take Gifts From the Richest Pile
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * You are given an integer array gifts. On each step, you select the
 * pile with the maximum number of gifts, take exactly k gifts from it,
 * and put them back (divide by 2, rounded down). You repeat this until
 * every pile has at most k gifts.
 * Return the total number of gifts in the bags after infinite steps.
 *
 * Examples:
 * Input: gifts = [25,64,9,4,100], k = 4   → Output: 29
 * Input: gifts = [1,1,1,1], k = 4          → Output: 4
 * Input: gifts = [5,2,1,3], k = 3          → Output: 4
 *
 * TOPICS: Array, Heap, Simulation
 * PATTERN: Max-Heap Simulation
 * DIFFICULTY: Easy
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. MAX-HEAP SIMULATION (O(n log n) time, O(n) space) - OPTIMAL
 *    Use max-heap (priority queue) to always get largest pile.
 *    Pop, add k gifts, push sqrt(pile), repeat while pile > k.
 *    Sum remaining piles.
 *
 * 2. SORTING SIMULATION (O(n log n) time, O(n) space)
 *    Sort descending, process each pile, re-sort after modification.
 *    Less efficient than heap due to repeated sorting.
 *
 * 3. BRUTE FORCE ITERATION (O(n * k) time, O(n) space)
 *    Without optimization, iterate k times finding max each time.
 *    Very inefficient for large k.
 *
 * OPTIMAL SOLUTION: Approach 1 - Max-heap with efficient pile processing
 * Key insight: Always process largest pile, stop when pile <= k
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - priority_queue<int> for max-heap
 * - top(), pop(), push() methods
 * - sqrt() from <cmath>
 *
 * GO:
 * - Use container/heap for max-heap
 * - heap.Init() and heap.Push()
 * - math.Sqrt() for square root
 *
 * JAVASCRIPT:
 * - Use array with sort for heap simulation
 * - Sort descending each time
 * - Math.sqrt() for square root
 *
 * PYTHON:
 * - heapq module (negate for max-heap)
 * - heapq.heappush() and heapq.heappop()
 * - math.sqrt() function
 *
 * JAVA:
 * - PriorityQueue<Integer> with Collections.reverseOrder()
 * - poll(), add() methods
 * - Math.sqrt() function
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - RESOURCE REDISTRIBUTION: Taking from rich, distributing
 *   to poor, wealth redistribution simulation.
 *
 * - LOAD BALANCING: Taking load from overloaded servers,
 *   distributing to underloaded ones.
 *
 * - GAME ECONOMICS: Simulating in-game economies with wealth
 *   caps and redistribution mechanisms.
 *
 * - TRAFFIC MANAGEMENT: Redirecting traffic from congested
 *   routes to less busy ones.
 *
 * - ECOLOGICAL BALANCING: Redistributing resources in ecosystems
 *   to maintain balance.
 */

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int val : gifts)
            maxHeap.add(val);

        for (int i = 0; i < k && maxHeap.peek() > 1; i++) {
            int x = maxHeap.poll();
            maxHeap.add((int) Math.sqrt(x));
        }

        long sum = 0;
        for (int val : maxHeap)
            sum += val;

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example inputs to test
        int[] test1 = { 25, 64, 9, 4, 100 };
        int k1 = 4;
        int[] test2 = { 1, 1, 1, 1 };
        int k2 = 4;
        int[] test3 = { 5, 2, 1, 3 };
        int k3 = 4;
        int[] test4 = { 5, 2, 1 };
        int k4 = 5;

        // Call the method and print results
        System.out.println(solution.pickGifts(test1, k1)); // Expected: 29
        System.out.println(solution.pickGifts(test2, k2)); // Expected: 4
        System.out.println(solution.pickGifts(test3, k3)); // Expected: 4
        System.out.println(solution.pickGifts(test4, k4)); // Expected: 3
    }

}