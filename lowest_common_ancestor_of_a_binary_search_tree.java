import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    // Helper for easy printing in test cases
    @Override
    public String toString() {
        return "TreeNode{" +
               "val=" + val +
               '}';
    }
}

class Solution {
    /**
     * Lowest Common Ancestor of a Binary Search Tree
     * Topic: Tree DFS
     * Description:
     * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
     *
     * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
     *
     * 
     * Example 1:
     *
     *
     * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * Output: 6
     * Explanation: The LCA of nodes 2 and 8 is 6.
     *
     *
     * Example 2:
     *
     *
     * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * Output: 2
     * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
     *
     *
     * Example 3:
     *
     *
     * Input: root = [2,1], p = 2, q = 1
     * Output: 2
     *
     *
     * 
     * Constraints:
     *
     *
     * 	The number of nodes in the tree is in the range [2, 105].
     * 	-109 <= Node.val <= 109
     * 	All Node.val are unique.
     * 	p != q
     * 	p and q will exist in the BST.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    // Helper method to build a TreeNode from an array representation (level order)
    public static TreeNode buildTree(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < values.length && values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    // Helper method to find a node by its value in the tree
    // This is a simple DFS search, not optimized for BST, but works for general trees
    public static TreeNode findNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode leftResult = findNode(root.left, val);
        if (leftResult != null) {
            return leftResult;
        }
        return findNode(root.right, val);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        // Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
        // Output: 6
        Integer[] rootVals1 = {6,2,8,0,4,7,9,null,null,3,5};
        TreeNode root1 = buildTree(rootVals1);
        TreeNode p1 = findNode(root1, 2);
        TreeNode q1 = findNode(root1, 8);
        TreeNode expected1 = findNode(root1, 6);
        TreeNode result1 = sol.lowestCommonAncestor(root1, p1, q1);
        System.out.println("Test Case 1:");
        System.out.println("Input: root = " + Arrays.toString(rootVals1) + ", p = " + p1.val + ", q = " + q1.val);
        System.out.println("Expected: " + expected1.val + ", Got: " + (result1 != null ? result1.val : "null"));
        if (result1 != null && result1.val == expected1.val) {
            System.out.println("Result: PASS\n");
        } else {
            System.out.println("Result: FAIL\n");
        }

        // Test Case 2
        // Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
        // Output: 2
        Integer[] rootVals2 = {6,2,8,0,4,7,9,null,null,3,5};
        TreeNode root2 = buildTree(rootVals2);
        TreeNode p2 = findNode(root2, 2);
        TreeNode q2 = findNode(root2, 4);
        TreeNode expected2 = findNode(root2, 2);
        TreeNode result2 = sol.lowestCommonAncestor(root2, p2, q2);
        System.out.println("Test Case 2:");
        System.out.println("Input: root = " + Arrays.toString(rootVals2) + ", p = " + p2.val + ", q = " + q2.val);
        System.out.println("Expected: " + expected2.val + ", Got: " + (result2 != null ? result2.val : "null"));
        if (result2 != null && result2.val == expected2.val) {
            System.out.println("Result: PASS\n");
        } else {
            System.out.println("Result: FAIL\n");
        }

        // Test Case 3
        // Input: root = [2,1], p = 2, q = 1
        // Output: 2
        Integer[] rootVals3 = {2,1};
        TreeNode root3 = buildTree(rootVals3);
        TreeNode p3 = findNode(root3, 2);
        TreeNode q3 = findNode(root3, 1);
        TreeNode expected3 = findNode(root3, 2);
        TreeNode result3 = sol.lowestCommonAncestor(root3, p3, q3);
        System.out.println("Test Case 3:");
        System.out.println("Input: root = " + Arrays.toString(rootVals3) + ", p = " + p3.val + ", q = " + q3.val);
        System.out.println("Expected: " + expected3.val + ", Got: " + (result3 != null ? result3.val : "null"));
        if (result3 != null && result3.val == expected3.val) {
            System.out.println("Result: PASS\n");
        } else {
            System.out.println("Result: FAIL\n");
        }
    }
}