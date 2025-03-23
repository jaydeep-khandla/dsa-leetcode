public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        // Ensure that nums1 is the smaller array
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int N = n1 + n2;
        int start = 0;
        int end = n1;

        while (start <= end) {
            int cut1 = start + (end - start) / 2;
            int cut2 = (N / 2) - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];

            if (l1 <= r2 && l2 <= r1) {
                if (N % 2 == 0) {
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else {
                    return (double) Math.min(r1, r2);
                }
            } else if (l1 > r2) {
                end = cut1 - 1;
            } else {
                start = cut1 + 1;
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example test case 1
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double result = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println("Median: " + result); // Output: 2.0

        // Example test case 2
        // int[] nums1 = {1, 2};
        // int[] nums2 = {3, 4};
        // result = solution.findMedianSortedArrays(nums1, nums2);
        // System.out.println("Median: " + result); // Output: 2.5
    }
}
