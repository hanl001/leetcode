class Solution {
    public int maxPower(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int maxPower = 1;
        int curPower = 1;
        char curCh = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (curCh == s.charAt(i)) {
                curPower++;
                maxPower = Math.max(maxPower, curPower);
            } else {
                curCh = s.charAt(i);
                curPower = 1;
            }
        }
        return maxPower;
    }
}
