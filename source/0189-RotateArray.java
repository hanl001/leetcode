class Solution {

    // MARK: - O(n) & O(1) 共遍历 1 * n，赋值 3 n
    //public void rotate(int[] nums, int k) {
    //    // 翻转数组
    //    int start = 0;
    //    int end = nums.length - 1;
    //    while (start < end) {
    //        nums[start] = nums[start] + nums[end];
    //        nums[end] = nums[start] - nums[end];
    //        nums[start] = nums[start] - nums[end];
    //        ++start;
    //        --end;
    //    }

    //    // 翻转 k 左右两边子数组
    //    k = k % nums.length;
    //    start = 0;
    //    end = k - 1;
    //    while (start < end) {
    //        nums[start] = nums[start] + nums[end];
    //        nums[end] = nums[start] - nums[end];
    //        nums[start] = nums[start] - nums[end];
    //        ++start;
    //        --end;
    //    }

    //    start = k;
    //    end = nums.length - 1;
    //    while (start < end) {
    //        nums[start] = nums[start] + nums[end];
    //        nums[end] = nums[start] - nums[end];
    //        nums[start] = nums[start] - nums[end];
    //        ++start;
    //        --end;
    //    }
    //}

    // MARK: - O(n) & O(1) 共遍历 1 * n，赋值 3 n, 存在一个临时变量
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0 || nums.length < 2) {
            return;
        }

        int count = 0;
        int i = 0;
        do {
            int temp = nums[i];
            int start = i;
            do {
                start = (start + k) % nums.length;
                temp = temp + nums[start];
                nums[start] = temp - nums[start];
                temp = temp - nums[start];
                ++count;
            } while (start != i);
            ++i;
        } while (count < nums.length); // 当 count 为 nums.length 时，表示结束 (n 与 k 的最小公约数表示需要遍历的次数)
    }
}

