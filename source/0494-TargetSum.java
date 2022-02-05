class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if (target < 0) {
            target = -target;
        }
        // a + b = sum
        // a - b = target
        // a = (sum + target) / 2
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int a = sum + target;
        if (a % 2 == 1) {
            return 0;
        }
        a /= 2;

        int dp[] = new int[a + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = a; j >= num; j--) {
                dp[j] = dp[j] + dp[j - num];
            }
        }
        return dp[a];
    }
}
