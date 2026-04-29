import java.util.Arrays; // For Arrays.toString in main method for printing input arrays

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
     * Problem: Merge Two Sorted Lists
     * Topic: Linked List
     * Description:
     * You are given the heads of two sorted linked lists list1 and list2.
     *
     * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
     *
     * Return the head of the merged linked list.
     *
     *  
     * Example 1:
     *
     *
     * Input: list1 = [1,2,4], list2 = [1,3,4]
     * Output: [1,1,2,3,4,4]
     *
     *
     * Example 2:
     *
     *
     * Input: list1 = [], list2 = []
     * Output: []
     *
     *
     * Example 3:
     *
     *
     * Input: list1 = [], list2 = [0]
     * Output: [0]
     *
     *
     *  
     * Constraints:
     *
     *
     * 	The number of nodes in both lists is in the range [0, 50].
     * 	-100 <= Node.val <= 100
     * 	Both list1 and list2 are sorted in non-decreasing order.
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // TODO: Implement the solution here.
        // Placeholder return statement
        return null;
    }

    // Helper method to create a ListNode from an array
    private static ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Helper method to convert a ListNode to a string representation for comparison
    private static String listToString(ListNode head) {
        if (head == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        ListNode current = head;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(",");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1: Example 1
        int[] arr1_1 = {1, 2, 4};
        int[] arr1_2 = {1, 3, 4};
        ListNode list1_1 = createList(arr1_1);
        ListNode list1_2 = createList(arr1_2);
        String expected1 = "[1,1,2,3,4,4]";
        ListNode result1 = sol.mergeTwoLists(list1_1, list1_2);
        String actual1 = listToString(result1);
        System.out.println("Test Case 1:");
        System.out.println("Input: list1=" + Arrays.toString(arr1_1) + ", list2=" + Arrays.toString(arr1_2));
        System.out.println("Expected: " + expected1);
        System.out.println("Actual:   " + actual1);
        System.out.println(expected1.equals(actual1) ? "PASS" : "FAIL");
        System.out.println("--------------------");

        // Test Case 2: Example 2
        int[] arr2_1 = {};
        int[] arr2_2 = {};
        ListNode list2_1 = createList(arr2_1);
        ListNode list2_2 = createList(arr2_2);
        String expected2 = "[]";
        ListNode result2 = sol.mergeTwoLists(list2_1, list2_2);
        String actual2 = listToString(result2);
        System.out.println("Test Case 2:");
        System.out.println("Input: list1=" + Arrays.toString(arr2_1) + ", list2=" + Arrays.toString(arr2_2));
        System.out.println("Expected: " + expected2);
        System.out.println("Actual:   " + actual2);
        System.out.println(expected2.equals(actual2) ? "PASS" : "FAIL");
        System.out.println("--------------------");

        // Test Case 3: Example 3
        int[] arr3_1 = {};
        int[] arr3_2 = {0};
        ListNode list3_1 = createList(arr3_1);
        ListNode list3_2 = createList(arr3_2);
        String expected3 = "[0]";
        ListNode result3 = sol.mergeTwoLists(list3_1, list3_2);
        String actual3 = listToString(result3);
        System.out.println("Test Case 3:");
        System.out.println("Input: list1=" + Arrays.toString(arr3_1) + ", list2=" + Arrays.toString(arr3_2));
        System.out.println("Expected: " + expected3);
        System.out.println("Actual:   " + actual3);
        System.out.println(expected3.equals(actual3) ? "PASS" : "FAIL");
        System.out.println("--------------------");

        // Test Case 4: Custom - one list empty, other non-empty
        int[] arr4_1 = {5};
        int[] arr4_2 = {1, 2, 3};
        ListNode list4_1 = createList(arr4_1);
        ListNode list4_2 = createList(arr4_2);
        String expected4 = "[1,2,3,5]";
        ListNode result4 = sol.mergeTwoLists(list4_1, list4_2);
        String actual4 = listToString(result4);
        System.out.println("Test Case 4:");
        System.out.println("Input: list1=" + Arrays.toString(arr4_1) + ", list2=" + Arrays.toString(arr4_2));
        System.out.println("Expected: " + expected4);
        System.out.println("Actual:   " + actual4);
        System.out.println(expected4.equals(actual4) ? "PASS" : "FAIL");
        System.out.println("--------------------");

        // Test Case 5: Custom - longer lists, different values, negative numbers
        int[] arr5_1 = {-10, 0, 5, 10};
        int[] arr5_2 = {-5, 3, 7, 12};
        ListNode list5_1 = createList(arr5_1);
        ListNode list5_2 = createList(arr5_2);
        String expected5 = "[-10,-5,0,3,5,7,10,12]";
        ListNode result5 = sol.mergeTwoLists(list5_1, list5_2);
        String actual5 = listToString(result5);
        System.out.println("Test Case 5:");
        System.out.println("Input: list1=" + Arrays.toString(arr5_1) + ", list2=" + Arrays.toString(arr5_2));
        System.out.println("Expected: " + expected5);
        System.out.println("Actual:   " + actual5);
        System.out.println(expected5.equals(actual5) ? "PASS" : "FAIL");
        System.out.println("--------------------");
    }
}