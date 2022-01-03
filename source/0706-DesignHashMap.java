class MyHashMap {

    int[] map = new int[1000001];

    public MyHashMap() {
        for (int i = 0; i <= 1000000; i++) {
            map[i] = -1;
        }
    }
    
    public void put(int key, int value) {
        map[key] = value;
    }
    
    public int get(int key) {
        return map[key];
    }
    
    public void remove(int key) {
        map[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

class MyHashMap {

    class Node {
        int key;
        int value;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node[] map = new Node[100001];

    public MyHashMap() {
    }

    public void put(int key, int value) {
        int index = key / 10;
        Node cur = map[index];
        if (cur == null) {
            map[index] = new Node(key, value);
        } else {
            while (cur.next != null) {
                if (cur.key == key) {
                    cur.value = value;
                    return;
                }
                cur = cur.next;
            }
            if (cur.key == key) {
                cur.value = value;
            } else {
                cur.next = new Node(key, value);
            }
        }
    }

    public int get(int key) {
        int index = key / 10;
        Node cur = map[index];
        while (cur != null) {
            if (cur.key == key) {
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = key / 10;
        Node cur = map[index];
        Node dummy = new Node(-1, -1);
        dummy.next = cur;
        Node pre = dummy;
        while (pre.next != null) {
            if (pre.next.key == key) {
                pre.next = pre.next.next;
                break;
            }
            pre = pre.next;
        }
        map[index] = dummy.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
