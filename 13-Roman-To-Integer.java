/*
 * ============================================================
 * LEETCODE 13 - Roman to Integer
 * ============================================================
 *
 * PROBLEM STATEMENT:
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D, M.
 * Given a roman numeral, convert it to an integer.
 *
 * Examples:
 * Input: "III"       → Output: 3
 * Input: "LVIII"     → Output: 58 (L=50, V=5, III=3)
 * Input: "MCMXCIV"   → Output: 1994 (M=1000, CM=900, XC=90, IV=4)
 *
 * TOPICS: Hash Table, String, Math
 * PATTERN: Hash Map Lookup with Subtractive Notation
 * DIFFICULTY: Easy
 *
 * ============================================================
 * APPROACHES
 * ============================================================
 *
 * 1. HASH MAP WITH LEFT-TO-RIGHT SCANNING (O(n) time, O(1) space) - OPTIMAL
 *    Create a map of Roman symbols to values. Iterate through the string.
 *    If current value is less than next value, subtract it (subtractive case).
 *    Otherwise, add it. This handles cases like IV (4), IX (9), XL (40), etc.
 *
 * 2. REVERSE SCANNING (O(n) time, O(1) space)
 *    Iterate from right to left. If current value >= previous, add it.
 *    If current value < previous, subtract it. Tracks previous value seen.
 *
 * 3. LOOKUP TABLE WITH SPECIAL CASES (O(n) time, O(1) space)
 *    Pre-define all subtractive pairs (IV, IX, XL, XC, CD, CM) and single values.
 *    Scan and match patterns, handling special cases first.
 *
 * OPTIMAL SOLUTION: Approach 1 - Left-to-right scanning with subtraction rule
 * Key insight: In Roman numerals, smaller value before larger means subtraction
 *
 * ============================================================
 * LANGUAGE APPROACHES
 * ============================================================
 *
 * C++:
 * - Use unordered_map<char, int> for symbol-to-value mapping
 * - Iterate using for loop with string length
 * - Access characters with s[i] and s[i+1]
 *
 * GO:
 * - Use map[rune]int for symbol-to-value mapping
 * - for range loop over string (Unicode aware)
 * - Convert string to runes using []rune(s)
 *
 * JAVASCRIPT:
 * - Use plain object as map: { 'I': 1, 'V': 5, ... }
 * - for loop or for...of iteration
 * - charAt() or bracket notation for character access
 *
 * PYTHON:
 * - Use dict for symbol-to-value mapping
 * - for loop iterating through string
 * - ord() function if comparing characters
 *
 * JAVA:
 * - Use HashMap<Character, Integer> or switch statement
 * - charAt() for character access
 * - Traditional for loop
 *
 * ============================================================
 * REAL-WORLD APPLICATIONS
 * ============================================================
 *
 * - DATE/TIME FORMATTING: Roman numerals used in clock faces, outlines,
 *   book chapters (e.g., Super Bowl numbers, movie credits).
 *
 * - DOCUMENT GENERATION: Auto-generating chapter numbers, section headers
 *   in legal documents and classical texts.
 *
 * - ACADEMIC CITATIONS: Some citation styles use Roman numerals for
 *   volume numbers in academic publications.
 *
 * - GAME DEVELOPMENT: Achievement systems, level numbering in games,
 *   historical or fantasy-themed applications.
 *
 * - DATA VALIDATION: Converting user input Roman numerals to integers
 *   for processing in booking systems, event scheduling, etc.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanToInt {
    // Method to convert Roman numeral to integer
    public static int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();
        
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);
        
        int ans = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && m.get(s.charAt(i)) < m.get(s.charAt(i + 1))) {
                ans -= m.get(s.charAt(i));
            } else {
                ans += m.get(s.charAt(i));
            }
        }
        
        return ans;
    }

    // Main method to execute the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user for input
        System.out.println("Enter a Roman numeral: ");
        String roman = scanner.nextLine();
        
        // Convert and display the result
        int result = romanToInt(roman);
        System.out.println("The integer value is: " + result);
        
        scanner.close();
    }
}