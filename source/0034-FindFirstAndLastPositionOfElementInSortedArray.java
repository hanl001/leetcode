class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int lIndex = -1;
        int rIndex = -1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int value = nums[mid];
            if (value == target) {
                lIndex = findLeftTarget(nums, l, mid, target);
                rIndex = findRightTarget(nums, mid, r, target);
                break;
            } else if (value > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return new int[]{lIndex, rIndex};
    }

    private int findLeftTarget(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int value = nums[mid];
            if ((mid == 0 && value == target) || 
            (mid > 0 && value == target && nums[mid - 1] < target)) {
                return mid;
            } else if (value >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    private int findRightTarget(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) >>> 1;
            int value = nums[mid];
            if ((mid == nums.length - 1 && value == target) || 
            (mid < nums.length - 1 && value == target && nums[mid + 1] > target)) {
                return mid;
            } else if (value > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
