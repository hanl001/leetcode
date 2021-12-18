class Solution {
    public int waysToStep(int n) {
        // memo
        // int[] memo = new int[n + 1];
        // return helper(n, memo);

        int dp1 = 1;
        int dp2 = 2;
        int dp3 = 4;
        if (n == 1) {
            return dp1;
        }
        if (n == 2) {
            return dp2;
        }
        if (n == 3) {
            return dp3;
        }
        int mod = 1000000007;
        for (int i = 4; i <= n; i++) {
            int value = (dp1 + dp2) % mod;
            value = (value + dp3) % mod;
            dp1 = dp2;
            dp2 = dp3;
            dp3 = value;
        }
        return dp3;
    }

    private int helper(int n, int[] memo) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        int mod = 1000000007;
        int value = helper(n - 3, memo) % mod;
        value = (value + helper(n - 2, memo)) % mod;
        value = (value + helper(n - 1, memo)) % mod;
        memo[n] = value;
        return memo[n];
    }
}
