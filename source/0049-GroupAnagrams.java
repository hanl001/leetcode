class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return helper0(strs);
    }

    private List<List<String>> helper0(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            String key = getSortedString(str);
            List<String> value = map.getOrDefault(key, new ArrayList<String>());
            value.add(str);
            map.put(key, value);
        }
        return new ArrayList<List<String>>(map.values());
    }

    private String getSortedString(String str) {
        char[] s1 = str.toCharArray();
        int[] list = new int[26];
        for (char c : s1) {
            list[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            int count = list[i];
            if (count == 0) {
                continue;
            }
            char ch = (char)(i + 'a');
            while (count > 0) {
                sb.append(ch);
                count--;
            }
        }
        return sb.toString();
    }

    private List<List<String>> helper1(String[] strs) {
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
