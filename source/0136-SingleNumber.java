class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            nums[i + 1] = nums[i] ^ nums[i + 1];
        }
        return nums[nums.length - 1];
    }
}
