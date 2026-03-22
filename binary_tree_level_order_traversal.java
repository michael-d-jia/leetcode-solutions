import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
     * Binary Tree Level Order Traversal
     * Topic: Tree BFS
     * Description:
     * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
     *
     *
     * Example 1:
     *
     *
     * Input: root = [3,9,20,null,null,15,7]
     * Output: [[3],[9,20],[15,7]]
     *
     *
     * Example 2:
     *
     *
     * Input: root = [1]
     * Output: [[1]]
     *
     *
     * Example 3:
     *
     *
     * Input: root = []
     * Output: []
     *
     *
     * Constraints:
     *
     *
     * 	The number of nodes in the tree is in the range [0, 2000].
     * 	-1000 <= Node.val <= 1000
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Placeholder return statement
        return null;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1: Example 1
        // Input: root = [3,9,20,null,null,15,7]
        TreeNode root1 = new TreeNode(3,
                                      new TreeNode(9),
                                      new TreeNode(20,
                                                   new TreeNode(15),
                                                   new TreeNode(7)));
        List<List<Integer>> expected1 = Arrays.asList(
            Arrays.asList(3),
            Arrays.asList(9, 20),
            Arrays.asList(15, 7)
        );
        List<List<Integer>> result1 = sol.levelOrder(root1);
        System.out.println("Test Case 1: " + (expected1.equals(result1) ? "PASS" : "FAIL"));
        // Uncomment for debugging:
        // System.out.println("Expected: " + expected1 + ", Got: " + result1);

        // Test Case 2: Example 2
        // Input: root = [1]
        TreeNode root2 = new TreeNode(1);
        List<List<Integer>> expected2 = Arrays.asList(
            Arrays.asList(1)
        );
        List<List<Integer>> result2 = sol.levelOrder(root2);
        System.out.println("Test Case 2: " + (expected2.equals(result2) ? "PASS" : "FAIL"));
        // System.out.println("Expected: " + expected2 + ", Got: " + result2);

        // Test Case 3: Example 3
        // Input: root = []
        TreeNode root3 = null;
        List<List<Integer>> expected3 = new ArrayList<>(); // Empty list
        List<List<Integer>> result3 = sol.levelOrder(root3);
        System.out.println("Test Case 3: " + (expected3.equals(result3) ? "PASS" : "FAIL"));
        // System.out.println("Expected: " + expected3 + ", Got: " + result3);

        // Test Case 4: Custom case - a complete binary tree
        // Input: root = [1,2,3,4,5,6,7]
        TreeNode root4 = new TreeNode(1,
                                      new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                                      new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        List<List<Integer>> expected4 = Arrays.asList(
            Arrays.asList(1),
            Arrays.asList(2, 3),
            Arrays.asList(4, 5, 6, 7)
        );
        List<List<Integer>> result4 = sol.levelOrder(root4);
        System.out.println("Test Case 4: " + (expected4.equals(result4) ? "PASS" : "FAIL"));
        // System.out.println("Expected: " + expected4 + ", Got: " + result4);

        // Test Case 5: Custom case - a skewed tree (left-heavy)
        // Input: root = [1,2,null,3,null,4]
        TreeNode root5 = new TreeNode(1,
                                      new TreeNode(2,
                                                   new TreeNode(3,
                                                                new TreeNode(4),
                                                                null),
                                                   null),
                                      null);
        List<List<Integer>> expected5 = Arrays.asList(
            Arrays.asList(1),
            Arrays.asList(2),
            Arrays.asList(3),
            Arrays.asList(4)
        );
        List<List<Integer>> result5 = sol.levelOrder(root5);
        System.out.println("Test Case 5: " + (expected5.equals(result5) ? "PASS" : "FAIL"));
        // System.out.println("Expected: " + expected5 + ", Got: " + result5);
    }
}