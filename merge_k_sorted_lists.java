import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects; 
import java.util.PriorityQueue;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    /**
     * Problem: Merge k Sorted Lists
     * Topic: Heap + Linked List
     * Description:
     * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
     *
     * Merge all the linked-lists into one sorted linked-list and return it.
     *
     *  
     * Example 1:
     *
     *
     * Input: lists = [[1,4,5],[1,3,4],[2,6]]
     * Output: [1,1,2,3,4,4,5,6]
     * Explanation: The linked-lists are:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * merging them into one sorted linked list:
     * 1->1->2->3->4->4->5->6
     *
     *
     * Example 2:
     *
     *
     * Input: lists = []
     * Output: []
     *
     *
     * Example 3:
     *
     *
     * Input: lists = [[]]
     * Output: []
     *
     *
     *  
     * Constraints:
     *
     *
     * 	k == lists.length
     * 	0 <= k <= 104
     * 	0 <= lists[i].length <= 500
     * 	-104 <= lists[i][j] <= 104
     * 	lists[i] is sorted in ascending order.
     * 	The sum of lists[i].length will not exceed 104.
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode point = head;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }
        while (!minHeap.isEmpty()) {
            point.next = minHeap.poll();
            point = point.next;
            if (point.next != null) {
                minHeap.add(point.next);
            }
        }
        return head.next;
    }

    // Helper method to create a linked list from an array
    private static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to convert a linked list to an ArrayList for easy comparison
    private static List<Integer> linkedListToArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        return list;
    }

    // Generic test case runner
    private static void testCase(String name, ListNode[] input, ListNode expectedOutput, Solution sol) {
        System.out.println("--- " + name + " ---");
        List<Integer> expected = linkedListToArray(expectedOutput);
        ListNode actualOutput = sol.mergeKLists(input);
        List<Integer> actual = linkedListToArray(actualOutput);

        System.out.println("Input lists: " + Arrays.deepToString(Arrays.stream(input).map(Solution::linkedListToArray).toArray()));
        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + actual);

        if (Objects.equals(expected, actual)) {
            System.out.println("Result: PASS\n");
        } else {
            System.out.println("Result: FAIL\n");
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        ListNode[] lists1 = new ListNode[]{
            createLinkedList(new int[]{1, 4, 5}),
            createLinkedList(new int[]{1, 3, 4}),
            createLinkedList(new int[]{2, 6})
        };
        ListNode expected1 = createLinkedList(new int[]{1, 1, 2, 3, 4, 4, 5, 6});
        testCase("Example 1", lists1, expected1, sol);

        // Example 2
        ListNode[] lists2 = new ListNode[]{};
        ListNode expected2 = createLinkedList(new int[]{});
        testCase("Example 2", lists2, expected2, sol);

        // Example 3
        ListNode[] lists3 = new ListNode[]{
            createLinkedList(new int[]{})
        };
        ListNode expected3 = createLinkedList(new int[]{});
        testCase("Example 3", lists3, expected3, sol);

        // Custom Test Case 1: Two simple lists
        ListNode[] lists4 = new ListNode[]{
            createLinkedList(new int[]{1, 2}),
            createLinkedList(new int[]{3, 4})
        };
        ListNode expected4 = createLinkedList(new int[]{1, 2, 3, 4});
        testCase("Custom Test Case 1 (Two lists)", lists4, expected4, sol);

        // Custom Test Case 2: Multiple empty lists
        ListNode[] lists5 = new ListNode[]{
            createLinkedList(new int[]{}),
            createLinkedList(new int[]{}),
            createLinkedList(new int[]{})
        };
        ListNode expected5 = createLinkedList(new int[]{});
        testCase("Custom Test Case 2 (Multiple empty lists)", lists5, expected5, sol);

        // Custom Test Case 3: One non-empty list among empty ones
        ListNode[] lists6 = new ListNode[]{
            createLinkedList(new int[]{}),
            createLinkedList(new int[]{7, 8, 9}),
            createLinkedList(new int[]{})
        };
        ListNode expected6 = createLinkedList(new int[]{7, 8, 9});
        testCase("Custom Test Case 3 (One non-empty list)", lists6, expected6, sol);
    }
}