class Solution {
    // [3,2,1,0,4]
    // [2,3,1,1,4]
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > maxIndex) {
                return false;
            }
            maxIndex = Math.max(i + nums[i], maxIndex);
        }
        return true;
    }
}
