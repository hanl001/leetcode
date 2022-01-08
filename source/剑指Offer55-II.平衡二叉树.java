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
    private boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        depth(root);
        return isBalanced;
    }

    private int depth(TreeNode root) {
        if (root == null || !isBalanced) {
            return 0;
        }
        int leftDepth = depth(root.left);
        if (!isBalanced) {
            return 0;
        }
        int rightDepth = depth(root.right);
        int gap = leftDepth - rightDepth;
        if (gap > 1 || gap < -1) {
            isBalanced = false;
        }
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
