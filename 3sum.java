import java.util.*;
import java.util.function.BiFunction;

public class Solution {

    /*
     * 3Sum
     *
     * Topic: Two Pointers
     *
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     *
     * Notice that the solution set must not contain duplicate triplets.
     *
     *
     * Example 1:
     *
     *
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     * Explanation:
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
     * The distinct triplets are [-1,0,1] and [-1,-1,2].
     * Notice that the order of the output and the order of the triplets does not matter.
     *
     *
     * Example 2:
     *
     *
     * Input: nums = [0,1,1]
     * Output: []
     * Explanation: The only possible triplet does not sum up to 0.
     *
     *
     * Example 3:
     *
     *
     * Input: nums = [0,0,0]
     * Output: [[0,0,0]]
     * Explanation: The only possible triplet sums up to 0.
     *
     *
     * Constraints:
     *
     *
     * 3 <= nums.length <= 3000
     * -105 <= nums[i] <= 105
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // Placeholder return statement
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Helper to compare lists of lists for equality, ignoring order of triplets and elements within triplets
        // This is crucial for robust testing of 3Sum, as the problem states order does not matter.
        BiFunction<List<List<Integer>>, List<List<Integer>>, Boolean> compareResults = (actual, expected) -> {
            if (actual.size() != expected.size()) {
                return false;
            }
            
            // Sort each inner list (triplet) to handle order of elements within a triplet
            actual.forEach(Collections::sort);
            expected.forEach(Collections::sort);

            // Sort the outer list of lists (triplets) to handle order of triplets
            // Custom comparator for lists of integers
            Comparator<List<Integer>> listComparator = (l1, l2) -> {
                for (int i = 0; i < Math.min(l1.size(), l2.size()); i++) {
                    int cmp = Integer.compare(l1.get(i), l2.get(i));
                    if (cmp != 0) {
                        return cmp;
                    }
                }
                return Integer.compare(l1.size(), l2.size());
            };
            Collections.sort(actual, listComparator);
            Collections.sort(expected, listComparator);

            return actual.equals(expected);
        };

        // Test Case 1: Example 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expected1 = new ArrayList<>();
        expected1.add(Arrays.asList(-1, -1, 2));
        expected1.add(Arrays.asList(-1, 0, 1));
        List<List<Integer>> result1 = sol.threeSum(nums1);
        boolean passed1 = compareResults.apply(result1, expected1);
        System.out.println("Test Case 1:");
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Expected: " + expected1);
        System.out.println("Actual: " + result1);
        System.out.println("Result: " + (passed1 ? "PASS" : "FAIL"));
        System.out.println("--------------------");

        // Test Case 2: Example 2
        int[] nums2 = {0, 1, 1};
        List<List<Integer>> expected2 = new ArrayList<>(); // Empty list
        List<List<Integer>> result2 = sol.threeSum(nums2);
        boolean passed2 = compareResults.apply(result2, expected2);
        System.out.println("Test Case 2:");
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Expected: " + expected2);
        System.out.println("Actual: " + result2);
        System.out.println("Result: " + (passed2 ? "PASS" : "FAIL"));
        System.out.println("--------------------");

        // Test Case 3: Example 3
        int[] nums3 = {0, 0, 0};
        List<List<Integer>> expected3 = new ArrayList<>();
        expected3.add(Arrays.asList(0, 0, 0));
        List<List<Integer>> result3 = sol.threeSum(nums3);
        boolean passed3 = compareResults.apply(result3, expected3);
        System.out.println("Test Case 3:");
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Expected: " + expected3);
        System.out.println("Actual: " + result3);
        System.out.println("Result: " + (passed3 ? "PASS" : "FAIL"));
        System.out.println("--------------------");

        // Test Case 4: Custom case - no solution
        int[] nums4 = {1, 2, 3, 4, 5};
        List<List<Integer>> expected4 = new ArrayList<>();
        List<List<Integer>> result4 = sol.threeSum(nums4);
        boolean passed4 = compareResults.apply(result4, expected4);
        System.out.println("Test Case 4:");
        System.out.println("Input: " + Arrays.toString(nums4));
        System.out.println("Expected: " + expected4);
        System.out.println("Actual: " + result4);
        System.out.println("Result: " + (passed4 ? "PASS" : "FAIL"));
        System.out.println("--------------------");

        // Test Case 5: Custom case - one solution
        int[] nums5 = {-2, 0, 2};
        List<List<Integer>> expected5 = new ArrayList<>();
        expected5.add(Arrays.asList(-2, 0, 2));
        List<List<Integer>> result5 = sol.threeSum(nums5);
        boolean passed5 = compareResults.apply(result5, expected5);
        System.out.println("Test Case 5:");
        System.out.println("Input: " + Arrays.toString(nums5));
        System.out.println("Expected: " + expected5);
        System.out.println("Actual: " + result5);
        System.out.println("Result: " + (passed5 ? "PASS" : "FAIL"));
        System.out.println("--------------------");
    }
}