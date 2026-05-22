/**
 * Problem: Climbing Stairs
 * Topic: DP
 * Description:
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * 
 * Example 1:
 *
 * 
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * 
 * Example 2:
 *
 * 
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * 
 * Constraints:
 *
 * 	1 <= n <= 45
 */
class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int x = 1;
        int y = 2;

        for (int i = 2; i < n; i++) {
            int temp = x + y;
            x = y;
            y = temp;
        }
        return y;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1: n = 2
        int n1 = 2;
        int expected1 = 2;
        int result1 = sol.climbStairs(n1);
        System.out.println("Test Case 1 (n=" + n1 + "): Expected " + expected1 + ", Got " + result1 + " -> " + (result1 == expected1 ? "PASS" : "FAIL"));

        // Test Case 2: n = 3
        int n2 = 3;
        int expected2 = 3;
        int result2 = sol.climbStairs(n2);
        System.out.println("Test Case 2 (n=" + n2 + "): Expected " + expected2 + ", Got " + result2 + " -> " + (result2 == expected2 ? "PASS" : "FAIL"));

        // Test Case 3: n = 1 (Edge case)
        int n3 = 1;
        int expected3 = 1;
        int result3 = sol.climbStairs(n3);
        System.out.println("Test Case 3 (n=" + n3 + "): Expected " + expected3 + ", Got " + result3 + " -> " + (result3 == expected3 ? "PASS" : "FAIL"));

        // Test Case 4: n = 4
        int n4 = 4;
        int expected4 = 5; // Ways: (1,1,1,1), (1,1,2), (1,2,1), (2,1,1), (2,2)
        int result4 = sol.climbStairs(n4);
        System.out.println("Test Case 4 (n=" + n4 + "): Expected " + expected4 + ", Got " + result4 + " -> " + (result4 == expected4 ? "PASS" : "FAIL"));

        // Test Case 5: n = 5
        int n5 = 5;
        int expected5 = 8; // Ways: F(5) = F(4) + F(3) = 5 + 3 = 8
        int result5 = sol.climbStairs(n5);
        System.out.println("Test Case 5 (n=" + n5 + "): Expected " + expected5 + ", Got " + result5 + " -> " + (result5 == expected5 ? "PASS" : "FAIL"));
    }
}