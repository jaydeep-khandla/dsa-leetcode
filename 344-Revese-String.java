import java.util.Arrays;

class Solution {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;

            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example input
        char[] s = {'h', 'e', 'l', 'l', 'o'};

        // Call the method
        solution.reverseString(s);

        // Print the result
        System.out.println(Arrays.toString(s));
    }
}
