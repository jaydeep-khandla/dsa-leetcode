class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example inputs to test
        int[] test1 = { 0, 1, 0 };
        int[] test2 = { 0, 2, 1, 0 };
        int[] test3 = { 0, 10, 5, 2 };
        int[] test4 = { 3, 4, 5, 1 };
        int[] test5 = { 24, 69, 100, 99, 79, 78, 67, 36, 26, 19 };

        // Call the method and print results
        System.out.println(solution.peakIndexInMountainArray(test1)); // Expected: 1
        System.out.println(solution.peakIndexInMountainArray(test2)); // Expected: 1
        System.out.println(solution.peakIndexInMountainArray(test3)); // Expected: 1
        System.out.println(solution.peakIndexInMountainArray(test4)); // Expected: 2
        System.out.println(solution.peakIndexInMountainArray(test5)); // Expected: 2
    }
}