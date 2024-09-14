public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return ""; // Added check to avoid infinite loop
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Define the test cases
        String[][] testCases = {
            {"flower", "flow", "flight"},
            {"dog", "racecar", "car"},
            {"interspecies", "interstellar", "interstate"},
            {"throne", "drones", "stone"},
            {""}, // Edge case: empty string
            {} // Edge case: empty array
        };

        // Iterate through each test case
        for (String[] testCase : testCases) {
            // Compute the longest common prefix
            String result = solution.longestCommonPrefix(testCase);
            // Print the result
            System.out.println("Input: " + String.join(", ", testCase));
            System.out.println("Longest Common Prefix: " + result);
            System.out.println();
        }
    }
}
