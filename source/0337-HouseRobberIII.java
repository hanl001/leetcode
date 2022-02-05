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
    public int rob(TreeNode root) {
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }

    public int[] helper(TreeNode root) {
        int[] result = new int[2];
        if (root == null) {
            return result;
        }
        int[] result_left = helper(root.left);
        int[] result_right = helper(root.right);
        // no root
        result[0] = Math.max(result_left[0], result_left[1]) + Math.max(result_right[0], result_right[1]);
        // use root
        result[1] = root.val + result_left[0] + result_right[0];

        return result;
    }

    //public int rob(TreeNode root) {
    //    HashMap<TreeNode, Integer> memo = new HashMap<>();
    //    return helper(root, memo);
    //}

    //public int helper(TreeNode root, HashMap<TreeNode, Integer> memo) {
    //    if (root == null) {
    //        return 0;
    //    }
    //    if (memo.containsKey(root)) {
    //        return memo.get(root);
    //    }

    //    int money = root.val;
    //    if (root.left != null) {
    //        money = money + rob(root.left.left) + rob(root.left.right);
    //    }
    //    if (root.right != null) {
    //        money = money + rob(root.right.left) + rob(root.right.right);
    //    }
    //    int result = Math.max(money, rob(root.left) + rob(root.right));
    //    memo.put(root, result);
    //    return result;
    //}
}
