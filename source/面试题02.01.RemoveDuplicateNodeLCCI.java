/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (head != null) {
            if (!set.contains(head.val)) {
                cur.next = head;
                cur = cur.next;
                set.add(head.val);
            }
            head = head.next;
        }
        cur.next = null;
        return dummy.next;
    }
}
