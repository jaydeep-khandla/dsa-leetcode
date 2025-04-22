import java.util.Stack;

public class Solution {
    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % nums.length]) {
                stack.pop();
            }

            if (i < nums.length) {
                if (stack.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peek();
                }
            }

            stack.push(nums[i % nums.length]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        int[] result = nextGreaterElements(nums);
        System.out.println("Next greater elements: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
