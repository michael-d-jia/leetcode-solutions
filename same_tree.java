import java.util.Queue;
import java.util.LinkedList;

/**
 * Problem: Same Tree
 * Topic: Tree DFS
 * Description:
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 *  
 * Example 1:
 *
 *
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 *
 *
 * Example 3:
 *
 *
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 *
 *
 *  
 * Constraints:
 *
 *
 * 	The number of nodes in both trees is in the range [0, 100].
 * 	-104 <= Node.val <= 104
 */
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        if (p.val == q.val) {
            return (isSameTree(p.right, q.right) && isSameTree(p.left, q.left));
        }
        return false;
    }

    // Helper method to build a tree from an array representation (BFS level order)
    private static TreeNode buildTree(Integer[] arr) {
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

        // Test Case 1: Example 1
        // p = [1,2,3], q = [1,2,3] -> Output: true
        Integer[] p1_arr = {1, 2, 3};
        Integer[] q1_arr = {1, 2, 3};
        TreeNode p1 = buildTree(p1_arr);
        TreeNode q1 = buildTree(q1_arr);
        boolean expected1 = true;
        boolean result1 = sol.isSameTree(p1, q1);
        System.out.println("Test Case 1: " + (result1 == expected1 ? "PASS" : "FAIL") +
                           " (Expected: " + expected1 + ", Got: " + result1 + ")");

        // Test Case 2: Example 2
        // p = [1,2], q = [1,null,2] -> Output: false
        Integer[] p2_arr = {1, 2};
        Integer[] q2_arr = {1, null, 2};
        TreeNode p2 = buildTree(p2_arr);
        TreeNode q2 = buildTree(q2_arr);
        boolean expected2 = false;
        boolean result2 = sol.isSameTree(p2, q2);
        System.out.println("Test Case 2: " + (result2 == expected2 ? "PASS" : "FAIL") +
                           " (Expected: " + expected2 + ", Got: " + result2 + ")");

        // Test Case 3: Example 3
        // p = [1,2,1], q = [1,1,2] -> Output: false
        Integer[] p3_arr = {1, 2, 1};
        Integer[] q3_arr = {1, 1, 2};
        TreeNode p3 = buildTree(p3_arr);
        TreeNode q3 = buildTree(q3_arr);
        boolean expected3 = false;
        boolean result3 = sol.isSameTree(p3, q3);
        System.out.println("Test Case 3: " + (result3 == expected3 ? "PASS" : "FAIL") +
                           " (Expected: " + expected3 + ", Got: " + result3 + ")");

        // Test Case 4: Both empty trees
        // p = [], q = [] -> Output: true
        Integer[] p4_arr = {};
        Integer[] q4_arr = {};
        TreeNode p4 = buildTree(p4_arr);
        TreeNode q4 = buildTree(q4_arr);
        boolean expected4 = true;
        boolean result4 = sol.isSameTree(p4, q4);
        System.out.println("Test Case 4: " + (result4 == expected4 ? "PASS" : "FAIL") +
                           " (Expected: " + expected4 + ", Got: " + result4 + ")");

        // Test Case 5: One empty, one non-empty
        // p = [1], q = [] -> Output: false
        Integer[] p5_arr = {1};
        Integer[] q5_arr = {};
        TreeNode p5 = buildTree(p5_arr);
        TreeNode q5 = buildTree(q5_arr);
        boolean expected5 = false;
        boolean result5 = sol.isSameTree(p5, q5);
        System.out.println("Test Case 5: " + (result5 == expected5 ? "PASS" : "FAIL") +
                           " (Expected: " + expected5 + ", Got: " + result5 + ")");
    }
}