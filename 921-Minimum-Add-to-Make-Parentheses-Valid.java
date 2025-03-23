class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0;

        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++; // Increment open counter when encountering '('
            } else {
                if (open == 0) {
                    close++; // Increment close counter when encountering unmatched ')'
                } else {
                    open--; // Decrease open counter for a matched pair
                }
            }
        }

        // Total unmatched parentheses
        return open + close;
    }

    public static void main(String[] args) {

        // Example test case
        String s = "()[]{}(}";

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Call the method and print the result
        int result = solution.minAddToMakeValid(s);
        System.out.println("Minimum additions needed to make the string valid: " + result);
    }
}
