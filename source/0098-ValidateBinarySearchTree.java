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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean isValidBST = true;
    private boolean isValidBST(TreeNode root, long max, long min) {
        if (!isValidBST) {
            return isValidBST;
        }
        if (root == null) {
            return isValidBST;
        }
        if (root.val >= max || root.val <= min) {
            isValidBST = false;
            return isValidBST;
        }
        isValidBST = isValidBST(root.left, root.val, min);
        if (!isValidBST) {
            return isValidBST;
        }
        isValidBST = isValidBST(root.right, max, root.val);
        return isValidBST;
    }
}
