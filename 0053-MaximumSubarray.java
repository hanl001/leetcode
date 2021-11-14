class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0], start = 0, end = 0;
        int result = sum;
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            result = Math.max(sum, result);
        }
        return result;
    }
}
