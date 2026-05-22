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
    /*
     * Problem: Validate Binary Search Tree
     * Topic: Tree DFS
     * Description:
     * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
     *
     * A valid BST is defined as follows:
     *
     *
     * 	The left subtree of a node contains only nodes with keys strictly less than the node's key.
     * 	The right subtree of a node contains only nodes with keys strictly greater than the node's key.
     * 	Both the left and right subtrees must also be binary search trees.
     *
     *
     * Example 1:
     *
     *
     * Input: root = [2,1,3]
     * Output: true
     *
     *
     * Example 2:
     *
     *
     * Input: root = [5,1,4,null,null,3,6]
     * Output: false
     * Explanation: The root node's value is 5 but its right child's value is 4.
     *
     *
     * Constraints:
     *
     *
     * 	The number of nodes in the tree is in the range [1, 104].
     * 	-231 <= Node.val <= 231 - 1
     */
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }
    public boolean isValid(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min) {
            return false;
        } else if (max != null && root.val >= max) {
            return false;
        }
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }

    /**
     * Helper method to build a binary tree from an array representation (level-order).
     * Null values in the array represent missing nodes.
     * Example: [3,9,20,null,null,15,7]
     * @param arr The array of Integer values representing the tree.
     * @return The root TreeNode of the constructed tree.
     */
    public static TreeNode buildTreeFromArray(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1: Example 1 - Valid BST
        Integer[] arr1 = {2, 1, 3};
        TreeNode root1 = buildTreeFromArray(arr1);
        boolean expected1 = true;
        boolean result1 = sol.isValidBST(root1);
        System.out.println("Test Case 1 (root = [2,1,3]): " + (result1 == expected1 ? "PASS" : "FAIL") + " (Expected: " + expected1 + ", Got: " + result1 + ")");

        // Test Case 2: Example 2 - Invalid BST (right child of 5 is 4)
        Integer[] arr2 = {5, 1, 4, null, null, 3, 6};
        TreeNode root2 = buildTreeFromArray(arr2);
        boolean expected2 = false;
        boolean result2 = sol.isValidBST(root2);
        System.out.println("Test Case 2 (root = [5,1,4,null,null,3,6]): " + (result2 == expected2 ? "PASS" : "FAIL") + " (Expected: " + expected2 + ", Got: " + result2 + ")");

        // Test Case 3: Single node - Valid BST
        Integer[] arr3 = {1};
        TreeNode root3 = buildTreeFromArray(arr3);
        boolean expected3 = true;
        boolean result3 = sol.isValidBST(root3);
        System.out.println("Test Case 3 (root = [1]): " + (result3 == expected3 ? "PASS" : "FAIL") + " (Expected: " + expected3 + ", Got: " + result3 + ")");

        // Test Case 4: Larger Valid BST
        Integer[] arr4 = {10, 5, 15, null, null, 12, 20}; // 12 is > 10 and < 15, 20 is > 15
        TreeNode root4 = buildTreeFromArray(arr4);
        boolean expected4 = true;
        boolean result4 = sol.isValidBST(root4);
        System.out.println("Test Case 4 (root = [10,5,15,null,null,12,20]): " + (result4 == expected4 ? "PASS" : "FAIL") + " (Expected: " + expected4 + ", Got: " + result4 + ")");

        // Test Case 5: Invalid BST (left child greater than parent)
        Integer[] arr5 = {5, 6, 4}; // 6 is not strictly less than 5
        TreeNode root5 = buildTreeFromArray(arr5);
        boolean expected5 = false;
        boolean result5 = sol.isValidBST(root5);
        System.out.println("Test Case 5 (root = [5,6,4]): " + (result5 == expected5 ? "PASS" : "FAIL") + " (Expected: " + expected5 + ", Got: " + result5 + ")");

        // Test Case 6: Invalid BST (right child less than parent)
        Integer[] arr6 = {5, 1, 3}; // 3 is not strictly greater than 5
        TreeNode root6 = buildTreeFromArray(arr6);
        boolean expected6 = false;
        boolean result6 = sol.isValidBST(root6);
        System.out.println("Test Case 6 (root = [5,1,3]): " + (result6 == expected6 ? "PASS" : "FAIL") + " (Expected: " + expected6 + ", Got: " + result6 + ")");
    }
}