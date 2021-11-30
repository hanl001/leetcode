class Solution {
    public boolean isStraight(int[] nums) {
        boolean[] values = new boolean[14];
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int num : nums) {
            if (values[num]) {
                return false;
            }
            if (num == 0) {
                continue;
            }
            values[num] = true;
            maxValue = Math.max(maxValue, num);
            minValue = Math.min(minValue, num);
        }
        return maxValue - minValue < 5;
    }
}
