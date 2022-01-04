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
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper1(root, list);
        return list;
    }

    class Content {
        Node node;
        int step;

        Content(Node node) {
            this.node = node;
        }
    }

    private void helper1(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        Deque<Content> deque = new LinkedList<>();
        Content content = new Content(root);
        deque.offerLast(content);
        while (!deque.isEmpty()) {
            Content curContent = deque.peekLast();
            Node node = curContent.node;
            int step = curContent.step;
            List<Node> children = node.children;
            if (children == null || children.size() == 0) {
                list.add(node.val);
                deque.pollLast();
            } else {
                if (step == children.size()) {
                    list.add(node.val);
                    deque.pollLast();
                } else {
                    Node cur = children.get(step);
                    Content nextContent = new Content(cur);
                    deque.offerLast(nextContent);
                    curContent.step++;
                }
            }
        }
    }

    private void helper0(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        List<Node> children = root.children;
        if (children != null) {
            for (Node child : children) {
                helper0(child, list);
            }
        }
        list.add(root.val);
    }
}
