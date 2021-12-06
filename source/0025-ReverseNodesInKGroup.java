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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        ListNode cur = head;
        ListNode tail = dummy;
        while (cur != null) {
            ListNode newTail = cur;
            ListNode curDummy = new ListNode();
            boolean isBreaked = false;
            for (int i = 0; i < k; i++) {
                if (cur == null) {
                    isBreaked = true;
                    break;
                }
                ListNode curDummyNext = curDummy.next;
                ListNode curNext = cur.next;
                curDummy.next = cur;
                cur.next = curDummyNext;
                cur = curNext;
            }
            if (isBreaked) {
                cur = curDummy.next;
                while (cur != null) {
                    ListNode tailNext = tail.next;
                    ListNode curNext = cur.next;
                    tail.next = cur;
                    cur.next = tailNext;
                    cur = curNext;
                }
            } else {
                tail.next = curDummy.next;
                tail =  newTail;
            }
        }

        return dummy.next;
    }
}
