class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private HashMap<Integer, Node> map = new HashMap<>();

    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;

        return node.value;
    }
    
    public void put(int key, int value) {
         Node node = map.get(key);
        if (node == null) {
            if (map.size() == capacity) {
                Node willRemoved = tail.prev;
                willRemoved.prev.next = tail;
                tail.prev = willRemoved.prev;
                map.remove(willRemoved.key);
            }
            Node newNode = new Node(key, value);
            newNode.next = head.next;
            head.next = newNode;
            newNode.next.prev = newNode;
            newNode.prev = head;
            map.put(key, newNode);
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;

            node.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
