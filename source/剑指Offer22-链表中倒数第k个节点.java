/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     * 返回链表 4->5.
     * */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (k == 0) {
            return null;
        }

        ListNode fast = head;
        while (k > 1) { // fast 走到第 k 个
            fast = fast.next;
            k--;
            if (k > 1 && fast == null) {
                return null;
            }
        }

        ListNode slow = head;
        while (fast != null && fast.next != null) { // fast 走到最后一个元素
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
