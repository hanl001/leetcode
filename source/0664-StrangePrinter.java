class Solution {
    public int strangePrinter(String s) {
        int length = s.length();
        if (length <= 0) {
            return 0;
        }
        int[][] dp = new int[length][length];
        for (int i = length - 1; i >= 0; --i) {
            for (int j = i; j < length; ++j) {
                if (i == j) {
                    dp[i][i] = 1;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        int min = Integer.MAX_VALUE;
                        for (int k = i; k < j; ++k) {
                            min = Math.min(min, dp[i][k] + dp[k + 1][j]);
                        }
                        dp[i][j] = min;
                    }
                }
            }
        }
        return dp[0][length - 1];
    }
}
