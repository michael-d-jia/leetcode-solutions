import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
     * Problem: Invert Binary Tree
     * Topic: Tree DFS
     * Description:
     * Given the root of a binary tree, invert the tree, and return its root.
     *
     * 
     * Example 1:
     *
     *
     * Input: root = [4,2,7,1,3,6,9]
     * Output: [4,7,2,9,6,3,1]
     *
     *
     * Example 2:
     *
     *
     * Input: root = [2,1,3]
     * Output: [2,3,1]
     *
     *
     * Example 3:
     *
     *
     * Input: root = []
     * Output: []
     *
     *
     * 
     * Constraints:
     *
     *
     * 	The number of nodes in the tree is in the range [0, 100].
     * 	-100 <= Node.val <= 100
     */
    public TreeNode invertTree(TreeNode root) {
        // Placeholder return statement
        return null;
    }

    // Helper method to build a tree from an array representation (level-order)
    public static TreeNode buildTree(Integer[] arr) {
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
            if (arr[i] != null) {
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

    // Helper method to convert a tree to an array representation (level-order)
    public static Integer[] treeToArray(TreeNode root) {
        if (root == null) {
            return new Integer[]{};
        }

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current != null) {
                list.add(current.val);
                queue.offer(current.left);
                queue.offer(current.right);
            } else {
                list.add(null);
            }
        }

        // Trim trailing nulls to match LeetCode's typical output format
        int lastNonNull = list.size() - 1;
        while (lastNonNull >= 0 && list.get(lastNonNull) == null) {
            lastNonNull--;
        }
        return list.subList(0, lastNonNull + 1).toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1: Example 1
        Integer[] input1 = {4, 2, 7, 1, 3, 6, 9};
        Integer[] expected1 = {4, 7, 2, 9, 6, 3, 1};
        TreeNode root1 = buildTree(input1);
        TreeNode result1 = sol.invertTree(root1);
        Integer[] actual1 = treeToArray(result1);
        System.out.println("Test Case 1:");
        System.out.println("Input: " + Arrays.toString(input1));
        System.out.println("Expected: " + Arrays.toString(expected1));
        System.out.println("Actual: " + Arrays.toString(actual1));
        if (Arrays.equals(expected1, actual1)) {
            System.out.println("Result: PASS\n");
        } else {
            System.out.println("Result: FAIL\n");
        }

        // Test Case 2: Example 2
        Integer[] input2 = {2, 1, 3};
        Integer[] expected2 = {2, 3, 1};
        TreeNode root2 = buildTree(input2);
        TreeNode result2 = sol.invertTree(root2);
        Integer[] actual2 = treeToArray(result2);
        System.out.println("Test Case 2:");
        System.out.println("Input: " + Arrays.toString(input2));
        System.out.println("Expected: " + Arrays.toString(expected2));
        System.out.println("Actual: " + Arrays.toString(actual2));
        if (Arrays.equals(expected2, actual2)) {
            System.out.println("Result: PASS\n");
        } else {
            System.out.println("Result: FAIL\n");
        }

        // Test Case 3: Example 3 (Empty tree)
        Integer[] input3 = {};
        Integer[] expected3 = {};
        TreeNode root3 = buildTree(input3);
        TreeNode result3 = sol.invertTree(root3);
        Integer[] actual3 = treeToArray(result3);
        System.out.println("Test Case 3:");
        System.out.println("Input: " + Arrays.toString(input3));
        System.out.println("Expected: " + Arrays.toString(expected3));
        System.out.println("Actual: " + Arrays.toString(actual3));
        if (Arrays.equals(expected3, actual3)) {
            System.out.println("Result: PASS\n");
        } else {
            System.out.println("Result: FAIL\n");
        }

        // Test Case 4: Single node tree
        Integer[] input4 = {1};
        Integer[] expected4 = {1};
        TreeNode root4 = buildTree(input4);
        TreeNode result4 = sol.invertTree(root4);
        Integer[] actual4 = treeToArray(result4);
        System.out.println("Test Case 4:");
        System.out.println("Input: " + Arrays.toString(input4));
        System.out.println("Expected: " + Arrays.toString(expected4));
        System.out.println("Actual: " + Arrays.toString(actual4));
        if (Arrays.equals(expected4, actual4)) {
            System.out.println("Result: PASS\n");
        } else {
            System.out.println("Result: FAIL\n");
        }

        // Test Case 5: Skewed tree
        // Input: 1 -> right 2 -> right 3
        Integer[] input5 = {1, null, 2, null, null, null, 3}; 
        // Expected: 1 -> left 2 -> left 3
        Integer[] expected5 = {1, 2, null, 3}; 
        TreeNode root5 = buildTree(input5);
        TreeNode result5 = sol.invertTree(root5);
        Integer[] actual5 = treeToArray(result5);
        System.out.println("Test Case 5:");
        System.out.println("Input: " + Arrays.toString(input5));
        System.out.println("Expected: " + Arrays.toString(expected5));
        System.out.println("Actual: " + Arrays.toString(actual5));
        if (Arrays.equals(expected5, actual5)) {
            System.out.println("Result: PASS\n");
        } else {
            System.out.println("Result: FAIL\n");
        }
    }
}