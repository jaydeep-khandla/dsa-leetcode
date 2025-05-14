public class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }

        return prices;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices = {8, 4, 6, 2, 3};
        int[] result = sol.finalPrices(prices);

        System.out.println("Final prices after discount:");
        for (int price : result) {
            System.out.print(price + " ");
        }
    }
}
