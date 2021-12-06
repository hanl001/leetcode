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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private ListNode curNode;

    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        curNode = head;
        return helper(0, length);
    }

    private TreeNode helper(int start, int end) {
        if (start >= end) {
            return null;
        }
        TreeNode root = new TreeNode();
        int mid = start + (end - start) / 2;
        root.left = helper(start, mid);
        root.val = curNode.val;
        curNode = curNode.next;
        root.right = helper(mid + 1, end);
        return root;
    }
}
