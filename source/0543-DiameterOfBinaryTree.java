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
    public int diameterOfBinaryTree(TreeNode root) {
        length(root);
        return maxLength;
    }

    private int maxLength = 0;
    private int length(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = length(root.left);
        int right = length(root.right);
        maxLength = Math.max(maxLength, left + right);
        return 1 + Math.max(left, right);
    }
}
