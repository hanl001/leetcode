class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        StringBuilder stringBuilder = new StringBuilder("");
        int charIndex = 0;
        boolean isSame = true;
        while (isSame) {
            for (int i = 0; i < strs.length - 1; i++) {
                String curString = strs[i];
                String nextString = strs[i + 1];
                if (charIndex >= curString.length() || charIndex >= nextString.length()) {
                    isSame = false;
                    break;
                }
                if (curString.charAt(charIndex) != nextString.charAt(charIndex)) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                stringBuilder.append(strs[0].charAt(charIndex));
                charIndex++;
            }
        }
        return stringBuilder.toString();
    }
}
