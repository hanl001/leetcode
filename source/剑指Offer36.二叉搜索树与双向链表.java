/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        pre = dummyHead;
        helper(root);
        pre.right = dummyHead.right;
        dummyHead.right.left = pre;
        return dummyHead.right;
    }

    private Node dummyHead = new Node(-1);
    private Node pre;

    private void helper(Node root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        pre.right = root;
        root.left = pre;
        pre = root;
        helper(root.right);
    }
}
