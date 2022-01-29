class Solution {
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        List<String> path = new ArrayList<>();
        dfs(beginWord, endWord, wordList, visited, path);
        return path;
    }

    private boolean isMath = false;
    private void dfs(String curWord, String endWord, List<String> wordList, Set<String> visited, List<String> path) {
        if (visited.contains(curWord)) {
            return;
        }
        visited.add(curWord);
        path.add(curWord);
        if (curWord.equals(endWord)) {
            isMath = true;
            return;
        }
        for (String next : getNextList(curWord, wordList)) {
            dfs(next, endWord, wordList, visited, path);
            if (isMath) {
                return;
            }
        }
        path.remove(path.size() - 1);
    }

    private List<String> bfs(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        Map<String, String> precursor = new HashMap<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size--;
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    List<String> list = new LinkedList<>();
                    while (cur != null) {
                        list.add(0, cur);
                        cur = precursor.get(cur);
                    }
                    return list;
                }
                for (String next : getNextList(cur, wordList)) {
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                        precursor.put(next, cur);
                    }
                }
            }
        }
        return new ArrayList<>();
    }

    private List<String> getNextList(String word, List<String> wordList) {
        List<String> list = new ArrayList<>();
        for (String w : wordList) {
            if (isNext(word, w)) {
                list.add(w);
            }
        }
        return list;
    }

    private boolean isNext(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                count++;
            }
        }
        return count == word2.length() - 1;
    }
}
