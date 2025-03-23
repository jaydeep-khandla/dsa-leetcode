public class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            // If the mid element is less than the next element, peak must be on the right
            if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                // Otherwise, peak must be on the left or mid itself
                end = mid;
            }
        }
        
        return start;  // start will be the index of the peak element
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example test case
        int[] nums = {1, 2, 3, 1};
        int peakIndex = solution.findPeakElement(nums);
        System.out.println("Peak Element Index: " + peakIndex); // Output: 2
        
        // Another test case
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        peakIndex = solution.findPeakElement(nums2);
        System.out.println("Peak Element Index: " + peakIndex); // Output: 5 (index of 6)
    }
}
