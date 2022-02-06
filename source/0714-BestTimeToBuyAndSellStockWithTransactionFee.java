class Solution {
    public int maxProfit(int[] prices, int fee) {
        // int[][] dp = new int[prices.length][2];
        // dp[0][0] = 0;
        // dp[0][1] = -prices[0] - fee;
        // for (int i = 1; i < prices.length; i++) {
        //     dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);// 卖时挣钱
        //     dp[i][1] = Math.max(dp[i - 1][0] - fee - prices[i], dp[i - 1][1]);// 买时扣钱
        // }
        // return dp[prices.length - 1][0];
        int buy = prices[0] + fee;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee; // 买个便宜的
            } else if (prices[i] > buy) { // 能挣钱
                maxProfit += prices[i] - buy;
                buy = prices[i]; // 不排除今后能继续挣钱
            }
        }
        return maxProfit;
    }
}
