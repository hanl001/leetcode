class Solution {
    public int numWays(int n) {
        return helper3(n);
    }

    // direct recursive O(2^n) will timeout
    private int helper1(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int mod = 1000000007;
        return (helper1(n - 1) % mod + helper1(n - 2) % mod) % mod;
    }

    // O(n) memo
    private int helper2(int n) {
        int[] memo = new int[n + 1];
        return helper2(n, memo);
    }

    private int helper2(int n, int[] memo) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        int mod = 1000000007;
        memo[n] = (helper2(n - 1, memo) % mod + helper2(n - 2, memo) % mod) % mod;
        return memo[n];
    }

    // dp O(n)
    private int helper3(int n) {
        int dp0 = 1;
        int dp1 = 1;
        if (n == 0) {
            return dp0;
        }
        int mod = 1000000007;
        for (int i = 2; i <= n; i++) {
            int newDp0 = dp1;
            dp1 = (dp0 + dp1) % mod;
            dp0 = newDp0;
        }
        return dp1;
    }
}
