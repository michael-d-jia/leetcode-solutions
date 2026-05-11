import java.util.PriorityQueue; // Often used for Heap problems

/**
 * Problem: Kth Largest Element in an Array
 * Topic: Heap
 * Description:
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Can you solve it without sorting?
 *
 *  
 * Example 1:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 *  
 * Constraints:
 *
 *
 * 	1 <= k <= nums.length <= 105
 * 	-104 <= nums[i] <= 104
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Time Complexity: O(n log(k))
        // Space Complexity: O(n) where n = k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if(minHeap.size() < k || minHeap.peek() < nums[i]) {
                minHeap.add(nums[i]);
                if (minHeap.size() > k) {
                    minHeap.remove();
                }
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1: Example from problem description
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        int expected1 = 5;
        int result1 = solver.findKthLargest(nums1, k1);
        System.out.println("Test Case 1: " + (result1 == expected1 ? "PASS" : "FAIL") +
                           " (Input: " + java.util.Arrays.toString(nums1) + ", k=" + k1 +
                           ", Expected: " + expected1 + ", Got: " + result1 + ")");

        // Test Case 2: Example from problem description
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        int expected2 = 4;
        int result2 = solver.findKthLargest(nums2, k2);
        System.out.println("Test Case 2: " + (result2 == expected2 ? "PASS" : "FAIL") +
                           " (Input: " + java.util.Arrays.toString(nums2) + ", k=" + k2 +
                           ", Expected: " + expected2 + ", Got: " + result2 + ")");

        // Test Case 3: Smallest array
        int[] nums3 = {1};
        int k3 = 1;
        int expected3 = 1;
        int result3 = solver.findKthLargest(nums3, k3);
        System.out.println("Test Case 3: " + (result3 == expected3 ? "PASS" : "FAIL") +
                           " (Input: " + java.util.Arrays.toString(nums3) + ", k=" + k3 +
                           ", Expected: " + expected3 + ", Got: " + result3 + ")");

        // Test Case 4: All same elements
        int[] nums4 = {7, 7, 7, 7};
        int k4 = 2;
        int expected4 = 7;
        int result4 = solver.findKthLargest(nums4, k4);
        System.out.println("Test Case 4: " + (result4 == expected4 ? "PASS" : "FAIL") +
                           " (Input: " + java.util.Arrays.toString(nums4) + ", k=" + k4 +
                           ", Expected: " + expected4 + ", Got: " + result4 + ")");

        // Test Case 5: Negative numbers
        int[] nums5 = {-1, -2, -3, -4, -5};
        int k5 = 2;
        int expected5 = -2; // Sorted: [-5, -4, -3, -2, -1]. 2nd largest is -2.
        int result5 = solver.findKthLargest(nums5, k5);
        System.out.println("Test Case 5: " + (result5 == expected5 ? "PASS" : "FAIL") +
                           " (Input: " + java.util.Arrays.toString(nums5) + ", k=" + k5 +
                           ", Expected: " + expected5 + ", Got: " + result5 + ")");
    }
}