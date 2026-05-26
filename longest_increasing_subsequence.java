import java.util.Arrays;
// import java.util.ArrayList;
// import java.util.List;

/**
 * Problem: Longest Increasing Subsequence
 * Topic: DP
 * Description:
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 *  
 * Example 1:
 *
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 *
 *
 * Example 3:
 *
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 *
 *  
 * Constraints:
 *
 *
 * 	1 <= nums.length <= 2500
 * 	-104 <= nums[i] <= 104
 *
 *
 *  
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        // Placeholder return statement.
        // Implement your solution here.
        return 0;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1: Example from problem description
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int expected1 = 4;
        int result1 = solver.lengthOfLIS(nums1);
        System.out.println("Test Case 1:");
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Expected: " + expected1);
        System.out.println("Result: " + result1);
        System.out.println(result1 == expected1 ? "PASS" : "FAIL");
        System.out.println();

        // Test Case 2: Example from problem description
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        int expected2 = 4;
        int result2 = solver.lengthOfLIS(nums2);
        System.out.println("Test Case 2:");
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Expected: " + expected2);
        System.out.println("Result: " + result2);
        System.out.println(result2 == expected2 ? "PASS" : "FAIL");
        System.out.println();

        // Test Case 3: Example from problem description
        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        int expected3 = 1;
        int result3 = solver.lengthOfLIS(nums3);
        System.out.println("Test Case 3:");
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Expected: " + expected3);
        System.out.println("Result: " + result3);
        System.out.println(result3 == expected3 ? "PASS" : "FAIL");
        System.out.println();

        // Test Case 4: Custom test case
        int[] nums4 = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        int expected4 = 6; // LIS: [1, 3, 6, 7, 9, 10]
        int result4 = solver.lengthOfLIS(nums4);
        System.out.println("Test Case 4:");
        System.out.println("Input: " + Arrays.toString(nums4));
        System.out.println("Expected: " + expected4);
        System.out.println("Result: " + result4);
        System.out.println(result4 == expected4 ? "PASS" : "FAIL");
        System.out.println();

        // Test Case 5: Simple increasing sequence
        int[] nums5 = {1, 2, 3, 4, 5};
        int expected5 = 5;
        int result5 = solver.lengthOfLIS(nums5);
        System.out.println("Test Case 5:");
        System.out.println("Input: " + Arrays.toString(nums5));
        System.out.println("Expected: " + expected5);
        System.out.println("Result: " + result5);
        System.out.println(result5 == expected5 ? "PASS" : "FAIL");
        System.out.println();
    }
}