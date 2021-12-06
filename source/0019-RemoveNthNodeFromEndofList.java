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
        //ListNode fast = head;
        //for (int i = 0; i < n; i++) {
        //    fast = fast.next;
        //}

        //ListNode slow = null;
        //while (fast != null) {
        //    fast = fast.next;
        //    // slow is nth pre node
        //    if (slow == null) {
        //        slow = head;
        //    } else {
        //        slow = slow.next;
        //    }
        //}

        //// only head node is nth
        //if (slow == null) {
        //    return head.next;
        //}

        //ListNode nthNode = slow.next;
        //slow.next = nthNode.next;
        //return head;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode first = head;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }

        ListNode second = dummy;
        while (first != null) {
            second = second.next;
            first = first.next;
        }
        
        second.next = second.next.next;
        return dummy.next;
    }
}

