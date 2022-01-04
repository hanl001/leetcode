/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper0(root, list);
        return list;
    }

    private void helper0(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        Deque<Node> deque = new LinkedList<Node>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            Node cur = deque.pollLast();
            list.add(cur.val);
            List<Node> children = cur.children; // when this is ArrayList
            if (children != null) {
                for (int i = children.size() - 1; i >= 0; i--) {
                    deque.offerLast(children.get(i));
                }
            }
        }
    }

    private void helper1(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                helper1(child, list);
            }
        }
    }
}
