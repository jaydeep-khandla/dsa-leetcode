/*
 * ============================================================
 * LEETCODE 1095 - Find in Mountain Array
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given a mountain array mountainArr with the following properties:
 * - mountainArr.length >= 3
 * - There exists some i with 0 < i < mountainArr.length - 1 such that:
 *   mountainArr[0] < mountainArr[1] < ... < mountainArr[i-1] < mountainArr[i]
 *   mountainArr[i] > mountainArr[i+1] > ... > mountainArr[mountainArr.length - 1]
 * Find the target value in the mountain array. Return the index if found,
 * else return -1. Must call mountainArr.get(i) to access values.
 *
 * Examples:
 * Input: mountainArr = [1,2,3,4,5,3,1], target = 3 → Output: 2
 * Input: mountainArr = [0,1,2,4,2,1], target = 3   → Output: -1
 *
 * TOPICS: Array, Binary Search
 * PATTERN: Binary Search on Mountain Array (3-part search)
 * DIFFICULTY: Hard
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. PEAK FINDING + BINARY SEARCH (O(log n) time, O(1) space) - OPTIMAL
 *    First find peak index using binary search (increasing slope).
 *    Then search left side (ascending) for target. If not found,
 *    search right side (descending). Return result.
 *
 * 2. SINGLE BINARY SEARCH (O(log n) time, O(1) space)
 *    Use modified binary search that handles both directions.
 *    More complex but works similarly.
 *
 * 3. LINEAR SCAN (O(n) time, O(1) space)
 *    Find peak linearly, then linear search on both sides.
 *    Simpler but linear time.
 *
 * OPTIMAL SOLUTION: Approach 1 - Three-step: find peak, search left, search right
 * Key insight: Mountain has two monotonic halves - handle each separately
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - First find peak using binary search
 * - Binary search on left half (ascending)
 * - Binary search on right half (descending)
 * - Compare with target value
 *
 * GO:
 * - Find peak index
 * - Binary search with direction flag
 * - Handle descending order in search
 *
 * JAVASCRIPT:
 * - Find peak first
 * - Binary search with isDescending flag
 * - Compare values at each step
 *
 * PYTHON:
 * - Find peak index
 * - Two binary searches with different bounds
 * - Combine results
 *
 * JAVA:
 * - Find peak with binary search
 * - Search left with ascending logic
 * - Search right with descending logic
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - TERRAIN MAPPING: Finding specific elevation in mountain
 *   terrain data, topographical analysis.
 *
 * - STOCK PRICE ANALYSIS: Finding specific price in stock with
 *   peak and decline, analyzing price history.
 *
 * - TEMPERATURE PROFILES: Finding temperature value in day's
 *   temperature curve with peak and decline.
 *
 * - GAME LEVELS: Finding specific item in mountain-like level
 *   design, game pathfinding.
 *
 * - ENVIRONMENTAL DATA: Analyzing pollutant levels that rise
 *   then fall, finding threshold values.
 */

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class MountainArray {
    private int[] arr;

    public MountainArray(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        return arr[index];
    }

    public int length() {
        return arr.length;
    }

    // public static void main(String[] args) {}
}
 
public class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;

        int peakIndex = findPeakIndexInBitonicArray(mountainArr);

        if (mountainArr.get(peakIndex) == target) {
            return peakIndex;
        }
        
        int inc = binarySearch(mountainArr, target, start, peakIndex-1, false);
        int dec = binarySearch(mountainArr, target, peakIndex+1, end, true);
        if (inc == -1 && dec == -1) {
            return -1;
        } else if (inc == -1) {
            return dec;
        } else if (dec == -1) {
            return inc;
        } else {
            return Math.min(inc, dec);
        }
    }

    static int findPeakIndexInBitonicArray(MountainArray arr) {
        int start = 0;
        int end = arr.length() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) < arr.get(mid+1)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    static int binarySearch(MountainArray arr, int key, int start, int end, boolean isDescending) {
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) == key) {
                return mid;
            } else if (arr.get(mid) < key) {
                if (isDescending) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (isDescending) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example inputs to test
        int[] test1 = { 1, 2, 3, 4, 5, 3, 1 };
        int target1 = 3;
        MountainArray mountainArray1 = new MountainArray(test1);
        int[] test2 = { 0, 1, 2, 4, 2, 1 };
        int target2 = 3;
        MountainArray mountainArray2 = new MountainArray(test2);
        int[] test3 = { 1, 5, 2 };
        int target3 = 2;
        MountainArray mountainArray3 = new MountainArray(test3);
        int[] test4 = { 1, 3, 5, 7, 9, 5, 3, 1 };
        int target4 = 3;
        MountainArray mountainArray4 = new MountainArray(test4);
        int[] test5 = { 0, 5, 3, 1 };
        int target5 = 1;
        MountainArray mountainArray5 = new MountainArray(test5);

        // Call the method and print results
        System.out.println(solution.findInMountainArray(target1, mountainArray1)); // Expected: 2
        System.out.println(solution.findInMountainArray(target2, mountainArray2)); // Expected: -1
        System.out.println(solution.findInMountainArray(target3, mountainArray3)); // Expected: 2
        System.out.println(solution.findInMountainArray(target4, mountainArray4)); // Expected: 1
        System.out.println(solution.findInMountainArray(target5, mountainArray5)); // Expected: 3
        
    }
}