class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while(start <= end){
            int mid = start + (end - start)/2;

            if (nums[start] <= nums[mid]){
                min = Math.min(min, nums[start]);
                start = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                end = mid - 1;
            }
        }

        return min;
    }

    public static void main(String[] args){
        Solution sol = new Solution();

        int[] test1 = {3,4,5,1,2};
        int[] test2 = {4,5,6,7,0,1,2};
        int[] test3 = {11,13,15,17};
        int[] test4 = {1,3,5};

        System.out.println(sol.findMin(test1)); // Expected: 1
        System.out.println(sol.findMin(test2)); // Expected: 0
        System.out.println(sol.findMin(test3)); // Expected: 11
        System.out.println(sol.findMin(test4)); // Expected: 1
    }
}