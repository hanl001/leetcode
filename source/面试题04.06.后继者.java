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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        helper(root, p);
        return result;
    }

    private TreeNode prev;
    private TreeNode result;
    private void helper(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        if (result != null) {
            return;
        }
        helper(root.right, p);
        if (result != null) {
            return;
        }
        if (root == p) {
            result = prev;
            return;
        }
        prev = root;
        helper(root.left, p);
    }
}
