/*
 * ============================================================
 * LEETCODE 4 - Median of Two Sorted Arrays
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given two sorted arrays nums1 and nums2 of size m and n,
 * return the median of the two sorted arrays.
 * Must have O(log(m+n)) time complexity.
 *
 * Examples:
 * Input: nums1 = [1,3], nums2 = [2]          → Output: 2.0
 * Input: nums1 = [1,2], nums2 = [3,4]       → Output: 2.5
 * Input: nums1 = [0,0], nums2 = [0,0]       → Output: 0.0
 *
 * TOPICS: Array, Binary Search
 * PATTERN: Binary Search with Partition
 * DIFFICULTY: Hard
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. BINARY SEARCH ON PARTITION (O(log(min(m,n))) time, O(1) space) - OPTIMAL
 *    Partition both arrays such that left half contains smaller elements.
 *    Use binary search on smaller array. Adjust partition until
 *    left elements <= right elements. Calculate median from partition.
 *
 * 2. K-th ELEMENT APPROACH (O(log(k)) time, O(1) space)
 *    Find k-th element for median position (or two positions for even).
 *    Use two pointers at both arrays, eliminate k/2 elements each step.
 *    Similar logic, different implementation.
 *
 * 3. MERGE AND FIND (O(m+n) time, O(m+n) space)
 *    Merge both arrays, find median. Simple but O(m+n) time.
 *
 * OPTIMAL SOLUTION: Approach 1 - Binary search partition
 * Key insight: Find correct partition that divides total elements evenly
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Binary search on smaller array
 * - Use long long for potential overflow
 * - INT_MIN/INT_MAX for edge cases
 *
 * GO:
 * - Binary search on smaller slice
 * - Use int64 if needed for sums
 * - Edge handling with sentinel values
 *
 * JAVASCRIPT:
 * - Binary search logic
 * - Use large numbers for edge cases
 * - Math.max and Math.min
 *
 * PYTHON:
 * - Binary search on smaller list
 * - Float division for median
 * - Handle even/odd cases
 *
 * JAVA:
 * - Binary search on smaller array
 * - Use Integer.MAX_VALUE/MIN_VALUE for bounds
 * - Math.max and Math.min utilities
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - MEDICAL DIAGNOSTICS: Finding median values from multiple
 *   diagnostic test results.
 *
 * - STATISTICS: Calculating median from two data sets,
 *   percentile calculations.
 *
 * - DATA ANALYSIS: Merging sorted streams efficiently,
 *   streaming median computation.
 *
 * - FINANCIAL ANALYSIS: Finding median stock prices from
 *   two exchanges, portfolio value calculations.
 *
 * - LOAD BALANCING: Finding median response times across
 *   multiple servers, performance monitoring.
 */

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        // Ensure that nums1 is the smaller array
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int N = n1 + n2;
        int start = 0;
        int end = n1;

        while (start <= end) {
            int cut1 = start + (end - start) / 2;
            int cut2 = (N / 2) - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];

            if (l1 <= r2 && l2 <= r1) {
                if (N % 2 == 0) {
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else {
                    return (double) Math.min(r1, r2);
                }
            } else if (l1 > r2) {
                end = cut1 - 1;
            } else {
                start = cut1 + 1;
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example test case 1
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double result = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println("Median: " + result); // Output: 2.0

        // Example test case 2
        // int[] nums1 = {1, 2};
        // int[] nums2 = {3, 4};
        // result = solution.findMedianSortedArrays(nums1, nums2);
        // System.out.println("Median: " + result); // Output: 2.5
    }
}