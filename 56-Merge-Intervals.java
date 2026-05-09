/*
 * ============================================================
 * LEETCODE 56 - Merge Intervals
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given an array of intervals where intervals[i] = [start_i, end_i],
 * merge all overlapping intervals, and return an array of the
 * non-overlapping intervals that cover all the intervals in the input.
 *
 * Examples:
 * Input: [[1,3],[2,6],[8,10],[15,18]] → Output: [[1,6],[8,10],[15,18]]
 * Input: [[1,4],[4,5]]               → Output: [[1,5]]
 * Input: [[1,4],[0,4]]              → Output: [[0,4]]
 *
 * TOPICS: Array, Sorting
 * PATTERN: Sort + Linear Merge
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. SORT AND MERGE (O(n log n) time, O(n) space) - OPTIMAL
 *    Sort intervals by start time. Then iterate through sorted intervals,
 *    merging overlapping ones. If current interval starts after last
 *    merged, start new. Otherwise, extend last merged.
 *
 * 2. INTERVAL TREE (O(n log n) time, O(n) space)
 *    Insert intervals into tree, then traverse to collect merged intervals.
 *    More complex, similar time complexity.
 *
 * 3. STACK-BASED (O(n log n) time, O(n) space)
 *    Sort intervals, use stack to track merged intervals.
 *    Similar to approach 1 but with explicit stack.
 *
 * OPTIMAL SOLUTION: Approach 1 - Sort by start, merge in single pass
 * Key insight: After sorting, only need to check if next interval overlaps with current
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - std::sort with lambda comparator
 * - for loop with merging logic
 * - vector<vector<int>> for result
 *
 * GO:
 * - sort.Slice() for sorting
 * - for loop with merge logic
 * - slice of intervals
 *
 * JAVASCRIPT:
 * - sort() with comparator function
 * - for loop
 * - push() to result array
 *
 * PYTHON:
 * - sorted() with key
 * - for loop with merge logic
 * - append to result list
 *
 * JAVA:
 * - Arrays.sort() with comparator
 * - for loop with interval merging
 * - ArrayList<int[]> for result
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - CALENDAR SCHEDULING: Merging overlapping appointments,
 *   finding available time slots.
 *
 * - MEETING ROOM BOOKING: Consolidating overlapping bookings,
 *   resource allocation systems.
 *
 * - NETWORK TIMING: Merging overlapping time windows,
 *   IP address range consolidation.
 *
 * - TASK SCHEDULING: Combining overlapping task durations,
 *   Gantt chart simplification.
 *
 * - GEOGRAPHIC REGIONS: Merging overlapping geographic areas,
 *   map polygon simplification.
 */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort intervals based on the starting values
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // If the current interval overlaps with the previous one, merge them
            if (interval[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], interval[1]);
            } else {
                merged.add(prev);
                prev = interval;
            }
        }

        // Add the last interval
        merged.add(prev);

        return merged.toArray(new int[merged.size()][]);
    }

    // Method to print the 2D array
    private static void printIntervals(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }
    }

    // Main method to run the code
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example intervals for testing
        int[][] intervals = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };

        int[][] mergedIntervals = solution.merge(intervals);

        System.out.println("Merged Intervals:");
        printIntervals(mergedIntervals);
    }
}