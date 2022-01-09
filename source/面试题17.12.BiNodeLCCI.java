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

    private TreeNode dummy = new TreeNode(-1);
    private TreeNode pre;
    public TreeNode convertBiNode(TreeNode root) {
        pre = dummy;
        helper(root);
        return dummy.right;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        pre.right = root;
        pre = pre.right;
        pre.left = null; // root.left = null
        helper(root.right);
    }
}
