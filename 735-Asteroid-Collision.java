import java.util.Stack;
import java.util.Arrays;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroids[i]) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                } else if (stack.peek() == -asteroids[i]) {
                    stack.pop();
                }
            }
        }

        int[] result = new int[stack.size()];
        int index = stack.size() - 1;

        while (!stack.isEmpty()) {
            result[index--] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = {5, 10, -5};
        int[] result = asteroidCollision(input);
        System.out.println("Resulting asteroids: " + Arrays.toString(result));
    }
}
