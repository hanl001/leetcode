class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return start;
    }
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int value = nums[mid];
            if ((mid == 0 && value >= target) ||
            (mid > 0 && value >= target && nums[mid - 1] < target)) {
                return mid;
            } else if (value < target) {
                if (mid == nums.length - 1) {
                    return nums.length;
                } else {
                    l = mid + 1;
                }
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
