import java.util.Scanner;

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        int n1 = word1.length(), n2 = word2.length();
        StringBuilder str = new StringBuilder();
        
        while (i < n1 && j < n2) {
            if (i > j) {
                str.append(word2.charAt(j));
                j++;
            } else {
                str.append(word1.charAt(i));
                i++;
            }
        }

        while (i < n1) {
            str.append(word1.charAt(i));
            i++;
        }

        while (j < n2) {
            str.append(word2.charAt(j));
            j++;
        }

        return str.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.println("Enter the first word:");
        String word1 = scanner.nextLine();

        System.out.println("Enter the second word:");
        String word2 = scanner.nextLine();

        // Find the merged string
        String result = sol.mergeAlternately(word1, word2);

        // Output the result
        System.out.println("Merged string: " + result);

        scanner.close();
    }
}
