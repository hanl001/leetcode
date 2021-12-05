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
    public ListNode removeElements(ListNode head, int val) {
        return helper2(head, val);
    }

    private ListNode helper0(ListNode head, int val) {
        if (head == null) return null;
        head.next = helper0(head.next, val);
        return head.val == val ? head.next : head;
    }

    private ListNode helper1(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    private ListNode helper2(ListNode head, int val) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val != val) {
                tail.next = cur;
                tail = tail.next;
            } 
            cur = cur.next;
            tail.next = null;
        }
        return dummy.next;
    }
}
