/*
 * ============================================================
 * LEETCODE 540 - Single Element in a Sorted Array
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * You are given a sorted array consisting of only integers where every
 * element appears exactly twice, except for one element which appears
 * exactly once. Return the single element that appears only once.
 *
 * Examples:
 * Input: [1,1,2,3,3,4,4,8,8]   → Output: 2
 * Input: [3,3,7,7,10,11,11]    → Output: 10
 * Input: [1,1,2,2,3]           → Output: 3
 *
 * TOPICS: Array, Binary Search
 * PATTERN: Binary Search with Parity Check
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. BINARY SEARCH WITH PAIR CHECK (O(log n) time, O(1) space) - OPTIMAL
 *    Use binary search. Check if mid is in left or right half by checking
 *    parity of mid. If mid is even, pairs start at mid; check mid vs mid+1.
 *    If mid is odd, pairs start at mid-1; check mid-1 vs mid.
 *    Adjust search based on where the pair is found.
 *
 * 2. XOR APPROACH (O(n) time, O(1) space)
 *    XOR all elements. Since pairs cancel out, remaining value is the answer.
 *    Simple but O(n) time - doesn't exploit sorted property.
 *
 * 3. LINEAR SCAN (O(n) time, O(1) space)
 *    Iterate and skip pairs: if nums[i] == nums[i+1], skip two.
 *    Otherwise, return nums[i]. Works but linear time.
 *
 * OPTIMAL SOLUTION: Approach 1 - Binary search exploiting sorted + pair pattern
 * Key insight: Single element splits the array such that left pairs and right pairs differ in index parity
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Binary search with mid % 2 == 0 check
 * - Compare nums[mid] with nums[mid+1] or nums[mid-1]
 * - Adjust left/right boundaries
 *
 * GO:
 * - Binary search with mid % 2 check
 * - Compare with adjacent elements
 * - Use int indices
 *
 * JAVASCRIPT:
 * - Binary search with mid % 2 check
 * - Compare arr[mid] with arr[mid+1]
 * - Adjust start/end
 *
 * PYTHON:
 * - Binary search with mid % 2 check
 * - Compare with adjacent elements
 * - while loop with start <= end
 *
 * JAVA:
 * - Binary search with mid % 2 == 0 check
 * - Compare nums[mid] with nums[mid+1]
 * - Adjust left/right indices
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - ERROR-CORRECTING CODES: Finding single-bit errors in data
 *   transmitted with duplicated bits.
 *
 * - QUALITY CONTROL: Detecting defective items in paired samples,
 *   finding anomalies in duplicate measurements.
 *
 * - FREQUENCY ANALYSIS: Finding unique frequencies in paired
 *   audio signals, identifying single-tone frequencies.
 *
 * - DATA DEDUPLICATION: Finding unpaired records in database
 *   systems with duplicate entries.
 *
 * - CRYPTOGRAPHIC PROTOCOLS: Key exchange where most values are
 *   paired, finding unpaired values.
 */

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