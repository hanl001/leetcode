class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        // 兼容 endWord 不在 wordList 的情况 （beginWord 可以不在 wordList）
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);

        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);
        
        int step = 0;
        while (endSet.size() > 0 && beginSet.size() > 0) {
            step++;
            // 保证总是查找元素少的一边
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextSet = new HashSet<>();
            for (String cur : beginSet) {
                for (String next : getNextWordList(cur, wordSet)) {
                    if (endSet.contains(next)) {
                        return step + 1;
                    }
                    if (visited.contains(next)) {
                        continue;
                    }
                    nextSet.add(next);
                    visited.add(next);
                }
            }
            beginSet = nextSet;
        }
        return 0;
    }

    private List<String> getNextWordList(String word, Set<String> wordSet) {
        List<String> list = new ArrayList<>();
        char[] wordChars = word.toCharArray();
        for (int i = 0; i < wordChars.length; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == wordChars[i]) {
                    continue;
                }
                char temp = wordChars[i];
                wordChars[i] = c;
                String next = new String(wordChars);
                if (wordSet.contains(next)) {
                    list.add(next);
                }
                wordChars[i] = temp;
            }
        }
        return list;
    }
}
