/*
 * ============================================================
 * LEETCODE 228 - Summary Ranges
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * You are given a sorted unique integer array nums. A range [a,b] is
 * the set of all the integers between a and b (inclusive).
 * Return the smallest sorted list of ranges that covers all the
 * numbers in the array exactly. Each element in the array is covered
 * by exactly one of the ranges.
 *
 * Examples:
 * Input: [0,1,2,4,5,7]   → Output: ["0->2", "4->5", "7"]
 * Input: [0,2,3,4,6,8,9]  → Output: ["0", "2->4", "6", "8->9"]
 * Input: []              → Output: []
 * Input: [-1]            → Output: ["-1"]
 *
 * TOPICS: Array
 * PATTERN: Linear Scan with Range Detection
 * DIFFICULTY: Easy
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. LINEAR SCAN WITH CONTINUITY CHECK (O(n) time, O(n) space) - OPTIMAL
 *    Track start of current range. Iterate array, if current element
 *    is not consecutive (nums[i] != nums[i-1] + 1), close current range.
 *    Handle last range after loop ends.
 *
 * 2. TWO PASSES (O(n) time, O(n) space)
 *    First pass identifies range boundaries. Second pass formats output.
 *    Clear separation of logic but two passes.
 *
 * 3. GROUP BY ADJACENCY (O(n) time, O(n) space)
 *    Group consecutive numbers together, then format each group.
 *    Similar to approach 1 but groups explicitly.
 *
 * OPTIMAL SOLUTION: Approach 1 - Single pass with range boundary detection
 * Key insight: Consecutive numbers form continuous ranges; detect breaks
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Use vector<string> for result
 * - to_string() for number to string conversion
 * - Format: num + "->" + num or single num
 *
 * GO:
 * - Use slice of strings
 * - strconv.Itoa() for conversion
 * - fmt.Sprintf() for formatting
 *
 * JAVASCRIPT:
 * - Use array for result
 * - Template literals for formatting
 * - String concatenation
 *
 * PYTHON:
 * - Use list of strings
 * - f-strings or format()
 * - List appending
 *
 * JAVA:
 * - Use List<String> or String[]
 * - Integer.toString() or String.valueOf()
 * - StringBuilder for building range strings
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - IP ADDRESS RANGES: Summarizing IP address blocks for networking,
 *   CIDR notation generation, firewall rules.
 *
 * - CALENDAR/BOOKING: Combining adjacent time slots, date range
 *   formatting, availability calendars.
 *
 * - ERROR CODE RANGES: Grouping related error codes, documentation
 *   generation for API error messages.
 *
 * - FILE SYSTEMS: Displaying file size ranges, block allocation
 *   summaries, disk usage reports.
 *
 * - CHARTING: Axis labeling for continuous data ranges, binning
 *   data for histograms, range display in UI components.
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<String> ranges = new ArrayList<>();
        int start = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    ranges.add(Integer.toString(start));
                } else {
                    ranges.add(start + "->" + nums[i - 1]);
                }
                start = nums[i];
            }
        }

        // Handle the last range
        if (start == nums[nums.length - 1]) {
            ranges.add(Integer.toString(start));
        } else {
            ranges.add(start + "->" + nums[nums.length - 1]);
        }

        return ranges;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] test1 = {0, 1, 2, 4, 5, 7};
        int[] test2 = {0, 2, 3, 4, 6, 8, 9};
        int[] test3 = {-1};
        int[] test4 = {};

        // Print results for test cases
        System.out.println("Test 1: " + solution.summaryRanges(test1));
        System.out.println("Test 2: " + solution.summaryRanges(test2));
        System.out.println("Test 3: " + solution.summaryRanges(test3));
        System.out.println("Test 4: " + solution.summaryRanges(test4));
    }
}