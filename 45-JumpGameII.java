class Solution {
    public int jump(int[] nums) {
        int maxStep = 0;
        int i = 0;
        int currentEnd = 0;
        int count = 0;
        while (i < nums.length - 1) {
            maxStep = Math.max(maxStep, nums[i] + i);
            if (i == currentEnd) {
                ++count;
                currentEnd = maxStep;
            }
            ++i;
        }
        return count;
    }
}
