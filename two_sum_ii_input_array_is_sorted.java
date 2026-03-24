import java.util.Arrays;

class Solution {
    /**
     * Two Sum II - Input Array Is Sorted
     *
     * Topic: Two Pointers
     *
     * Description:
     * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
     *
     * Return the indices of the two numbers index1 and index2, each incremented by one, as an integer array [index1, index2] of length 2.
     *
     * The tests are generated such that there is exactly one solution. You may not use the same element twice.
     *
     * Your solution must use only constant extra space.
     *
     *  
     * Example 1:
     *
     *
     * Input: numbers = [2,7,11,15], target = 9
     * Output: [1,2]
     * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
     *
     *
     * Example 2:
     *
     *
     * Input: numbers = [2,3,4], target = 6
     * Output: [1,3]
     * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
     *
     *
     * Example 3:
     *
     *
     * Input: numbers = [-1,0], target = -1
     * Output: [1,2]
     * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
     *
     *
     *  
     * Constraints:
     *
     *
     * 	2 <= numbers.length <= 3 * 104
     * 	-1000 <= numbers[i] <= 1000
     * 	numbers is sorted in non-decreasing order.
     * 	-1000 <= target <= 1000
     * 	The tests are generated such that there is exactly one solution.
     */
    public int[] twoSum(int[] numbers, int target) {
        // Placeholder return statement.
        // Implement your solution here.
        // 2 pointers
        // left pointer starts at index 0
        // right pointer starts at the end of the numbers array
        // add the values at the pointers and compare to target
        // if it is too big, subtract 1 from right pointer
        // if it is too small, add 1 to left pointer
        // loop this while left is less than right

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[right] + numbers[left] > target) {
                right--;
            } else if (numbers[right] + numbers[left] < target) {
                left++;
            } else {
                return new int[] {left + 1, right + 1};
            }
        }



        return new int[2];
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1
        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] expected1 = {1, 2};
        int[] result1 = solver.twoSum(numbers1, target1);
        System.out.println("Test Case 1:");
        System.out.println("Input: numbers = " + Arrays.toString(numbers1) + ", target = " + target1);
        System.out.println("Expected: " + Arrays.toString(expected1));
        System.out.println("Actual: " + Arrays.toString(result1));
        if (Arrays.equals(result1, expected1)) {
            System.out.println("Result: PASS\n");
        } else {
            System.out.println("Result: FAIL\n");
        }

        // Test Case 2
        int[] numbers2 = {2, 3, 4};
        int target2 = 6;
        int[] expected2 = {1, 3};
        int[] result2 = solver.twoSum(numbers2, target2);
        System.out.println("Test Case 2:");
        System.out.println("Input: numbers = " + Arrays.toString(numbers2) + ", target = " + target2);
        System.out.println("Expected: " + Arrays.toString(expected2));
        System.out.println("Actual: " + Arrays.toString(result2));
        if (Arrays.equals(result2, expected2)) {
            System.out.println("Result: PASS\n");
        } else {
            System.out.println("Result: FAIL\n");
        }

        // Test Case 3
        int[] numbers3 = {-1, 0};
        int target3 = -1;
        int[] expected3 = {1, 2};
        int[] result3 = solver.twoSum(numbers3, target3);
        System.out.println("Test Case 3:");
        System.out.println("Input: numbers = " + Arrays.toString(numbers3) + ", target = " + target3);
        System.out.println("Expected: " + Arrays.toString(expected3));
        System.out.println("Actual: " + Arrays.toString(result3));
        if (Arrays.equals(result3, expected3)) {
            System.out.println("Result: PASS\n");
        } else {
            System.out.println("Result: FAIL\n");
        }
    }
}