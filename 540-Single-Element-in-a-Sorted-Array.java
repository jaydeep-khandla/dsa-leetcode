public class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if mid is the last element
            if (mid == nums.length - 1) {
                return nums[mid];
            }

            // Binary search logic to find the single element
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    start = mid + 2;
                } else {
                    end = mid - 1;
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return nums[start];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example test case
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 4, 5};
        int result = solution.singleNonDuplicate(nums);
        System.out.println("Single Non-Duplicate: " + result); // Output: 5
    }
}
