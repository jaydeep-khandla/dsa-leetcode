/*
 * ============================================================
 * LEETCODE 1768 - Merge Strings Alternately
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * You are given two strings word1 and word2. Merge the two strings by adding
 * letters in alternating order, starting with word1. If a string's length is
 * greater than the other's, append the additional letters onto the end of the
 * merged string. Return the merged string.
 *
 * Examples:
 * Input: word1 = "abc", word2 = "pqr"    → Output: "apbqcr"
 * Input: word1 = "ab", word2 = "pqrs"    → Output: "apbqrs"
 * Input: word1 = "abcd", word2 = "pq"    → Output: "apbqcd"
 *
 * TOPICS: String, Two Pointers
 * PATTERN: Two Pointers (simultaneous traversal)
 * DIFFICULTY: Easy
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. TWO POINTERS WITH STRINGBUILDER (O(n+m) time, O(n+m) space) - OPTIMAL
 *    Use two pointers for each string. Append characters alternately.
 *    After one string ends, append remaining characters from the other.
 *    Efficient with StringBuilder/StringBuffer to avoid string concatenation.
 *
 * 2. INTERLEAVING WITH INDEX TRACKING (O(n+m) time, O(n+m) space)
 *    Track current index in each string. Alternate appending based on
 *    which string still has characters remaining.
 *
 * 3. STRING CONCATENATION (O(n+m) time, O(n+m) space)
 *    Use + operator or concat() - less efficient due to immutable strings
 *    creating new objects each time.
 *
 * OPTIMAL SOLUTION: Approach 1 - Two pointers with StringBuilder
 * Key insight: Alternate between strings until one exhausts, then append rest
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Use std::string with + operator or stringstream
 * - Two indices tracking position in each string
 * - push_back() or append() methods
 *
 * GO:
 * - Use strings.Builder for efficient building
 * - Write() or WriteString() methods
 * - Two indices for word1 and word2
 *
 * JAVASCRIPT:
 * - Use array and join() for efficient building
 * - push() elements to array, then join('')
 * - for loop with alternating logic
 *
 * PYTHON:
 * - Use list and join() or use itertools.zip_longest
 * - List comprehension with zip
 * - extend() for appending remaining characters
 *
 * JAVA:
 * - Use StringBuilder for efficient concatenation
 * - append() method for adding characters
 * - charAt() for character access
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - DNA/RNA SEQUENCING: Interleaving genetic sequences, combining forward
 *   and reverse strand data in bioinformatics.
 *
 * - SHUFFLE ALGORITHMS: Merging two sorted lists, playlist shuffling,
 *   audio track mixing in media players.
 *
 * - FILE INTERLEAVING: Combining chunks from two files, data recovery
 *   from distributed storage systems.
 *
 * - ENCRYPTION: Some cipher techniques involve interleaving plaintext
 *   from multiple sources.
 *
 * - DOCUMENT MERGING: Combining documents in alternating order,
 *   version control merge displays, diff outputs.
 */

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