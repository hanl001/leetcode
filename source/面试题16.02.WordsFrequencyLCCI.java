class WordsFrequency {

    private Map<String, Integer> map = new HashMap<>();

    public WordsFrequency(String[] book) {
        for (String word : book) {
            // int frequency = map.getOrDefault(word, 0);
            // map.put(word, frequency + 1);
            map.compute(word, (k, v) -> {
                if (v == null) v = 0;
                return v + 1;
            });
        }
    }
    
    public int get(String word) {
        return map.getOrDefault(word, 0);
    }
}

/**
 * Your WordsFrequency object will be instantiated and called as such:
 * WordsFrequency obj = new WordsFrequency(book);
 * int param_1 = obj.get(word);
 */
