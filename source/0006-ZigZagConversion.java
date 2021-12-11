class Solution {
    public String convert(String s, int numRows) {
        if (s.length() <= 1 || numRows <= 1) {
            return s;
        }
        int step = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += step) {
                sb.append(s.charAt(j));
                int index = j + 2 * (numRows - 1 - i);
                if (i > 0 && i < numRows - 1 && index < s.length()) {
                    sb.append(s.charAt(index));
                }
            }
        }
        return sb.toString();
    }
}
