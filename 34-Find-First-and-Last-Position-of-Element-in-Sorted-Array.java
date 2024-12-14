class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int[] ans = new int[2];

        ans[0] = binarySearchFirstOccurence(nums, target);
        ans[1] = binarySearchLastOccurence(nums, target);

        return ans;
        
    }

    static int binarySearchFirstOccurence(int[] arr, int key) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                ans = mid;
                end = mid - 1;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    static int binarySearchLastOccurence(int[] arr, int key) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                ans = mid;
                start = mid + 1;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example inputs to test
        int[] test1 = {5,7,7,8,8,10};
        int target1 = 8;
        int[] test2 = {5,7,7,8,8,10};
        int target2 = 6;
        int[] test3 = {};
        int target3 = 0;

        // Call the method and print results
        int[] res1 = solution.searchRange(test1, target1);
        int[] res2 = solution.searchRange(test2, target2);
        int[] res3 = solution.searchRange(test3, target3);
        System.out.println(res1[0] + " " + res1[1]); // Expected: 3 4
        System.out.println(res2[0] + " " + res2[1]); // Expected: -1 -1
        System.out.println(res3[0] + " " + res3[1]); // Expected: -1 -1
    }
}