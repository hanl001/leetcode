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

    private Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int inl, int inr, int postl, int postr) {
        if (inl > inr) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postr]);
        int i = map.get(root.val);
        root.left = helper(inorder, postorder, inl, i - 1, postl, postl + i - 1 - inl);
        root.right = helper(inorder, postorder, i + 1, inr, postl + i - inl, postr - 1);
        return root;
    }
}
