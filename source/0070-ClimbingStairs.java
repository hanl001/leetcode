class Solution {
    // 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    public int climbStairs(int n) {
        int dp1 = 1;
        if (n == 1) {
            return dp1;
        }
        int dp2 = 2; // default value is n == 2
        for (int i = 2; i < n; ++i) {
            int temp = dp1;
            dp1 = dp2;
            dp2 = dp2 + temp;
        }
        return dp2;
    }
}
