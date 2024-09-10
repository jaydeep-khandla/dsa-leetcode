class Solution {
    public int findClosestNumber(int[] nums) {
        int dis = Integer.MAX_VALUE, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = Math.abs(nums[i]);

            if (dis < tmp) continue;

            if (dis == tmp) ans = Math.max(ans, nums[i]);

            if (dis > tmp) {
                dis = tmp;
                ans = nums[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Example test cases
        int[] nums1 = {1, -1, 2, -2, 3};
        int[] nums2 = {5, 6, -7, -8, 9};
        
        System.out.println("Closest number to zero in nums1: " + sol.findClosestNumber(nums1)); // Should print: 1
        System.out.println("Closest number to zero in nums2: " + sol.findClosestNumber(nums2)); // Should print: 6
    }
}
