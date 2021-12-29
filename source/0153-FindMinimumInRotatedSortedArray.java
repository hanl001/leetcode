class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        if (nums[l] <= nums[r]) {
            return nums[l];
        }
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int value = nums[mid];
            if (mid == 0) {
                l = mid + 1;
            } else if (nums[mid - 1] > value) {
                return value;
            } else {
                if (value >= nums[0]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
