import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    /**
     * Problem: Reverse Linked List
     * Topic: Linked List
     * Description:
     * Given the head of a singly linked list, reverse the list, and return the reversed list.
     *
     *  
     * Example 1:
     *
     *
     * Input: head = [1,2,3,4,5]
     * Output: [5,4,3,2,1]
     *
     *
     * Example 2:
     *
     *
     * Input: head = [1,2]
     * Output: [2,1]
     *
     *
     * Example 3:
     *
     *
     * Input: head = []
     * Output: []
     *
     *
     *  
     * Constraints:
     *
     *
     * 	The number of nodes in the list is the range [0, 5000].
     * 	-5000 <= Node.val <= 5000
     *
     *
     *  
     * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
     */
    public ListNode reverseList(ListNode head) {
        // Placeholder return statement
        // T: O(n) S: O(1)
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode current = this;
            while (current != null) {
                sb.append(current.val);
                if (current.next != null) {
                    sb.append("->");
                }
                current = current.next;
            }
            return sb.toString();
        }
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

    // Helper method to convert a linked list to an ArrayList for comparison
    private static List<Integer> linkedListToArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();

        // Test Case 1: Example 1
        int[] input1 = {1, 2, 3, 4, 5};
        int[] expectedArr1 = {5, 4, 3, 2, 1};
        List<Integer> expectedList1 = Arrays.stream(expectedArr1).boxed().collect(Collectors.toList());
        ListNode head1 = createLinkedList(input1);
        ListNode result1 = solver.reverseList(head1);
        List<Integer> actual1 = linkedListToArray(result1);
        boolean pass1 = actual1.equals(expectedList1);
        System.out.println("Test Case 1: " + (pass1 ? "PASS" : "FAIL"));
        if (!pass1) {
            System.out.println("  Input: " + Arrays.toString(input1));
            System.out.println("  Expected: " + expectedList1);
            System.out.println("  Actual: " + actual1);
        }

        // Test Case 2: Example 2
        int[] input2 = {1, 2};
        int[] expectedArr2 = {2, 1};
        List<Integer> expectedList2 = Arrays.stream(expectedArr2).boxed().collect(Collectors.toList());
        ListNode head2 = createLinkedList(input2);
        ListNode result2 = solver.reverseList(head2);
        List<Integer> actual2 = linkedListToArray(result2);
        boolean pass2 = actual2.equals(expectedList2);
        System.out.println("Test Case 2: " + (pass2 ? "PASS" : "FAIL"));
        if (!pass2) {
            System.out.println("  Input: " + Arrays.toString(input2));
            System.out.println("  Expected: " + expectedList2);
            System.out.println("  Actual: " + actual2);
        }

        // Test Case 3: Example 3 (empty list)
        int[] input3 = {};
        int[] expectedArr3 = {};
        List<Integer> expectedList3 = Arrays.stream(expectedArr3).boxed().collect(Collectors.toList());
        ListNode head3 = createLinkedList(input3);
        ListNode result3 = solver.reverseList(head3);
        List<Integer> actual3 = linkedListToArray(result3);
        boolean pass3 = actual3.equals(expectedList3);
        System.out.println("Test Case 3: " + (pass3 ? "PASS" : "FAIL"));
        if (!pass3) {
            System.out.println("  Input: " + Arrays.toString(input3));
            System.out.println("  Expected: " + expectedList3);
            System.out.println("  Actual: " + actual3);
        }

        // Test Case 4: Single node list
        int[] input4 = {1};
        int[] expectedArr4 = {1};
        List<Integer> expectedList4 = Arrays.stream(expectedArr4).boxed().collect(Collectors.toList());
        ListNode head4 = createLinkedList(input4);
        ListNode result4 = solver.reverseList(head4);
        List<Integer> actual4 = linkedListToArray(result4);
        boolean pass4 = actual4.equals(expectedList4);
        System.out.println("Test Case 4: " + (pass4 ? "PASS" : "FAIL"));
        if (!pass4) {
            System.out.println("  Input: " + Arrays.toString(input4));
            System.out.println("  Expected: " + expectedList4);
            System.out.println("  Actual: " + actual4);
        }

        // Test Case 5: Two nodes, already reversed (edge case)
        int[] input5 = {2, 1};
        int[] expectedArr5 = {1, 2};
        List<Integer> expectedList5 = Arrays.stream(expectedArr5).boxed().collect(Collectors.toList());
        ListNode head5 = createLinkedList(input5);
        ListNode result5 = solver.reverseList(head5);
        List<Integer> actual5 = linkedListToArray(result5);
        boolean pass5 = actual5.equals(expectedList5);
        System.out.println("Test Case 5: " + (pass5 ? "PASS" : "FAIL"));
        if (!pass5) {
            System.out.println("  Input: " + Arrays.toString(input5));
            System.out.println("  Expected: " + expectedList5);
            System.out.println("  Actual: " + actual5);
        }
    }
}