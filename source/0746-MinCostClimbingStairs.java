class Solution {
    /* *
     * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
     * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
     * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
     * */

    // 条件：
    // cost 的长度范围是 [2, 1000]。
    // cost[i] 将会是一个整型数据，范围为 [0, 999] 。
    public int minCostClimbingStairs(int[] cost) {
        //int[] dp = new int[cost.length + 1];
        //// 初始台阶无消耗
        //dp[0] = 0;
        //dp[1] = 0;
        //for (int i = 2; i <= cost.length; ++i) {
        //    dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        //}
        //return dp[cost.length];

        // 降纬
        int dp0 = 0;
        int dp1 = 0;
        for (int i = 2; i <= cost.length; ++i) {
            int oldDp1 = dp1;
            dp1 = Math.min(dp1 + cost[i - 1], dp0 + cost[i - 2]);
            dp0 = oldDp1;
        }
        return dp1;
    }
}
