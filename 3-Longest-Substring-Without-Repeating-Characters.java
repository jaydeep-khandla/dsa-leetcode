import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= start) {
                start = charIndexMap.get(currentChar) + 1; 
            }

            charIndexMap.put(currentChar, i); 
            maxLength = Math.max(maxLength, i - start + 1); 
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example inputs to test
        String test1 = "abcabcbb";
        String test2 = "bbbbb";
        String test3 = "pwwkew";
        String test4 = "";
        String test5 = " ";

        // Call the method and print results
        System.out.println(solution.lengthOfLongestSubstring(test1)); // Expected: 3
        System.out.println(solution.lengthOfLongestSubstring(test2)); // Expected: 1
        System.out.println(solution.lengthOfLongestSubstring(test3)); // Expected: 3
        System.out.println(solution.lengthOfLongestSubstring(test4)); // Expected: 0
        System.out.println(solution.lengthOfLongestSubstring(test5)); // Expected: 1
    }
}