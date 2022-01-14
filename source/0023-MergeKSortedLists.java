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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int count = lists.length;
        while (count > 1) {
            boolean isEven = count % 2 == 0;
            int mid = isEven ? count / 2 : count / 2 + 1;
            for (int i = 0; i < mid; i++) {
                if (!isEven && i == mid - 1) {
                    lists[i] = lists[2 * i];
                } else {
                    lists[i] = mergeList(lists[2 * i], lists[2 * i + 1]);
                }
            }
            count = mid;
        }
        return lists[0];
    }

    private ListNode mergeList(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else if (left.val > right.val) {
                tail.next = right;
                right = right.next;
            } else {
                tail.next = left;
                left = left.next;
                tail = tail.next;
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        if (left != null) {
            tail.next = left;
        } 
        if (right != null) {
            tail.next = right;
        }
        return dummy.next;
    }

    private ListNode helper(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b)->(a.val - b.val));
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            tail.next = cur;
            if (cur.next != null) {
                pq.offer(cur.next);
            }
            tail = tail.next;
        }
        return dummy.next;
    }
}
