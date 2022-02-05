class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }

        sum /= 2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        if (nums[0] <= sum) {
            dp[nums[0]] = true;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[sum];
    }
}
