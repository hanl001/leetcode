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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList = getParentNodeList(root, p);
        Set<TreeNode> qSet = getParentNodeSet(root, q);
        for (int i = pList.size() - 1; i >= 0; i--) {
            TreeNode pNode = pList.get(i);
            if (qSet.contains(pNode)) {
                return pNode;
            }
        }
        return null;
    }

    private List<TreeNode> getParentNodeList(TreeNode root, TreeNode p) {
        List<TreeNode> pList = new ArrayList<>();
        while (root != null) {
            pList.add(root);
            if (root == p) {
                break;
            }
            if (p.val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return pList;
    }

    private Set<TreeNode> getParentNodeSet(TreeNode root, TreeNode p) {
        Set<TreeNode> pSet = new HashSet<>();
        while (root != null) {
            pSet.add(root);
            if (root == p) {
                break;
            }
            if (p.val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return pSet;
    }
}
