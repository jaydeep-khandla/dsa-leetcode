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
