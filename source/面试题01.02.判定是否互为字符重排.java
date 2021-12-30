class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char s : s1.toCharArray()) {
            map.compute(s, (k, v) -> {
                 if (v == null) {
                     v = 0;
                 }
                return v + 1;
             });
        }

        for (char s : s2.toCharArray()) {
            int count = map.getOrDefault(s, 0);
            if (count == 0) {
                return false;
            }
            map.put(s, count - 1);
        }
        for (int value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}

class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] list1 = s1.toCharArray();
        char[] list2 = s2.toCharArray();
        Arrays.sort(list1);
        Arrays.sort(list2);
        for (int i = 0; i < list1.length; i++) {
            if (list1[i] != list2[i]) {
                return false;
            }
        }
        return true;
    }
}
