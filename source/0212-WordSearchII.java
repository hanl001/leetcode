class Solution {

    class Trie {

        Trie[] children;

        String endWord;

        Trie() {
            this.children = new Trie[26];
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Trie cur = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                Trie node = cur.children[index];
                if (node == null) {
                    node = new Trie();
                    cur.children[index] = node;
                }
                cur = node;
            }
            cur.endWord = word;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                findWords(board, i, j, root, visited);
            }
        }
        List<String> list = new ArrayList<>();
        for (String v : set) {
            list.add(v);
        }
        return list;
    }

    private Set<String> set = new HashSet<>();

    private void findWords(char[][] board, int i, int j, Trie root, boolean[][] visited) {
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        int index = board[i][j] - 'a';
        Trie node = root.children[index];
        if (node == null) {
            visited[i][j] = false;
            return;
        }
        if (node.endWord != null) {
            set.add(node.endWord);
        }
        findWords(board, i + 1, j, node, visited);
        findWords(board, i - 1, j, node, visited);
        findWords(board, i, j + 1, node, visited);
        findWords(board, i, j - 1, node, visited);
        visited[i][j] = false;
    }
}
