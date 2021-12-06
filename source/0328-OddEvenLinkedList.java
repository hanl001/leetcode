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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddDummy = new ListNode();
        ListNode oddTail = oddDummy;
        ListNode evenDummy = new ListNode();
        ListNode evenTail = evenDummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            oddTail.next = cur;
            oddTail = oddTail.next;
            evenTail.next = cur.next;
            evenTail = evenTail.next;
            cur = cur.next.next;
            oddTail.next = null;
            evenTail.next = null;
        }

        if (cur != null) {
            oddTail.next = cur;
            oddTail = oddTail.next;
        }

        oddTail.next = evenDummy.next;

        return oddDummy.next;
    }
}
