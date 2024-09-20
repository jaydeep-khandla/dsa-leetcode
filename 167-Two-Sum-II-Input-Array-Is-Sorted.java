import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1}; // Return 1-based indices
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[]{-1, -1}; // If no solution found
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example input
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        // Call the method
        int[] result = solution.twoSum(numbers, target);

        // Print the result
        System.out.println(Arrays.toString(result));
    }
}
