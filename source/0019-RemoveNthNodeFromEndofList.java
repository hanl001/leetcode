/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        ListNode slow = null; 
        while (fast != null) {
            fast = fast.next;
            // slow is nth pre node
            if (slow == null) {
                slow = head;
            } else {
                slow = slow.next;
            }
        }
    
        // only head node is nth
        if (slow == null) {
            return head.next;
        }

        ListNode nthNode = slow.next;
        slow.next = nthNode.next;
        return head; 
    }
}
