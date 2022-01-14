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

    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        helper(root, target, new ArrayList<Integer>());
        return result;
    }

    private void helper(TreeNode root, int target, List<Integer> path) {
        if (root == null) {
            return;
        }
        
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == target) {
            List<Integer> item = new ArrayList(path);
            result.add(item);
        }
        helper(root.left, target - root.val, path);
        helper(root.right, target - root.val, path);
        path.remove(path.size() - 1);
    }
}
