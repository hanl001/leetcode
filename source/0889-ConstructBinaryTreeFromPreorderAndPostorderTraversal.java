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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return helper(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] postorder, int prel, int prer, int postl, int postr) {
        if (prel > prer) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[prel]);
        if (prel == prer) {
            return root;
        }
        int i = map.get(preorder[prel + 1]);
        root.left = helper(preorder, postorder, prel + 1, prel + 1 + i - postl, postl, i);
        root.right = helper(preorder, postorder, prel + 2 + i - postl, prer, i + 1, postr - 1);
        return root;
    }
}
