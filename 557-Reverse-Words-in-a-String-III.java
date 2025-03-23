public class Solution {
    public String reverseWords(String s) {
        // Convert string to character array for in-place manipulation
        char[] arr = s.toCharArray();
        int len = arr.length;
        int sp = 0; // Start pointer for each word

        // Iterate through the array
        for (int ep = 0; ep <= len; ep++) {
            // When we reach the end of a word or the end of the string
            if (ep == len || arr[ep] == ' ') {
                int left = sp;
                int right = ep - 1;

                // Reverse the word between sp and ep
                while (left < right) {
                    char temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    left++;
                    right--;
                }

                // Move start pointer to the next word
                sp = ep + 1;
            }
        }

        // Convert character array back to string
        return new String(arr);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test case
        String s = "the sky is Blue";
        String result = solution.reverseWords(s);
        System.out.println("Reversed words: '" + result + "'"); // Output: "ehT yks si eulb"
    }
}
