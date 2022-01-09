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

    private Map<Integer, Integer> rootIndexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            rootIndexMap.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl > pr || il > ir) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pl]);
        int i = rootIndexMap.get(root.val);
        // int i = il;
        // while (root.val != inorder[i]) {
        //     i++;
        // }
        root.left = helper(preorder, inorder, pl + 1, pl + i - il, il, i - 1);
        root.right = helper(preorder, inorder, pl + i - il + 1, pr, i + 1, ir);
        return root;
    }
}
