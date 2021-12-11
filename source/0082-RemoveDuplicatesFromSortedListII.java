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
        ListNode cur = dummy;
        boolean latestNodeIsSame = false;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                latestNodeIsSame = true;
            } else {
                if (latestNodeIsSame) {
                    latestNodeIsSame = false;
                } else {
                    cur.next = head;
                    cur = cur.next;
                }
            }
            head = head.next;
        }
        if (!latestNodeIsSame && head != null) {
            cur.next = head;
        } else {
            cur.next = null;
        }
        return dummy.next;
    }
}
