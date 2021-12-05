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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (tail == dummy || tail.val != cur.val) {
                tail.next = cur;
                cur = cur.next;
                tail = tail.next;
                tail.next = null;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
