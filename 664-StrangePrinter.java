class Solution {
    public int strangePrinter(String s) {
        int length = s.length;
        if (length <= 0) {
            return 0;
        }
        int[][] dp = new int[length - 1][length - 1];
        for (int i = 0; i < length; ++i) {
        }
        return dp[0][length - 1];
    }
}
