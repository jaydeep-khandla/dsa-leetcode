/*
 * ============================================================
 * LEETCODE 735 - Asteroid Collision
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Given an array of integers representing asteroids in a row.
 * Each asteroid has a size (absolute value) and direction (sign).
 * Positive = moving right, Negative = moving left.
 * When two asteroids collide, the smaller one explodes.
 * If equal size, both explode. Find state after all collisions.
 *
 * Examples:
 * Input: [5,10,-5]  → Output: [5,10]
 * Input: [8,-8]     → Output: []
 * Input: [10,2,-5]  → Output: [10]
 *
 * TOPICS: Stack, Array
 * PATTERN: Stack with Collision Simulation
 * DIFFICULTY: Medium
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. STACK-BASED COLLISION (O(n) time, O(n) space) - OPTIMAL
 *    Iterate through asteroids. Push moving right onto stack.
 *    For moving left: while stack top > 0 and top < -asteroid,
 *    pop (collision). Handle equal case. Push if no collision or stack empty.
 *
 * 2. TWO-POINTER SIMULATION (O(n) time, O(n) space)
 *    Simulate with two indices tracking collision resolution.
 *    Less intuitive but similar complexity.
 *
 * 3. BRUTE FORCE (O(n^2) time, O(1) space)
 *    Repeatedly scan and resolve collisions until stable.
 *    Inefficient, not recommended.
 *
 * OPTIMAL SOLUTION: Approach 1 - Stack-based collision resolution
 * Key insight: Left-moving asteroids only collide with right-moving ones on stack
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Use std::stack<int> for asteroid values
 * - while loop for collision resolution
 * - Stack top comparison
 * - push() for remaining
 *
 * GO:
 * - Use slice as stack
 * - append() to push, slice[:len-1] to pop
 * - for loop with collision logic
 *
 * JAVASCRIPT:
 * - Use array as stack with push/pop
 * - while loop for collisions
 * - Check stack conditions
 *
 * PYTHON:
 * - Use list as stack
 * - append() and pop()
 * - while loop for resolution
 *
 * JAVA:
 * - Use Stack<Integer> or int[] as stack
 * - while loop for collisions
 * - push() and pop() methods
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - GAME PHYSICS: Simulating collision between moving objects,
 *   2D game physics engines.
 *
 * - TRAFFIC SIMULATION: Vehicle collisions at intersections,
 *   traffic flow simulation.
 *
 * - PARTICLE PHYSICS: Simulating particle collisions,
 *   molecular dynamics.
 *
 * - NETWORK PACKETS: Colliding data packets in networks,
 *   collision detection in communication.
 *
 * - SPACECRAFT NAVIGATION: Asteroid avoidance maneuvers,
 *   orbital mechanics calculations.
 */

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