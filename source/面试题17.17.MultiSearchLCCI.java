class Solution {
    class Trie {

        Trie[] children;

        int isEnd;

        Trie() {
            this.isEnd = -1;
            this.children = new Trie[26];
        }
    }

    public int[][] multiSearch(String big, String[] smalls) {
        Trie trie = new Trie();
        for (int i = 0; i < smalls.length; i++) {
            String small = smalls[i];
            Trie cur = trie;
            for (char ch : small.toCharArray()) {
                int index = ch - 'a';
                Trie node = cur.children[index];
                if (node == null) {
                    node = new Trie();
                    cur.children[index] = node;
                }
                cur = node;
            }
            cur.isEnd = i;
        }
        List[] list = new ArrayList[smalls.length];
        for (int i = 0; i < big.length(); i++) {
            int end = i;
            Trie cur = trie;
            while (end < big.length()) {
                char ch = big.charAt(end);
                int index = ch - 'a';
                Trie node = cur.children[index];
                if (node == null) {
                    break;
                }
                cur = node;
                if (cur.isEnd > -1) {
                    List<Integer> item = list[cur.isEnd];
                    if (item == null) {
                        item = new ArrayList<Integer>();
                    }
                    item.add(i);
                    list[cur.isEnd] = item;
                } 
                end++;
            }
        }
        int[][] result = new int[smalls.length][];
        int i = 0;
        for (List<Integer> item : list) {
            if (item == null) {
                result[i++] = new int[0];
                continue;
            }
            int[] arr = new int[item.size()];
            int j = 0;
            for (int v : item) {
                arr[j++] = v;
            }
            result[i++] = arr;
        }
        return result;
    }
}
