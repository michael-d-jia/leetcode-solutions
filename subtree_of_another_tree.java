// All necessary import statements
import java.util.Queue;
import java.util.LinkedList;

// Definition for a binary tree node.
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
     * Problem Title: Subtree of Another Tree
     * Topic: Tree DFS
     * Description:
     * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
     *
     * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
     *
     *
     * Example 1:
     *
     *
     * Input: root = [3,4,5,1,2], subRoot = [4,1,2]
     * Output: true
     *
     *
     * Example 2:
     *
     *
     * Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
     * Output: false
     *
     *
     * Constraints:
     *
     *
     * 	The number of nodes in the root tree is in the range [1, 2000].
     * 	The number of nodes in the subRoot tree is in the range [1, 1000].
     * 	-104 <= root.val <= 104
     * 	-104 <= subRoot.val <= 104
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return (isSameTree(root, subRoot) || isSubtree(root.right, subRoot) || isSubtree(root.left, subRoot));
    }
    public boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            return false;
        }

        return (root.val == subRoot.val && isSameTree(root.right, subRoot.right) && isSameTree(root.left, subRoot.left));

    }

    // Helper method to build a TreeNode from an array representation (level-order)
    public static TreeNode buildTree(Integer[] nodes) {
        if (nodes == null || nodes.length == 0 || nodes[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < nodes.length && nodes[i] != null) {
                current.left = new TreeNode(nodes[i]);
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < nodes.length && nodes[i] != null) {
                current.right = new TreeNode(nodes[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1: Example 1
        Integer[] root1Arr = {3, 4, 5, 1, 2};
        Integer[] subRoot1Arr = {4, 1, 2};
        TreeNode root1 = buildTree(root1Arr);
        TreeNode subRoot1 = buildTree(subRoot1Arr);
        boolean expected1 = true;
        boolean result1 = sol.isSubtree(root1, subRoot1);
        System.out.println("Test Case 1: " + (result1 == expected1 ? "PASS" : "FAIL") +
                           " (Expected: " + expected1 + ", Got: " + result1 + ")");

        // Test Case 2: Example 2
        Integer[] root2Arr = {3, 4, 5, 1, 2, null, null, null, null, 0};
        Integer[] subRoot2Arr = {4, 1, 2};
        TreeNode root2 = buildTree(root2Arr);
        TreeNode subRoot2 = buildTree(subRoot2Arr);
        boolean expected2 = false;
        boolean result2 = sol.isSubtree(root2, subRoot2);
        System.out.println("Test Case 2: " + (result2 == expected2 ? "PASS" : "FAIL") +
                           " (Expected: " + expected2 + ", Got: " + result2 + ")");

        // Test Case 3: subRoot is the root itself
        Integer[] root3Arr = {1, 2, 3};
        Integer[] subRoot3Arr = {1, 2, 3};
        TreeNode root3 = buildTree(root3Arr);
        TreeNode subRoot3 = buildTree(subRoot3Arr);
        boolean expected3 = true;
        boolean result3 = sol.isSubtree(root3, subRoot3);
        System.out.println("Test Case 3: " + (result3 == expected3 ? "PASS" : "FAIL") +
                           " (Expected: " + expected3 + ", Got: " + result3 + ")");

        // Test Case 4: subRoot is a single node found in root
        Integer[] root4Arr = {1, 2, 3, 4, 5};
        Integer[] subRoot4Arr = {3};
        TreeNode root4 = buildTree(root4Arr);
        TreeNode subRoot4 = buildTree(subRoot4Arr);
        boolean expected4 = true;
        boolean result4 = sol.isSubtree(root4, subRoot4);
        System.out.println("Test Case 4: " + (result4 == expected4 ? "PASS" : "FAIL") +
                           " (Expected: " + expected4 + ", Got: " + result4 + ")");

        // Test Case 5: subRoot not found
        Integer[] root5Arr = {1, 2, 3};
        Integer[] subRoot5Arr = {4};
        TreeNode root5 = buildTree(root5Arr);
        TreeNode subRoot5 = buildTree(subRoot5Arr);
        boolean expected5 = false;
        boolean result5 = sol.isSubtree(root5, subRoot5);
        System.out.println("Test Case 5: " + (result5 == expected5 ? "PASS" : "FAIL") +
                           " (Expected: " + expected5 + ", Got: " + result5 + ")");
    }
}