class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return true;
            }

            if (nums[start] == nums[mid] && nums[end] == nums[mid]){
                start++;
                end--;
            } else if (nums[start] <= nums[mid]){
                if (target >= nums[start] && target <= nums[mid]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[end]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] test1 = {2,5,6,0,0,1,2};
        int target1 = 0;
        int[] test2 = {2,5,6,0,0,1,2};
        int target2 = 3;
        int[] test3 = {1};
        int target3 = 0;
        int[] test4 = {1,3, 8, 9, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int target4 = 3;

        System.out.println(sol.search(test1, target1)); // Expected: true
        System.out.println(sol.search(test2, target2)); // Expected: false
        System.out.println(sol.search(test3, target3)); // Expected: false
        System.out.println(sol.search(test4, target4)); // Expected: true
        
    }
}