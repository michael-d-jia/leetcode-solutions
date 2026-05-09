import java.util.*;

class Solution {
    /**
     * Problem: Best Time to Buy and Sell Stock
     * Topic: Sliding Window
     * Description:
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     *
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
     *
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     *
     * 
     * Example 1:
     *
     *
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     *
     *
     * Example 2:
     *
     *
     * Input: prices = [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transactions are done and the max profit = 0.
     *
     *
     * Constraints:
     *
     *
     * 1 <= prices.length <= 105
     * 0 <= prices[i] <= 104
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > profit) {
                profit = prices[i] - minPrice;
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Cases
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int expected1 = 5;
        int result1 = sol.maxProfit(prices1);
        System.out.println("Test Case 1: Input = " + Arrays.toString(prices1) + ", Expected = " + expected1 + ", Got = " + result1);
        System.out.println(result1 == expected1 ? "PASS" : "FAIL");
        System.out.println("--------------------");

        int[] prices2 = {7, 6, 4, 3, 1};
        int expected2 = 0;
        int result2 = sol.maxProfit(prices2);
        System.out.println("Test Case 2: Input = " + Arrays.toString(prices2) + ", Expected = " + expected2 + ", Got = " + result2);
        System.out.println(result2 == expected2 ? "PASS" : "FAIL");
        System.out.println("--------------------");

        int[] prices3 = {2, 4, 1};
        int expected3 = 2; // Buy at 2, sell at 4. Profit = 2
        int result3 = sol.maxProfit(prices3);
        System.out.println("Test Case 3: Input = " + Arrays.toString(prices3) + ", Expected = " + expected3 + ", Got = " + result3);
        System.out.println(result3 == expected3 ? "PASS" : "FAIL");
        System.out.println("--------------------");

        int[] prices4 = {1, 2};
        int expected4 = 1; // Buy at 1, sell at 2. Profit = 1
        int result4 = sol.maxProfit(prices4);
        System.out.println("Test Case 4: Input = " + Arrays.toString(prices4) + ", Expected = " + expected4 + ", Got = " + result4);
        System.out.println(result4 == expected4 ? "PASS" : "FAIL");
        System.out.println("--------------------");

        int[] prices5 = {3, 3, 5, 0, 0, 3, 1, 4};
        int expected5 = 4; // Buy at 0, sell at 4. Profit = 4
        int result5 = sol.maxProfit(prices5);
        System.out.println("Test Case 5: Input = " + Arrays.toString(prices5) + ", Expected = " + expected5 + ", Got = " + result5);
        System.out.println(result5 == expected5 ? "PASS" : "FAIL");
        System.out.println("--------------------");
    }
}