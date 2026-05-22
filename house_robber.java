import java.util.Arrays;

class Solution {
    /*
     * Problem: House Robber
     * Topic: DP
     * Description:
     * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
     *
     * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
     *
     *
     * Example 1:
     *
     *
     * Input: nums = [1,2,3,1]
     * Output: 4
     * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
     * Total amount you can rob = 1 + 3 = 4.
     *
     *
     * Example 2:
     *
     *
     * Input: nums = [2,7,9,3,1]
     * Output: 12
     * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
     * Total amount you can rob = 2 + 9 + 1 = 12.
     *
     *
     * Constraints:
     *
     *
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 400
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int prev1 = Math.max(nums[1], nums[0]);
        int prev2 = nums[0];
        for (int i = 2; i < nums.length; i++) {
            int current = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1: Example 1
        int[] nums1 = {1, 2, 3, 1};
        int expected1 = 4;
        int result1 = sol.rob(nums1);
        System.out.println("Test Case 1 (nums=" + Arrays.toString(nums1) + "): " +
                           (result1 == expected1 ? "PASS" : "FAIL") +
                           " (Expected: " + expected1 + ", Got: " + result1 + ")");

        // Test Case 2: Example 2
        int[] nums2 = {2, 7, 9, 3, 1};
        int expected2 = 12;
        int result2 = sol.rob(nums2);
        System.out.println("Test Case 2 (nums=" + Arrays.toString(nums2) + "): " +
                           (result2 == expected2 ? "PASS" : "FAIL") +
                           " (Expected: " + expected2 + ", Got: " + result2 + ")");

        // Test Case 3: Single house
        int[] nums3 = {10};
        int expected3 = 10;
        int result3 = sol.rob(nums3);
        System.out.println("Test Case 3 (nums=" + Arrays.toString(nums3) + "): " +
                           (result3 == expected3 ? "PASS" : "FAIL") +
                           " (Expected: " + expected3 + ", Got: " + result3 + ")");

        // Test Case 4: Two houses, first is smaller
        int[] nums4 = {1, 2};
        int expected4 = 2;
        int result4 = sol.rob(nums4);
        System.out.println("Test Case 4 (nums=" + Arrays.toString(nums4) + "): " +
                           (result4 == expected4 ? "PASS" : "FAIL") +
                           " (Expected: " + expected4 + ", Got: " + result4 + ")");

        // Test Case 5: Two houses, second is smaller
        int[] nums5 = {2, 1};
        int expected5 = 2;
        int result5 = sol.rob(nums5);
        System.out.println("Test Case 5 (nums=" + Arrays.toString(nums5) + "): " +
                           (result5 == expected5 ? "PASS" : "FAIL") +
                           " (Expected: " + expected5 + ", Got: " + result5 + ")");
    }
}