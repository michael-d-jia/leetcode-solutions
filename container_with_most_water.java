import java.util.Arrays; // Required for Arrays.toString in main method for printing test case inputs

class Solution {
    /**
     * Problem Title: Container With Most Water
     * Topic: Two Pointers
     * Description:
     * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
     *
     * Find two lines that together with the x-axis form a container, such that the container contains the most water.
     *
     * Return the maximum amount of water a container can store.
     *
     * Notice that you may not slant the container.
     *
     *
     * Example 1:
     *
     *
     * Input: height = [1,8,6,2,5,4,8,3,7]
     * Output: 49
     * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
     *
     *
     * Example 2:
     *
     *
     * Input: height = [1,1]
     * Output: 1
     *
     *
     * Constraints:
     *
     *
     * 	n == height.length
     * 	2 <= n <= 105
     * 	0 <= height[i] <= 104
     */
    public int maxArea(int[] height) {
        // Placeholder return statement
        return 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1: Example from problem description
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int expected1 = 49;
        int result1 = sol.maxArea(height1);
        System.out.println("Test Case 1:");
        System.out.println("Input: " + Arrays.toString(height1));
        System.out.println("Expected: " + expected1);
        System.out.println("Actual: " + result1);
        System.out.println(result1 == expected1 ? "PASS" : "FAIL");
        System.out.println("--------------------");

        // Test Case 2: Example from problem description
        int[] height2 = {1, 1};
        int expected2 = 1;
        int result2 = sol.maxArea(height2);
        System.out.println("Test Case 2:");
        System.out.println("Input: " + Arrays.toString(height2));
        System.out.println("Expected: " + expected2);
        System.out.println("Actual: " + result2);
        System.out.println(result2 == expected2 ? "PASS" : "FAIL");
        System.out.println("--------------------");

        // Test Case 3: Custom simple case
        int[] height3 = {4, 3, 2, 1, 4};
        int expected3 = 16; // min(height[0], height[4]) * (4-0) = min(4,4) * 4 = 16
        int result3 = sol.maxArea(height3);
        System.out.println("Test Case 3:");
        System.out.println("Input: " + Arrays.toString(height3));
        System.out.println("Expected: " + expected3);
        System.out.println("Actual: " + result3);
        System.out.println(result3 == expected3 ? "PASS" : "FAIL");
        System.out.println("--------------------");

        // Test Case 4: Another custom case with varying heights
        int[] height4 = {2, 1, 5, 6, 2, 3};
        int expected4 = 10; // Max area is between height[0]=2 and height[5]=3, width=5. min(2,3)*5 = 10.
        int result4 = sol.maxArea(height4);
        System.out.println("Test Case 4:");
        System.out.println("Input: " + Arrays.toString(height4));
        System.out.println("Expected: " + expected4);
        System.out.println("Actual: " + result4);
        System.out.println(result4 == expected4 ? "PASS" : "FAIL");
        System.out.println("--------------------");

        // Test Case 5: Decreasing sequence
        int[] height5 = {7, 6, 5, 4, 3, 2, 1};
        int expected5 = 12; // Max area is between height[0]=7 and height[3]=4, width=3. min(7,4)*3 = 12.
        int result5 = sol.maxArea(height5);
        System.out.println("Test Case 5:");
        System.out.println("Input: " + Arrays.toString(height5));
        System.out.println("Expected: " + expected5);
        System.out.println("Actual: " + result5);
        System.out.println(result5 == expected5 ? "PASS" : "FAIL");
        System.out.println("--------------------");
    }
}