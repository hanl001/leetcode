class Solution {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            // 剪多长
            for (int j = 2; j < i; j++) {
                // 剪
                dp[i] = Math.max(dp[i - j] * j, dp[i]);
                // 不剪
                dp[i] = Math.max((i - j) * j, dp[i]);
            }
        }
        return dp[n];
    }
}
