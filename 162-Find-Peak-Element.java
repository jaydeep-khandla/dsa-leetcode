/*
 * ============================================================
 * LEETCODE 162 - Find Peak Element
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * A peak element is an element that is strictly greater than its
 * neighbors. Given an integer array nums, find a peak element and
 * return its index. If there are multiple peaks, return any one.
 * You must write an algorithm that runs in O(log n) time.
 *
 * Examples:
 * Input: [1,2,3,1]     → Output: 2 (3 is a peak)
 * Input: [1,2,1,3,5,6,4] → Output: 1 or 5
 * Input: [1,2]        → Output: 1
 * Input: [1]          → Output: 0
 *
 * TOPICS: Array, Binary Search
 * PATTERN: Binary Search with Slope Detection
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. BINARY SEARCH WITH SLOPE CHECK (O(log n) time, O(1) space) - OPTIMAL
 *    If nums[mid] < nums[mid+1], peak is to the right. Otherwise,
 *    peak is at mid or to the left. Classic peak finding with binary search.
 *
 * 2. LINEAR SCAN (O(n) time, O(1) space)
 *    Find first element that is >= neighbors. Simple but linear time.
 *
 * 3. MAX ELEMENT FIND (O(n) time, O(1) space)
 *    Find index of maximum element. Any peak works but inefficient.
 *
 * OPTIMAL SOLUTION: Approach 1 - Binary search exploiting local maximum property
 * Key insight: If slope is positive, peak is ahead; if negative, peak is behind or at mid
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - while loop with start < end
 * - Compare nums[mid] with nums[mid+1]
 * - Move start or end based on slope
 * - Return start at exit
 *
 * GO:
 * - for loop with binary search logic
 * - Compare with next element
 * - Return index when converged
 *
 * JAVASCRIPT:
 * - while loop with mid calculation
 * - Slope comparison
 * - Return start
 *
 * PYTHON:
 * - while loop with binary search
 * - Compare adjacent elements
 * - Return start
 *
 * JAVA:
 * - while loop with start < end
 * - Compare nums[mid] with nums[mid+1]
 * - Return start index
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - SIGNAL PROCESSING: Finding peak frequency in audio signals,
 *   spectral analysis.
 *
 * - PERFORMANCE OPTIMIZATION: Finding maximum throughput point,
 *   performance tuning in systems.
 *
 * - PHYSICS SIMULATIONS: Finding energy peaks in landscapes,
 *   local maximum detection.
 *
 * - FINANCIAL ANALYSIS: Finding stock price peaks, identifying
 *   local maximum values in time series.
 *
 * - IMAGE PROCESSING: Detecting local maxima in image gradients,
 *   feature detection in computer vision.
 */

public class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            // If the mid element is less than the next element, peak must be on the right
            if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                // Otherwise, peak must be on the left or mid itself
                end = mid;
            }
        }
        
        return start;  // start will be the index of the peak element
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example test case
        int[] nums = {1, 2, 3, 1};
        int peakIndex = solution.findPeakElement(nums);
        System.out.println("Peak Element Index: " + peakIndex); // Output: 2
        
        // Another test case
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        peakIndex = solution.findPeakElement(nums2);
        System.out.println("Peak Element Index: " + peakIndex); // Output: 5 (index of 6)
    }
}