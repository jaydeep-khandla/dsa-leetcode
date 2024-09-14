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
