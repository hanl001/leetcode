class Trie {

    class Node {

        boolean isEnd;

        // Map<Character, Node> childrens;
        Node[] childrens;

        Node() {
            this.childrens = new Node[26];
        }
    }

    private Node root = new Node();
    public Trie() {

    }
    
    public void insert(String word) {
        Node cur = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            Node node = cur.childrens[i];
            if (node == null) {
                node = new Node();
                cur.childrens[i] = node;
            }
            cur = node;
        }
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        Node cur = root;
        for (char ch : word.toCharArray()) {
            Node node = cur.childrens[ch - 'a'];
            if (node == null) {
                return false;
            }
            cur = node;
        }
        return cur.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char ch : prefix.toCharArray()) {
            Node node = cur.childrens[ch - 'a'];
            if (node == null) {
                return false;
            }
            cur = node;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
