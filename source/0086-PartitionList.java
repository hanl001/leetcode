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
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = null;
        ListNode leftTail = null;
        ListNode rightHead = null;
        ListNode rightTail = null;

        while (head != null) {
            if (head.val < x) {
                if (leftHead == null) {
                    leftHead = head;
                    leftTail = head;
                } else {
                    leftTail.next = head;
                    leftTail = leftTail.next;
                }
            } else {
                if (rightHead == null) {
                    rightHead = head;
                    rightTail = head;
                } else {
                    rightTail.next = head;
                    rightTail = rightTail.next;
                }
            }
            ListNode preHead = head;
            head = head.next;
            preHead.next = null;
        }

        if (leftTail != null) {
            leftTail.next = rightHead;
        }

        if (leftHead == null) {
            return rightHead;
        } else {
            return leftHead;
        }
    }
}
