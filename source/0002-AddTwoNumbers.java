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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        int remain = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + remain;
            l1.val = sum % 10;
            remain = sum / 10;

            tail.next = l1;
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
            tail.next = null;
        }

        while (l1 != null) {
            int sum = l1.val + remain;
            l1.val = sum % 10;
            remain = sum / 10;

            tail.next = l1;
            tail = tail.next;
            l1 = l1.next;
            tail.next = null;
        }

        while (l2 != null) {
            int sum = l2.val + remain;
            l2.val = sum % 10;
            remain = sum / 10;

            tail.next = l2;
            tail = tail.next;
            l2 = l2.next;
            tail.next = null;
        }

        if (remain > 0) {
            tail.next = new ListNode(remain);
        }

        return dummy.next;
    }
}
