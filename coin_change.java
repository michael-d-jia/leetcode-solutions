import java.util.Arrays; // Required for Arrays.toString() in main method for printing test cases

class Solution {
    /**
     * Problem: Coin Change
     * Topic: DP
     * Description:
     * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
     *
     * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
     *
     * You may assume that you have an infinite number of each kind of coin.
     *
     * 
     * Example 1:
     * 
     * 
     * Input: coins = [1,2,5], amount = 11
     * Output: 3
     * Explanation: 11 = 5 + 5 + 1
     * 
     * 
     * Example 2:
     * 
     * 
     * Input: coins = [2], amount = 3
     * Output: -1
     * 
     * 
     * Example 3:
     * 
     * 
     * Input: coins = [1], amount = 0
     * Output: 0
     * 
     * 
     * Constraints:
     * 
     * 
     * 1 <= coins.length <= 12
     * 1 <= coins[i] <= 231 - 1
     * 0 <= amount <= 104
     */
    public int coinChange(int[] coins, int amount) {
        // This is a placeholder return statement.
        // You should implement the actual solution here.
        return 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1: Example 1
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        int expected1 = 3;
        int result1 = sol.coinChange(coins1, amount1);
        System.out.println("Test Case 1:");
        System.out.println("Input: coins = " + Arrays.toString(coins1) + ", amount = " + amount1);
        System.out.println("Expected: " + expected1);
        System.out.println("Actual: " + result1);
        System.out.println(result1 == expected1 ? "PASS" : "FAIL");
        System.out.println();

        // Test Case 2: Example 2
        int[] coins2 = {2};
        int amount2 = 3;
        int expected2 = -1;
        int result2 = sol.coinChange(coins2, amount2);
        System.out.println("Test Case 2:");
        System.out.println("Input: coins = " + Arrays.toString(coins2) + ", amount = " + amount2);
        System.out.println("Expected: " + expected2);
        System.out.println("Actual: " + result2);
        System.out.println(result2 == expected2 ? "PASS" : "FAIL");
        System.out.println();

        // Test Case 3: Example 3
        int[] coins3 = {1};
        int amount3 = 0;
        int expected3 = 0;
        int result3 = sol.coinChange(coins3, amount3);
        System.out.println("Test Case 3:");
        System.out.println("Input: coins = " + Arrays.toString(coins3) + ", amount = " + amount3);
        System.out.println("Expected: " + expected3);
        System.out.println("Actual: " + result3);
        System.out.println(result3 == expected3 ? "PASS" : "FAIL");
        System.out.println();

        // Test Case 4: Additional simple case
        int[] coins4 = {1};
        int amount4 = 5;
        int expected4 = 5;
        int result4 = sol.coinChange(coins4, amount4);
        System.out.println("Test Case 4:");
        System.out.println("Input: coins = " + Arrays.toString(coins4) + ", amount = " + amount4);
        System.out.println("Expected: " + expected4);
        System.out.println("Actual: " + result4);
        System.out.println(result4 == expected4 ? "PASS" : "FAIL");
        System.out.println();
    }
}