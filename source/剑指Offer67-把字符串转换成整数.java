class Solution {
    public int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        if (chars.length == 0) {
            return 0;
        }

        int sign = 0, start = 0;
        if (chars[0] == '-') {
            sign = -1;
            start = 1;
        } else if (chars[0] == '+') {
            sign = 1;
            start = 1;
        } else {
            sign = 1;
            start = 0;
        }

        int ret = 0;
        for (int i = start; i < chars.length; i++) {
            if (!Character.isDigit(chars[i])) {
                break;
            }
            int cur = chars[i] - '0';
            if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && cur > Integer.MAX_VALUE % 10)) {
                if (sign > 0) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            ret = ret * 10 + cur;
        }
        return ret * sign;
    }
}
