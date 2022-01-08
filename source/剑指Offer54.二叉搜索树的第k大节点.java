/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private int kthLargest = 0;
    private int index = 0;
    public int kthLargest(TreeNode root, int k) {
        index = k;
        helper(root);
        return kthLargest;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        if (index <= 0) {
            return;
        }
        helper(root.right);
        if (index <= 0) {
            return;
        }
        index--;
        if (index == 0) {
            kthLargest = root.val;
            return;
        }
        helper(root.left);
    }
}
