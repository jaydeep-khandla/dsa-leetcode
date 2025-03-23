public class Solution {
    public String reverseWords(String s) {
        // Split the string by one or more spaces and trim leading/trailing spaces
        String[] words = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        
        // Iterate through the words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i != 0) {
                result.append(" ");  // Add space between words, except after the last word
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example test case
        String s = "  the sky is blue  ";
        String result = solution.reverseWords(s);
        System.out.println("Reversed words: '" + result + "'"); // Output: "blue is sky the"
    }
}
