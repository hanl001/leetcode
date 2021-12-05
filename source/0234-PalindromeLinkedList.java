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
    public boolean isPalindrome(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        ListNode fliped = new ListNode();
        while (quick != null && quick.next != null) {
            ListNode slowNext = slow.next;
            ListNode quickNext = quick.next.next;
            ListNode next = fliped.next;
            fliped.next = slow;
            slow.next = next;

            slow = slowNext;
            quick = quickNext;
        }

        if (quick != null) {
            slow = slow.next;
        }

        fliped = fliped.next;
        while (slow != null) {
            if (slow.val != fliped.val) {
                return false;
            }
            slow = slow.next;
            fliped = fliped.next;
        }

        return true;
    }
}
