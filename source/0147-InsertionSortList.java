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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        while (head != null) {
            ListNode next = head.next;
            head.next =  null;
            ListNode pre = dummy;
            while (pre.next != null && pre.next.val < head.val) {
                pre = pre.next;
            }
            ListNode preNext = pre.next;
            pre.next = head;
            pre.next.next = preNext;
            head = next;
        }
        return dummy.next;
    }
}
