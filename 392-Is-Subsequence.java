public class Solution {
    
    // Method to check if 's' is a subsequence of 't'
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int n1 = s.length(), n2 = t.length();

        if (n1 < 1) return true;

        while (j < n2) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                if (i == n1) {
                    return true;
                }
            }
            j++;
        }

        return i == n1;
    }

    // Main method to test the isSubsequence function
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        String s1 = "abc";
        String t1 = "ahbgdc";
        System.out.println("Test Case 1: " + solution.isSubsequence(s1, t1));  // Expected output: true
        
        String s2 = "axc";
        String t2 = "ahbgdc";
        System.out.println("Test Case 2: " + solution.isSubsequence(s2, t2));  // Expected output: false
    }
}
