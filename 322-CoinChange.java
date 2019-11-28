class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return amount > 0 ? -1 : 0;
        }

        int[] results = new int[amount + 1];
        results[0] = 0;
        for (int i = 1; i <= amount; i++) {
            results[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && results[i - coins[j]] != Integer.MAX_VALUE) {
                    results[i] = Math.min(results[i], results[i - coins[j]] + 1);
                }
            }
        }

        return results[amount] == Integer.MAX_VALUE ? -1 : results[amount];
    }
}
