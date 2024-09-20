import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1;
 
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[i] = nums[left] * nums[left];
                left++;
            } else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example input
        int[] nums = {-4, -1, 0, 3, 10};
        
        // Call the method
        int[] sortedSquares = solution.sortedSquares(nums);
        
        // Print the result
        System.out.println(Arrays.toString(sortedSquares));
    }
}
