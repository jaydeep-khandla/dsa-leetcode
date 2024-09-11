public class Solution {

    // Method to calculate the maximum profit
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int buy = prices[0];
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
        }
        
        return profit;
    }

    // Main method to test the maxProfit function
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Test Case 1: " + solution.maxProfit(prices1));  // Expected output: 5

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Test Case 2: " + solution.maxProfit(prices2));  // Expected output: 0

        int[] prices3 = {1, 2};
        System.out.println("Test Case 3: " + solution.maxProfit(prices3));  // Expected output: 1
    }
}
