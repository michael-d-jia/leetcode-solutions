"""Best Time to Buy and Sell Stock

Topic: Arrays
Description:
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 
Example 1:


Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.


Example 2:


Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.


 
Constraints:


	1 <= prices.length <= 105
	0 <= prices[i] <= 104
"""

from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        pass

if __name__ == "__main__":
    solver = Solution()

    # Test Case 1: Example from problem description
    prices1 = [7, 1, 5, 3, 6, 4]
    expected1 = 5
    assert solver.maxProfit(prices1) == expected1, f"Test Case 1 Failed: Input {prices1}, Expected {expected1}, Got {solver.maxProfit(prices1)}"
    print(f"Test Case 1 Passed: Input {prices1}, Output {solver.maxProfit(prices1)}")

    # Test Case 2: Example from problem description (no profit)
    prices2 = [7, 6, 4, 3, 1]
    expected2 = 0
    assert solver.maxProfit(prices2) == expected2, f"Test Case 2 Failed: Input {prices2}, Expected {expected2}, Got {solver.maxProfit(prices2)}"
    print(f"Test Case 2 Passed: Input {prices2}, Output {solver.maxProfit(prices2)}")

    # Test Case 3: Simple increasing prices
    prices3 = [1, 2]
    expected3 = 1
    assert solver.maxProfit(prices3) == expected3, f"Test Case 3 Failed: Input {prices3}, Expected {expected3}, Got {solver.maxProfit(prices3)}"
    print(f"Test Case 3 Passed: Input {prices3}, Output {solver.maxProfit(prices3)}")

    # Test Case 4: Simple decreasing prices
    prices4 = [2, 1]
    expected4 = 0
    assert solver.maxProfit(prices4) == expected4, f"Test Case 4 Failed: Input {prices4}, Expected {expected4}, Got {solver.maxProfit(prices4)}"
    print(f"Test Case 4 Passed: Input {prices4}, Output {solver.maxProfit(prices4)}")

    # Test Case 5: Single day (no transaction possible)
    prices5 = [1]
    expected5 = 0
    assert solver.maxProfit(prices5) == expected5, f"Test Case 5 Failed: Input {prices5}, Expected {expected5}, Got {solver.maxProfit(prices5)}"
    print(f"Test Case 5 Passed: Input {prices5}, Output {solver.maxProfit(prices5)}")

    print("\nAll test cases passed!")