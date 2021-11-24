class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, maxLength = 0;

        Map<String, Integer> map = new HashMap<String, Integer>();
        
        while (end < s.length()) {
            String curString = String.valueOf(s.charAt(end));

            if (map.containsKey(curString) && map.get(curString) >= start) {
                start = map.get(curString) + 1;
            }

            maxLength = Math.max(maxLength, end - start + 1);

            map.put(curString, end++);
        }

        return maxLength;
    }
}

