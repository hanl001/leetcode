class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char tempArray[] = str.toCharArray();
            Arrays.sort(tempArray);
            String sortedString = new String(tempArray);
            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<String>());
            }
            map.get(sortedString).add(str);
        }

        return new ArrayList(map.values());
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Set<String> visted = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if (visted.contains(str)) {
                continue;
            }
            List<String> item = new ArrayList<>();
            item.add(str);
            visted.add(str);
            for (int j = i + 1; j < strs.length; j++) {
                if (isAnagrams(str, strs[j])) {
                    item.add(strs[j]);
                    visted.add(strs[j]);
                }
            }
            list.add(item);
        }
        return list;
    }

    private boolean isAnagrams(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        if (s1.length != s2.length) {
            return false;
        }
        int[] map = new int[26];
        for (char c : str1.toCharArray()) {
            map[c - 'a']++;
        }
        for (char c : str2.toCharArray()) {
            if (map[c - 'a'] == 0) {
                return false;
            }
            map[c - 'a']--;
        }
        return true;
    }
}
