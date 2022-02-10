class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length + 1][2];
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = 1;
            int j = 1;
            while (j < i) {
                if (nums[i - 1] > nums[j - 1]) {
                    dp[i][1] = Math.max(dp[i][1], 1 + dp[j][1]);
                }
                j++;
            }
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }
}
