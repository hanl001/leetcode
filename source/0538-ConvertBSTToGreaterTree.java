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
    public TreeNode convertBST(TreeNode root) {
        count(root);
        return root;
    }

    private int curVal = 0;
    private void count(TreeNode root) {
        if (root == null) {
            return;
        }
        count(root.right);
        curVal += root.val;
        root.val = curVal;
        count(root.left);
    }
}
