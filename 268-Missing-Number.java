public class Solution {
    public int missingNumber(int[] nums) {
        int n =  nums.length;
        int exp = (n * (n + 1)) / 2;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return exp - sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test case
        int[] nums = {3, 0, 1};
        int result = solution.missingNumber(nums);
        System.out.println("The missing number is: " + result); // Output: 2
    }
}
