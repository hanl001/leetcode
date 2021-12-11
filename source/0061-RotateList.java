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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            length++;
        }
        k %= length;
        if (k == 0) {
            return head;
        }

        ListNode pre = null;
        for (int i = 0; i < length - k; i++) {
            if (pre == null) {
                pre = head;
            } else {
                pre = pre.next;
            }
        }

        ListNode newHead = pre.next;
        ListNode tail = newHead;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        pre.next = null;
        return newHead;
    }
}
