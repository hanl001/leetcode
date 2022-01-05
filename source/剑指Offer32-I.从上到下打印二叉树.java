/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            list.add(node.val);
            if (node.left != null) {
                deque.offerLast(node.left);
            }
            if (node.right != null) {
                deque.offerLast(node.right);
            }
        }
        int[] ret = new int[list.size()];
        int i = 0;
        for (int v : list) {
            ret[i++] = v;
        }
        return ret;
    }
}
