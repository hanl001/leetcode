class Solution {
    /*
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * */
    public void moveZeroes(int[] nums) {
        // 法1: 冒泡
        //for (int j = 1; j < nums.length; ++j) {
        //    for (int i = 0; i < nums.length - j; ++i) {
        //        if (nums[i] == 0) {
        //            nums[i] = nums[i + 1];
        //            nums[i + 1] = 0;
        //        }
        //    }
        //}

        // 法2: 记录非 0 个数
        //int index = 0;
        //for (int num : nums) {
        //    if (num != 0) {
        //        nums[index++] = num;
        //    }
        //}
        //while (index < nums.length) {
        //    nums[index++] = 0;
        //}

        // 法3: 双同向指针
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                if (left < right) {
                    nums[left] = nums[left] + nums[right];
                    nums[right] = nums[left] - nums[right];
                    nums[left] = nums[left] - nums[right];
                }
                ++left;
            }
            ++right;
        }
    }
}
