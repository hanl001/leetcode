/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        ListNode prevSlow = null;
        while (fast != null && fast.next != null) {
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prevSlow.next = null;
        
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        
        ListNode ret = merge(left, right);
        return ret;
    }
    
    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(0);
        ListNode prev = head;
        while (left != null && right != null) {
            if (left.val < right.val) {
                prev.next = left;
                prev = prev.next;
                left = left.next;
            } else {
                prev.next = right;
                prev = prev.next;
                right = right.next;
            }
        }
        if (left != null) {
            prev.next = left;
        }
        if (right != null) {
            prev.next = right;
        }
        
        return head.next;
    }
}

