class Solution {
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                stringBuilder.append(" ");
                ++i;
            } else {
                int start = i;
                while (i < s.length() && s.charAt(i) != ' ') {
                    ++i;
                }
                for (int j = i - 1; j >= start; --j) {
                    stringBuilder.append(s.charAt(j));
                }
            }
        }
        return new String(stringBuilder);
    }
}
