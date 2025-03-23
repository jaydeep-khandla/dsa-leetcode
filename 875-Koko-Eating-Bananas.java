public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int res = -1, start = 1, end = Integer.MIN_VALUE;

        // Find the maximum number of bananas in any pile
        for (int i = 0; i < piles.length; i++) {
            end = Math.max(end, piles[i]);
        }

        // Perform binary search to find the minimum eating speed
        while (start <= end) {
            int mid = start + (end - start) / 2;

            long hoursCount = 0;

            // Calculate the total hours required to eat all bananas at speed 'mid'
            for (int i = 0; i < piles.length; i++) {
                hoursCount += piles[i] / mid;
                if (piles[i] % mid != 0) {
                    hoursCount++;
                }
            }

            // If hours exceed 'h', increase the eating speed
            if (hoursCount > h) {
                start = mid + 1;
            } else {
                // Otherwise, record the result and try smaller speeds
                res = mid;
                end = mid - 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // Test case
        Solution solution = new Solution();
        int[] piles = {3, 6, 7, 11}; // Piles of bananas
        int h = 8; // Hours to eat all bananas

        // Call minEatingSpeed method
        int result = solution.minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed: " + result);
    }
}
