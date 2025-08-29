/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node that points to head
        // This helps handle edge cases like removing the head node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Two pointers: first and second
        ListNode first = dummy;
        ListNode second = dummy;

        // Move 'first' ahead by n+1 steps
        // So that 'second' ends up right before the node to remove
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both until 'first' reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Skip the target node
        second.next = second.next.next;

        // Return new head
        return dummy.next;
    }
}
