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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper0(root, list);
        return list;
    }

    private void helper0(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        helper0(root.left, list);
        helper0(root.right, list);
        list.add(root.val);
    }
}
