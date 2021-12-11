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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (head != null && head.next != null) {
            ListNode headNextNext = head.next.next;
            cur.next = head.next;
            cur.next.next = head;
            head = headNextNext;
            cur = cur.next.next;
        }

        if (head != null) {
            cur.next = head;
        } else {
            cur.next = null;
        }

        return dummy.next;
    }
}
