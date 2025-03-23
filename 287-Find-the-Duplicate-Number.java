public class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int absValue = Math.abs(nums[i]);
            if (nums[absValue - 1] < 0) {
                return absValue;
            } else {
                nums[absValue - 1] = -nums[absValue - 1];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test case
        int[] nums = {1, 3, 4, 2, 2};
        int result = solution.findDuplicate(nums);
        System.out.println("The duplicate number is: " + result); // Output: 2
    }
}
