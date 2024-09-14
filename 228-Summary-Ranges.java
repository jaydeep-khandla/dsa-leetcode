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
