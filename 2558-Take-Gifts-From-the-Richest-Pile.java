import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int val : gifts)
            maxHeap.add(val);

        for (int i = 0; i < k && maxHeap.peek() > 1; i++) {
            int x = maxHeap.poll();
            maxHeap.add((int) Math.sqrt(x));
        }

        long sum = 0;
        for (int val : maxHeap)
            sum += val;

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example inputs to test
        int[] test1 = { 25, 64, 9, 4, 100 };
        int k1 = 4;
        int[] test2 = { 1, 1, 1, 1 };
        int k2 = 4;
        int[] test3 = { 5, 2, 1, 3 };
        int k3 = 4;
        int[] test4 = { 5, 2, 1 };
        int k4 = 5;

        // Call the method and print results
        System.out.println(solution.pickGifts(test1, k1)); // Expected: 29
        System.out.println(solution.pickGifts(test2, k2)); // Expected: 4
        System.out.println(solution.pickGifts(test3, k3)); // Expected: 4
        System.out.println(solution.pickGifts(test4, k4)); // Expected: 3
    }

}