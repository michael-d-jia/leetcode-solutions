
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// This TreeNode class is provided for local testing.
// On LeetCode, it's usually pre-defined.
class TreeNode {
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

class Solution {
    /**
     * Problem: Maximum Depth of Binary Tree
     * Topic: Tree DFS
     * Description:
     * Given the root of a binary tree, return its maximum depth.
     *
     * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     *
     *  
     * Example 1:
     *
     *
     * Input: root = [3,9,20,null,null,15,7]
     * Output: 3
     *
     *
     * Example 2:
     *
     *
     * Input: root = [1,null,2]
     * Output: 2
     *
     *
     *  
     * Constraints:
     *
     *
     * 	The number of nodes in the tree is in the range [0, 104].
     * 	-100 <= Node.val <= 100
     */
    public int maxDepth(TreeNode root) {
        // Placeholder return statement
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1: Example 1
        // Input: root = [3,9,20,null,null,15,7]
        // Expected Output: 3
        TreeNode root1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        int result1 = sol.maxDepth(root1);
        System.out.println("Test Case 1:");
        System.out.println("Input: [3,9,20,null,null,15,7]");
        System.out.println("Expected: 3, Got: " + result1);
        System.out.println(result1 == 3 ? "PASS" : "FAIL");
        System.out.println("--------------------");

        // Test Case 2: Example 2
        // Input: root = [1,null,2]
        // Expected Output: 2
        TreeNode root2 = new TreeNode(1, null, new TreeNode(2));
        int result2 = sol.maxDepth(root2);
        System.out.println("Test Case 2:");
        System.out.println("Input: [1,null,2]");
        System.out.println("Expected: 2, Got: " + result2);
        System.out.println(result2 == 2 ? "PASS" : "FAIL");
        System.out.println("--------------------");

        // Test Case 3: Empty tree
        // Input: root = [] (null)
        // Expected Output: 0
        TreeNode root3 = null;
        int result3 = sol.maxDepth(root3);
        System.out.println("Test Case 3:");
        System.out.println("Input: [] (null)");
        System.out.println("Expected: 0, Got: " + result3);
        System.out.println(result3 == 0 ? "PASS" : "FAIL");
        System.out.println("--------------------");

        // Test Case 4: Single node tree
        // Input: root = [0]
        // Expected Output: 1
        TreeNode root4 = new TreeNode(0);
        int result4 = sol.maxDepth(root4);
        System.out.println("Test Case 4:");
        System.out.println("Input: [0]");
        System.out.println("Expected: 1, Got: " + result4);
        System.out.println(result4 == 1 ? "PASS" : "FAIL");
        System.out.println("--------------------");

        // Test Case 5: More complex tree
        // Input: root = [1,2,3,4,null,null,5]
        // Expected Output: 3
        TreeNode root5 = new TreeNode(1,
                                    new TreeNode(2, new TreeNode(4), null),
                                    new TreeNode(3, null, new TreeNode(5)));
        int result5 = sol.maxDepth(root5);
        System.out.println("Test Case 5:");
        System.out.println("Input: [1,2,3,4,null,null,5]");
        System.out.println("Expected: 3, Got: " + result5);
        System.out.println(result5 == 3 ? "PASS" : "FAIL");
        System.out.println("--------------------");
    }
}