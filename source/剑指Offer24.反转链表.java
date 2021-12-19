/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // List<ListNode> ret = helper1(head);
        // if (ret == null) {
        //     return null;
        // }
        // return ret.get(0);
        return helper3(head);
    }

    private List<ListNode> helper1(ListNode head) {
        if (head == null) {
            return null;
        }
        List<ListNode> ret = helper1(head.next);
        if (ret == null) {
            List<ListNode> list = new ArrayList<>();
            list.add(head);
            list.add(head);
            return list;
        }
        ListNode newHead = ret.get(0);
        ListNode tail = ret.get(1);
        tail.next = head;
        tail = tail.next;
        tail.next = null;
        List<ListNode> list = new ArrayList<>();
        list.add(newHead);
        list.add(tail);
        return list;
    }

    private ListNode helper2(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode cur = head;
        while (cur != null) {
            ListNode tail = dummy.next;
            dummy.next = cur;
            ListNode curNext = cur.next;
            cur.next = tail;
            cur = curNext;
        }
        return dummy.next;
    }

    private ListNode helper3(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
