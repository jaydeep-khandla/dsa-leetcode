class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ans = letters[0];
        int start = 0;
        int end = letters.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
                ans = letters[mid];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example inputs to test
        char[] test1 = { 'c', 'f', 'j' };
        char target1 = 'a';
        char[] test2 = { 'c', 'f', 'j' };
        char target2 = 'c';
        char[] test3 = { 'c', 'f', 'j' };
        char target3 = 'd';
        char[] test4 = { 'c', 'f', 'j' };
        char target4 = 'g';
        char[] test5 = { 'c', 'f', 'j' };
        char target5 = 'j';
        char[] test6 = { 'c', 'f', 'j' };
        char target6 = 'k';
        char[] test7 = { 'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n' };
        char target7 = 'e';

        // Call the method and print results
        System.out.println(solution.nextGreatestLetter(test1, target1)); // Expected: c
        System.out.println(solution.nextGreatestLetter(test2, target2)); // Expected: f
        System.out.println(solution.nextGreatestLetter(test3, target3)); // Expected: f
        System.out.println(solution.nextGreatestLetter(test4, target4)); // Expected: j
        System.out.println(solution.nextGreatestLetter(test5, target5)); // Expected: c
        System.out.println(solution.nextGreatestLetter(test6, target6)); // Expected: c
        System.out.println(solution.nextGreatestLetter(test7, target7)); // Expected: n
    }
}