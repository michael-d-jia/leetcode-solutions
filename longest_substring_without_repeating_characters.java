import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Longest Substring Without Repeating Characters
 * Topic: Sliding Window
 * Description:
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 * 
 * Example 1:
 *
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
 *
 *
 * Example 2:
 *
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 *
 * Example 3:
 *
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 *
 * 	0 <= s.length <= 5 * 104
 * 	s consists of English letters, digits, symbols and spaces.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // TODO: Implement the solution here.
        // Placeholder return statement
        return 0;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1: Example from problem description
        String s1 = "abcabcbb";
        int expected1 = 3;
        int result1 = solver.lengthOfLongestSubstring(s1);
        System.out.println("Test Case 1 (s = \"" + s1 + "\"): " + (result1 == expected1 ? "PASS" : "FAIL") + " (Expected: " + expected1 + ", Got: " + result1 + ")");

        // Test Case 2: Example from problem description
        String s2 = "bbbbb";
        int expected2 = 1;
        int result2 = solver.lengthOfLongestSubstring(s2);
        System.out.println("Test Case 2 (s = \"" + s2 + "\"): " + (result2 == expected2 ? "PASS" : "FAIL") + " (Expected: " + expected2 + ", Got: " + result2 + ")");

        // Test Case 3: Example from problem description
        String s3 = "pwwkew";
        int expected3 = 3;
        int result3 = solver.lengthOfLongestSubstring(s3);
        System.out.println("Test Case 3 (s = \"" + s3 + "\"): " + (result3 == expected3 ? "PASS" : "FAIL") + " (Expected: " + expected3 + ", Got: " + result3 + ")");

        // Test Case 4: Empty string
        String s4 = "";
        int expected4 = 0;
        int result4 = solver.lengthOfLongestSubstring(s4);
        System.out.println("Test Case 4 (s = \"" + s4 + "\"): " + (result4 == expected4 ? "PASS" : "FAIL") + " (Expected: " + expected4 + ", Got: " + result4 + ")");

        // Test Case 5: Single character string
        String s5 = "a";
        int expected5 = 1;
        int result5 = solver.lengthOfLongestSubstring(s5);
        System.out.println("Test Case 5 (s = \"" + s5 + "\"): " + (result5 == expected5 ? "PASS" : "FAIL") + " (Expected: " + expected5 + ", Got: " + result5 + ")");
    }
}