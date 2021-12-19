/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return helper2(l1, l2);
    }
    
    private ListNode helper2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode cur = null;
        ListNode next = null;
        if (l1.val < l2.val) {
            cur = l1;
            next = helper2(l1.next, l2);
        } else {
            cur = l2;
            next = helper2(l1, l2.next);
        }
        cur.next = next;
        return cur;
    }

    private ListNode helper1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
            //tail.next = null; // 因为最后一次遍历 tail.next 就是 null 所以无需加这一行
        }

        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }

        return dummy.next;
    }
}
