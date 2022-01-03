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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper2(root, list);
        return list;
    }

    private void helper0(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
    }

    class Content {
        int step;
        TreeNode node;

        Content(TreeNode node) {
            this.node = node;
        }
    }

    private void helper1(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        Deque<Content> deque = new LinkedList<>();
        Content rootContent = new Content(root);
        deque.offerLast(rootContent);
        while (!deque.isEmpty()) {
            Content content = deque.peekLast();
            if (content.step == 0) {
                list.add(content.node.val);
                content.step += 1;
            } else if (content.step == 1) {
                if (content.node.left != null) {
                    Content leftContent = new Content(content.node.left);
                    deque.offerLast(leftContent);
                }
                content.step += 1;
            } else if (content.step == 2) {
                if (content.node.right != null) {
                    Content rightContent = new Content(content.node.right);
                    deque.offerLast(rightContent);
                }
                content.step += 1;
            } else {
                deque.pollLast();
            }
        }
    }

    private void helper2(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollLast();
            list.add(node.val);
            if (node.right != null) {
                deque.offerLast(node.right);
            }
            if (node.left != null) {
                deque.offerLast(node.left);
            }
        }
    }
}
