/*
 * ============================================================
 * LEETCODE 378 - Kth Smallest Element in a Sorted Matrix
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given an n x n matrix where each row and column is sorted in
 * ascending order, return the k-th smallest element in the matrix.
 * Note: It is guaranteed that the k-th smallest is unique.
 *
 * Examples:
 * Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8 → Output: 13
 * Input: matrix = [[-5]], k = 1                       → Output: -5
 *
 * TOPICS: Array, Binary Search, Heap, Matrix
 * PATTERN: Binary Search on Value Range or Min-Heap
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. BINARY SEARCH ON VALUE (O(n log(max-min)) time, O(1) space) - OPTIMAL
 *    Binary search on value range [min, max]. Count elements <= mid
 *    in O(n) using two-pointer technique (start from bottom-left).
 *    When count >= k, narrow search. Continue until range converges.
 *
 * 2. MIN-HEAP (O(k log n) time, O(n) space)
 *    Push first element of each row (or just one element) into heap.
 *    Extract min k times, pushing next element from same row.
 *    Less efficient than binary search for large k.
 *
 * 3. FLATEN AND SORT (O(n^2 log n) time, O(n^2) space)
 *    Flatten matrix to array, sort, return k-th element.
 *    Simple but O(n^2 log n) complexity.
 *
 * OPTIMAL SOLUTION: Approach 1 - Binary search on matrix values
 * Key insight: Count elements <= value in O(n) due to sorted properties
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Binary search with countLessEqual function
 * - Two-pointer count from bottom-left
 * - std::min, std::max for bounds
 *
 * GO:
 * - Binary search with count function
 * - Two indices: i from end, j from start
 * - int64 for values if needed
 *
 * JAVASCRIPT:
 * - Binary search with countLessEqual
 * - Nested loop for counting (or two-pointer)
 * - Return at convergence
 *
 * PYTHON:
 * - Binary search with while loop
 * - Count function using two-pointer
 * - Return start value
 *
 * JAVA:
 * - Binary search on value range
 * - countLessEqual with bottom-left traversal
 * - Return start when converged
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - DATABASE QUERIES: Finding k-th smallest value in indexed
 *   2D data structure, top-k queries.
 *
 * - RANKING SYSTEMS: Finding k-th ranked item in sorted
 *   multi-dimensional data, recommendation systems.
 *
 * - SENSOR FUSION: Finding median of sensor readings from
 *   multiple sorted sensor arrays.
 *
 * - IMAGE PROCESSING: Finding k-th smallest pixel value
 *   in image, histogram analysis.
 *
 * - PERFORMANCE METRICS: Finding k-th fastest response time
 *   in distributed system latency data.
 */

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int start = matrix[0][0];
        int end = matrix[n - 1][n - 1];
        while (start < end) {
            int mid = start + (end - start) / 2;
            int count = countLessEqual(matrix, mid);
            if (count < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    static int countLessEqual(int[][] matrix, int mid) {
        int count = 0;
        int n = matrix.length;
        int i = n - 1;
        int j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test case
        int[][] matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        int k = 8;
        int result = solution.kthSmallest(matrix, k);
        System.out.println("The " + k + "th smallest element is: " + result); // Output: 13
    }
}