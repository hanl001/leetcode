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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper1(root, list);
        return list;
    }

    private void helper0(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        helper0(root.left, list);
        list.add(root.val);
        helper0(root.right, list);
    }

    private void helper1(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        TreeNode visted = null;
        while (!deque.isEmpty()) {
            TreeNode node = deque.peekLast();
            while (node.left != visted && node.left != null) {
                deque.offerLast(node.left);
                node = node.left;
            }
            visted = node;
            list.add(node.val);
            deque.pollLast();
            if (node.right != null) {
                deque.offerLast(node.right);
            }
        }
    }
}
