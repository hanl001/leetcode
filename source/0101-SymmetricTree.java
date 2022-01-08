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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    private boolean isSymmetric = true;
    private boolean helper(TreeNode left, TreeNode right) {
        if (!isSymmetric) {
            return isSymmetric;
        }

        if (left == null && right == null) {
            return isSymmetric;
        }

        if (left == null || right == null) {
            isSymmetric = false;
            return isSymmetric;
        }

        if (left.val != right.val) {
            isSymmetric = false;
            return isSymmetric;
        }

        isSymmetric = helper(left.left, right.right);
        if (!isSymmetric) {
            return isSymmetric;
        }
        
        isSymmetric = helper(left.right, right.left);
        return isSymmetric;
    }
}
