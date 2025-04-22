public class Solution {
    public static int minSwaps(String s) {
        int swap = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '[') {
                swap++;
            } else if (swap > 0) {
                swap--;
            }
        }

        return (swap + 1) / 2;
    }

    public static void main(String[] args) {
        String input = "[]][][";
        int result = minSwaps(input);
        System.out.println("Minimum swaps needed: " + result);
    }
}
