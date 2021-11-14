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
