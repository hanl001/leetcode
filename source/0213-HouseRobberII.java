class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(helper(nums, 1, nums.length - 1), helper(nums, 0, nums.length - 2));
    }

    private int helper(int[] nums, int from, int to) {
        int dp0 = 0;
        int dp1 = 0;
        while (from <= to) {
            int temp = dp1;
            dp1 = Math.max(dp0 + nums[from++], dp1);
            dp0 = temp;
        }
        return dp1;
    }
}
