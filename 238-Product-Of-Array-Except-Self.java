/*
 * ============================================================
 * LEETCODE 238 - Product of Array Except Self
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given an integer array nums, return an array answer where
 * answer[i] is the product of all numbers in nums except nums[i].
 * You must write an algorithm with O(n) time and without using
 * division. Also, O(1) extra space (excluding output array).
 *
 * Examples:
 * Input: [1,2,3,4]   → Output: [24,12,8,6]
 * Input: [-1,1,0,-3,3] → Output: [0,0,9,0,0]
 *
 * TOPICS: Array, Prefix-Suffix
 * PATTERN: Prefix and Suffix Product
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. PREFIX-SUFFIX ARRAYS (O(n) time, O(1) extra space) - OPTIMAL
 *    First pass: store prefix products (product of all elements before i).
 *    Second pass: multiply with suffix products (product of all elements after i).
 *    Use output array to store prefix, then multiply suffix in place.
 *
 * 2. TWO PASSES WITHOUT EXTRA ARRAYS (O(n) time, O(1) space)
 *    Similar to above but use constant extra variables.
 *    More space-efficient but same time complexity.
 *
 * 3. DIVISION APPROACH (O(n) time, O(1) space) - NOT ALLOWED
 *    Compute total product, divide by nums[i].
 *    Fails with zeros in input.
 *
 * OPTIMAL SOLUTION: Approach 1 - Prefix-suffix multiplication
 * Key insight: Product except self = prefix * suffix
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Use vector<int> for result
 * - First pass fills result with prefix
 * - Second pass multiplies suffix
 * - Use running product variables
 *
 * GO:
 * - Use slice for result
 * - First pass with product variable
 * - Second pass with suffix tracking
 * - Return result slice
 *
 * JAVASCRIPT:
 * - Use Array(n) for result
 * - for loop for prefix calculation
 * - Second for loop for suffix multiplication
 * - fill() for initialization
 *
 * PYTHON:
 * - Use list for result
 * - list comprehension or for loops
 * - enumerate() for index access
 * - Preallocate with [1] * n
 *
 * JAVA:
 * - Use int[] array for result
 * - Initialize with 1
 * - First loop for prefix
 * - Second loop for suffix
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - SPREADSHEET FORMULAS: Calculating totals excluding each row,
 *   row-wise and column-wise analysis.
 *
 * - FINANCE: Calculating portfolio weights excluding each asset,
 *   risk metrics computation.
 *
 * - SIGNAL PROCESSING: Calculating convolution without using
 *   each signal point, filter operations.
 *
 * - GENETIC SEQUENCES: Calculating mutation rates excluding
 *   each position, sequence analysis.
 *
 * - RECOMMENDATION SYSTEMS: Calculating scores excluding each
 *   item, collaborative filtering.
 */

public class Solution {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Initialize the result array with 1s
        for (int i = 0; i < n; i++) {
            result[i] = 1;
        }

        // Compute the prefix products
        int prefixProduct = 1;
        for (int i = 0; i < n; i++) {
            result[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        // Compute the suffix products and update the result array
        int suffixProduct = 1;
        for (int j = n - 1; j >= 0; j--) {
            result[j] *= suffixProduct;
            suffixProduct *= nums[j];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] test1 = {1, 2, 3, 4};
        int[] test2 = {-1, 1, 0, -3, 3};
        int[] test3 = {0, 0, 0, 0};
        int[] test4 = {5, 10, 15};

        // Print results for test cases
        System.out.println("Test Case 1: ");
        printArray(solution.productExceptSelf(test1));
        
        System.out.println("Test Case 2: ");
        printArray(solution.productExceptSelf(test2));
        
        System.out.println("Test Case 3: ");
        printArray(solution.productExceptSelf(test3));
        
        System.out.println("Test Case 4: ");
        printArray(solution.productExceptSelf(test4));
    }

    // Utility method to print arrays
    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}