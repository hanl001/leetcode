class Solution {
    public int findRepeatNumber(int[] nums) {
        boolean[] map = new boolean[100000];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map[num]) {
                return num;
            }
            map[num] = true;
        }
        return -1;
    }
}
