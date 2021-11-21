class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int dp0 = 0;
        int dp1 = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int temp = dp1;
            dp1 = Math.max(dp0 + nums[i], dp1);
            dp0 = temp;
        }
        return dp1;
    }
}
